package Event;

import Factory.Spot.Spot;
import Observer.Subscriber;

import java.util.Random;

public class RoadClosureEvent implements Event{
    public void applyEffect(Subscriber subscriber) {
        Random random = new Random();
        int max = 100;
        int min = 1;
        int disableNumber = random.nextInt(max - min + 1) + min;

        if (disableNumber < 30) {
            int currentIndex = subscriber.getMyRouteIterator().previousIndex();
            String storeName = subscriber.getMyRoute().get(currentIndex).getStoreName();
            subscriber.update(subscriber.getName() + "님! " + storeName + "(으)로 가는 경로가 달라졌어요! 재탐색된 경로를 확인해주세요! ");

            System.out.println("# -Start- 경로 재탐색 알림 #");
            for(Spot editSpot : subscriber.getMyRoute()) {
                System.out.print(editSpot.getStoreName() + " -> ");
            }
            System.out.println("\b\b\b\b\n# -End- 경로 재탐색 알림 #\n");
        }
    }
}
