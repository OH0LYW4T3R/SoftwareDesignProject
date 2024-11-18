package Observer.Provider;

import Factory.Spot.Spot;
import Factory.SpotFactory.SpotFactory;

// 음식스팟 제공자, 놀거리스팟 제공자, 휴식처 제공자(모텔, 호텔, 여인숙)
public interface Provider {
    public void readSpots();
    public void createSpot(SpotFactory spotFactory);
    public void modifySpot();
    public void deleteSpot(Spot spot);
}
