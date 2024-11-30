package Observer.Provider;

import Factory.Spot.Spot;
import Factory.SpotFactory.SpotFactory;

import java.util.List;

// 음식스팟 제공자, 놀거리스팟 제공자, 휴식처 제공자(모텔, 호텔, 여인숙)
public interface Provider {
    // getter
    public String getName();
    public String getEmail();
    public Integer getAge();
    // setter
    public void setName(String name);
    public void setEmail(String email);
    public void setAge(Integer age);


    public void readSpots();
    public List<Spot> getSpotList();
    public void createSpot(Spot spot);
    public void modifySpot();
    public void deleteSpot(Spot spot);
}
