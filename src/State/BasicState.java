package State;

import Observer.Subscriber;

public class BasicState implements State{
    private static State state;

    private BasicState() {}
    @Override
    public String getState() {
        return "Basic";
    }

    @Override
    public void operation(Subscriber subscriber) {
        //subscriber.setState();
    }


    public static State getInstance() {
        if (state == null) {
            state = new BasicState();
        }
        return state;
    }
}
