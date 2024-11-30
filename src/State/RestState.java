package State;

import Observer.Subscriber;

public class RestState implements State{
    private static State state;


    private RestState() {}

    @Override
    public String getState() {
        return "Hardness";
    }

    @Override
    public void operation(Subscriber subscriber) {
        subscriber.getStrategy().excute(subscriber);
        subscriber.setState(BasicState.getInstance());
    }

    public static State getInstance() {
        if (state == null) {
            state = new RestState();
        }
        return state;
    }
}
