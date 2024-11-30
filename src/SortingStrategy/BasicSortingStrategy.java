package SortingStrategy;

import Factory.Spot.Spot;
import Factory.Spot.SpotFlag;
import Main.Main;
import Observer.Subscriber;
import State.State;

import java.util.*;

import State.HungryState;
import State.RestState;
import State.BasicState;

public class BasicSortingStrategy implements SortingStrategy {
    public String getStrategy() { return "Basic"; };
    public void setStrategy() { };

    private List<Spot> spotList = Main.allSpotObject;
    private List<Spot> filteredSpot = new ArrayList<>(); // 상태에 맞게 필터링된 스팟
    public void excute(Subscriber subscriber) {
        State subscriberStateInstance = subscriber.getStateInstance();

        List<Spot> renewRoute = subscriber.getMyRoute();
        // 하나의 사용자에게 "필요한" 태그만 들어있는 스팟 리스트 만들기
        spotSetting(subscriberStateInstance, filteredSpot);
        // 이터레이터 찾기
        ListIterator<Spot> iterator = subscriber.getMyRouteIterator();

        // spots에서 사용자가 선택한 스팟을 채택
        // 앞에서부터 중복이 없는것을 찾는것으로 시뮬레이션
        Spot target = selectSpot(filteredSpot, renewRoute);

        System.out.println(target.getStoreName() + "이(가) 경로에 새로 추가되었습니다!");

        if (iterator.hasNext() || iterator.hasPrevious()) {
            iterator.add(target);
        } else {
            // 반복자가 리스트의 시작 또는 끝에 있는 경우를 처리
            renewRoute.add(target); // 맨 끝에 추가
        }

        // 중간 방문한 스팟 체크
        System.out.println("#" + target.getStoreName() + "# - " + target.getSpotFlag().toString() + "갔다옴.");

        if (subscriber.getStateInstance() instanceof HungryState)
            subscriber.setHunger(target);
        else if (subscriber.getStateInstance() instanceof RestState)
            subscriber.setHardness(target);

        System.out.println(subscriber.getName() + "님의 상태 : " + subscriber.getHunger() + "-배고픔 | "
                 + subscriber.getHardness() + "-힘듬 | "  + subscriber.getSick() + "-아픔 |\n");

        if (subscriber.getStateInstance() instanceof HungryState)
            subscriber.checkHunger();
        else if (subscriber.getStateInstance() instanceof RestState)
            subscriber.checkHunger();
    }

    private Spot selectSpot(List<Spot> spots, List<Spot> route) {
        Spot target = null;
        // Route를 HashSet으로 변환
        Set<Spot> routeSet = new HashSet<>(route);
        for (Spot spot : spots) {
            if (!routeSet.contains(spot)) {
                target = spot;
                break;
            }
        }
        return target;
    }

   private void spotSetting(State context, List<Spot> spots) {
        if (context instanceof HungryState) {
            // HungryState일 때 추가할 스팟
            for (Spot spot : spotList) {
                if (spot.getSpotFlag().equals(SpotFlag.EAT))
                    spots.add(spot);  // 상태에 맞는 스팟을 추가
            }
        }
        else if (context instanceof RestState) {
            // RestState일 때 추가할 스팟
            for (Spot spot : spotList) {
                if (spot.getSpotFlag().equals(SpotFlag.REST))
                    spots.add(spot);  // 상태에 맞는 스팟을 추가
            }
        }
        else if (context instanceof BasicState) {
            // BasicState일 때 추가할 스팟
            for (Spot spot : spotList) {
                if (spot.getSpotFlag().equals(SpotFlag.BASIC))
                    spots.add(spot);  // 상태에 맞는 스팟을 추가
            }
        }
    }

}
