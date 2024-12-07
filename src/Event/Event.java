package Event;

import Observer.Subscriber;

public interface Event {
    void applyEffect(Subscriber subscriber);
}
