package Observer.Provider;

import Factory.Spot.Spot;
import Factory.SpotFactory.SpotFactory;
import Observer.Admin.Admin;

import java.util.ArrayList;
import java.util.List;

public class BasicProvider implements Provider{
    Admin admin;
    List<Spot> spotList = new ArrayList<>();

    public BasicProvider(Admin admin) {
        this.admin = admin;
    }

    @Override
    public void readSpots() {
        for (Spot spot : spotList) {
            spot.getInfo();
        }
    }

    @Override
    public void createSpot(SpotFactory spotFactory) {
        spotList.add(spotFactory.createSpot("Default", 0.0, 0.0));
    }

    @Override
    public void modifySpot() {
        // 보류
    }

    @Override
    public void deleteSpot(Spot spot) {
        spotList.remove(spotList);
    }
}
