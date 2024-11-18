package Factory.SpotFactory;

import Factory.Spot.Spot;

public abstract class SpotFactory {
    public abstract Spot createSpot(String storeName, Double latitude, Double longitude);
}

