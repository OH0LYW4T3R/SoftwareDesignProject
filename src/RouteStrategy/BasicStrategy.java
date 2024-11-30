package RouteStrategy;

import Factory.Spot.Spot;
import Observer.Subscriber;

import java.util.*;

public class BasicStrategy implements RouteStrategy {
    private List<Spot> target = new ArrayList<>();

    public String getState() { return "BasicRoute"; }
    public void setState() { }
    public List<Spot> excute(List<Spot> spots, int threshold) {
        // 사용자에게 여행 경로 제공
        Random random = new Random();
        Set<Integer> uniqueNumbers = new HashSet<>();
        while (uniqueNumbers.size() < threshold) {
            int randomNumber = random.nextInt(spots.size());

            if (!uniqueNumbers.contains(randomNumber)) {
                uniqueNumbers.add(randomNumber);
                target.add(spots.get(randomNumber));
            }
        }

        return target;
    }
}
