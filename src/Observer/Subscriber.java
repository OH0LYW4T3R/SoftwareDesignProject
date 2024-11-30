package Observer;

import Factory.Spot.Spot;
import State.State;
import SortingStrategy.SortingStrategy;

import java.util.List;
import java.util.ListIterator;

public interface Subscriber {
    //getter
    public String getName();
    public Integer getAge();
    public State getStateInstance();
    public List<Spot> getMyRoute();
    public ListIterator<Spot> getMyRouteIterator();
    public SortingStrategy getStrategy();

    public Integer getHardness();
    public Integer getHunger();
    public Boolean getSick();

    //setter
    public void setName(String name);
    public void setAge(Integer age);
    public void setState(State state);
    public void setMyRoute(List<Spot> myRoute);
    public void setMyRouteIterator(ListIterator<Spot> spotListIterator);
    public void setStrategy(SortingStrategy sortingStrategy);
    public void setHardness(Spot spot);
    public void checkHardness();
    public void setHunger(Spot spot);
    public void checkHunger();
    public void setSick(Spot spot);

    public void getInfo();
    public void update(String alarm);

}
