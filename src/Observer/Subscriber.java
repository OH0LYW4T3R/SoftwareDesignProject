package Observer;

import State.State;

public interface Subscriber {
    public void getInfo();
    public void update(String alarm);
    public void setState(State state);
}
