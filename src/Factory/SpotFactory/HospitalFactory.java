package Factory.SpotFactory;

import Factory.Spot.RestSpot;
import Factory.Spot.Spot;
import Factory.Spot.SpotFlag;

public class HospitalFactory extends SpotFactory{
    @Override
    public Spot createSpot(String provider, String storeName, String address) {
        Spot spot = new RestSpot(provider, storeName, address);
        spot.setSpotFlag(SpotFlag.HOSPITAL);
        return spot;
    }
}
