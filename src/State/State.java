package State;

import Observer.Subscriber;

public interface State {
    public String getState();
    public void operation(Subscriber subscriber);
}

