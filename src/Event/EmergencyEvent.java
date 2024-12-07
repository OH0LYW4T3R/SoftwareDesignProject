package Event;

import Factory.Spot.Spot;
import Factory.SpotFactory.HospitalFactory;
import Observer.Subscriber;

import javax.net.ssl.HostnameVerifier;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class EmergencyEvent implements Event{
    @Override
    public void applyEffect(Subscriber subscriber) {

        // 무조건 가까운 병원찾기
        // 여기서 subscriber route 리스트 중간에 병원spot을 끼워넣어
        // 그리고 병원 뒤로는 아무것도 없는 리스트를 subscriber.setMyRouteIterator(/~~~)해서
        // 여행자의 여행루트를 덮어씌워버리기
        // 그ㄹ러면 이벤트 끝나고 main에서 hasNext()하면 더 없으니까 여행 종료
        // 최종 경로는 ~~ -> ~~ -> 병원

        List<Spot> currentRoute = subscriber.getMyRoute();
        // 이터레이터 찾기
        ListIterator<Spot> iterator = subscriber.getMyRouteIterator();

        HospitalFactory hospitalFactory = new HospitalFactory();
        Spot hSpot = hospitalFactory.createSpot("김영태 ", "서울대병원", "서울특별시 종로구 대학로 101");

        if (iterator.hasNext() || iterator.hasPrevious()) {
            iterator.add(hSpot);
        } else {
            // 반복자가 리스트의 시작 또는 끝에 있는 경우를 처리
            currentRoute.add(hSpot); // 맨 끝에 추가
        }

        // 지금까지의 위치까지만의 새로운 리스트 덮어쓰기
        // 현재 반복자의 위치를 활용하여 서브리스트 추출
        int endIndex = iterator.nextIndex(); // 반복자가 위치한 인덱스
        List<Spot> sublist = currentRoute.subList(0, endIndex); // 0부터 endIndex 전까지 추출
        ListIterator<Spot> subIterator = sublist.listIterator();

        // 덮어쓰기
        subscriber.setMyRoute(sublist);
        subscriber.setMyRouteIterator(subIterator);

        subscriber.update(subscriber.getName() + "님! " + hSpot.getStoreName() + "(으)로 병원이 지정되었습니다 서둘러 병원에 가세요! ");
    }
}
