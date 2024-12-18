package State;

import Observer.Subscriber;

public class HungryState implements State{
    private static State state;

    private HungryState() {}

    @Override
    public String getState() {
        return "Hungry";
    }

    @Override
    public void operation(Subscriber subscriber) {
        subscriber.getStrategy().excute(subscriber);
        subscriber.setState(BasicState.getInstance());
    }

    public static State getInstance() {
        if (state == null) {
            state = new HungryState();
        }
        return state;
    }
}
