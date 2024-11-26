package Observer;

import State.State;

public class Traveler implements Subscriber{
    private String name;
    private Integer age;
    private State state = null;

    //추후 힘듬, 배고픔에 대한 척도를 넣어서 알아서 State가 바뀌게 함.

    @Override
    public String getName() { return this.name; }
    @Override
    public Integer getAge() { return this.age; }


    @Override
    public void setName(String name) { this.name = name; }
    @Override
    public void setAge(Integer age) { this.age = age; }

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
    }
}
