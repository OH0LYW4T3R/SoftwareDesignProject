package Event;

import Factory.Spot.Spot;
import Observer.Subscriber;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class SpotDisableEvent implements Event {
    // 목표 : 현재 위치로 부터 앞에있는 스팟중 하나 없애기
    public void applyEffect(Subscriber subscriber) {
        // subscriber 현재 반복자 위치 스팟 얻어오기
        int currentIndex = subscriber.getMyRouteIterator().previousIndex();
        String storeName = subscriber.getMyRoute().get(currentIndex).getStoreName();
        subscriber.update(subscriber.getName() + "님! 더 이상" + storeName + "이(가) 문을 닫아 이용할 수 없게 되었어요...");

        ListIterator<Spot> spots = subscriber.getMyRouteIterator();

        spots.remove(); // 가장 최근에 next했던 놈을 없앰
    }
}
