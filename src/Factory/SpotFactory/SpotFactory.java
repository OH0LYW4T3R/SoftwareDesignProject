package Factory.SpotFactory;

import Factory.Spot.Spot;

public abstract class SpotFactory {
    public abstract Spot createSpot(String provider, String storeName, String address);
}

