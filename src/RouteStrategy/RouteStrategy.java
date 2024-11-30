package RouteStrategy;

import Factory.Spot.Spot;
import Observer.Subscriber;

import java.util.List;

public interface RouteStrategy {
    public String getState();
    public void setState();
    public List<Spot> excute(List<Spot> spots, int threshold);
}


