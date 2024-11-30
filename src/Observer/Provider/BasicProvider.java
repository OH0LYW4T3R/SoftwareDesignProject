package Observer.Provider;

import Factory.Spot.Spot;
import Factory.SpotFactory.SpotFactory;
import Observer.Admin.Admin;

import java.util.ArrayList;
import java.util.List;

public class BasicProvider implements Provider{
    private String name;
    private String email;
    private Integer age;
    private Admin admin;
    private List<Spot> spotList = new ArrayList<>();

    public BasicProvider(Admin admin) {
        this.admin = admin;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public Integer getAge() {
        return this.age;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public void readSpots() {
        for (Spot spot : spotList) {
            spot.getInfo();
        }
    }

    @Override
    public List<Spot> getSpotList() {
        return spotList;
    }

    @Override
    public void createSpot(Spot spot) {
        spotList.add(spot);
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
