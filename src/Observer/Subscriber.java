package Observer;

import State.State;

public interface Subscriber {
    //getter
    public String getName();
    public Integer getAge();

    //setter
    public void setName(String name);
    public void setAge(Integer age);

    public void getInfo();
    public void update(String alarm);
    public void setState(State state);
}
