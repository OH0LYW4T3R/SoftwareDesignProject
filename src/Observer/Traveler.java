package Observer;

import Factory.Spot.Spot;
import Factory.Spot.SpotFlag;
import State.State;
import State.RestState;
import State.HungryState;
import SortingStrategy.SortingStrategy;

import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import SortingStrategy.BasicSortingStrategy;

public class Traveler implements Subscriber{
    private String name;
    private Integer age;
    private State state = null;
    private List<Spot> myRoute;
    private ListIterator<Spot> myRouteIterator;
    private SortingStrategy sortingStrategy;
    private Integer hardness = 1;
    private Integer hunger = 1;
    private Boolean sick = false;

    //추후 힘듬, 배고픔에 대한 척도를 넣어서 알아서 State가 바뀌게 함.

    @Override
    public String getName() { return this.name; }
    @Override
    public Integer getAge() { return this.age; }

    @Override
    public State getStateInstance() {
        return this.state;
    }

    @Override
    public List<Spot> getMyRoute() {
        return this.myRoute;
    }

    @Override
    public ListIterator<Spot> getMyRouteIterator() {
        return this.myRouteIterator;
    }

    @Override
    public SortingStrategy getStrategy() {
        return this.sortingStrategy;
    }

    @Override
    public Integer getHardness() {
        return this.hardness;
    }

    @Override
    public Integer getHunger() {
        return this.hunger;
    }

    @Override
    public Boolean getSick() {
        return this.sick;
    }

    @Override
    public void setName(String name) { this.name = name; }
    @Override
    public void setAge(Integer age) { this.age = age; }

    @Override
    public void setMyRoute(List<Spot> myRoute) {
        this.myRoute = myRoute;
    }

    @Override
    public void setMyRouteIterator(ListIterator<Spot> spotListIterator) {
        this.myRouteIterator = spotListIterator;
    }

    @Override
    public void setStrategy(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    @Override
    public void setHardness(Spot spot) {
        if(spot.getSpotFlag().equals(SpotFlag.EAT)) {
            this.hardness += (this.hardness > 4) ? 0 : 1;
        } else if (spot.getSpotFlag().equals(SpotFlag.REST)) {
            this.hardness += (this.hardness > 4) ? 0 : 2;
        } else
            this.hardness -= (this.hardness > 0) ? 1 : 0;

//        System.out.println(this.getName() + "님의 상태 : " + this.getHunger() + "-배고픔 | "
//                 + this.getHardness() + "-힘듬 | "  + this.getSick() + "-아픔 |\n");
    }

    @Override
    public void checkHardness() {
         if (this.hardness <= 1) {
//            System.out.println(this.getName() + "님의 상태 : " + this.getHunger() + "-배고픔 | "
//                 + this.getHardness() + "-힘듬 | "  + this.getSick() + "-아픔 |\n");
            System.out.println(this.name + "님 " + "현재 쉬고싶을 것 같아요! 장소를 추천 해드릴게요");
            selectLogic();
            setState(RestState.getInstance());
            this.state.operation(this);
        }
    }

    @Override
    public void setHunger(Spot spot) {
        if(spot.getSpotFlag().equals(SpotFlag.EAT)) {
            this.hunger += (this.hunger > 4) ? 0 : 2;
        } else if (spot.getSpotFlag().equals(SpotFlag.REST)) {
            this.hunger += (this.hunger > 4) ? 0 : 1;
        } else
            this.hunger -= (this.hunger > 0) ? 1 : 0;
//        System.out.println(this.getName() + "님의 상태 : " + this.getHunger() + "-배고픔 | "
//                 + this.getHardness() + "-힘듬 | "  + this.getSick() + "-아픔 |\n");
    }

    @Override
    public void checkHunger() {
        if (this.hunger <= 1) { //
//            System.out.println(this.getName() + "님의 상태 : " + this.getHunger() + "-배고픔 | "
//                 + this.getHardness() + "-힘듬 | "  + this.getSick() + "-아픔 |\n");
            System.out.println(this.name + "님 " + "현재 배고플 것 같아요! 장소를 추천 해드릴게요");
            selectLogic();
            setState(HungryState.getInstance());
            this.state.operation(this);
        }
    }

    @Override
    public void setSick(Spot spot) {
        if (spot.getSpotFlag().equals(SpotFlag.SICK))
            this.sick = false;
        else {
            int boundedInt = (int) (Math.random() * (100 - 1 + 1)) + 1;
            if (1 <= boundedInt && boundedInt <= 5)
                sick = true;
        }

        // 추후 아플때도 확장
    }

    @Override
    public void getInfo() {
        System.out.println(name + " " + " " + age + " " + state.getState());
    }

    @Override
    public void update(String alarm) {
        System.out.println(alarm + "(이)가 등록 되었습니다.");
    }

    @Override
    public void setState(State state) {
        this.state = state;
    } // success

    private void selectLogic() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. 최단 거리 | 2. 평점순 | 3. 덜 복잡");
        System.out.println(">>");
        int sel = scanner.nextInt();

        switch (sel) {
            case 1:
                this.setStrategy(new BasicSortingStrategy());
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                break;
        }
    }


}
