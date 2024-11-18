package Observer.Admin;

import Observer.Provider.Provider;
import Observer.Publisher;
import Observer.Subscriber;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BasicAdmin implements Admin{
    // 추후 속도 개선을 위해 MAP 혹은 SET collections 사용
    private List<Provider> providers = new ArrayList<>();
    private List<Subscriber> subscribers = new ArrayList<>();

    @Override
    public void addProvider(Provider provider) {
        providers.add(provider);
    }

    @Override
    public void DeleteProvider(Provider provider) {
        providers.remove(provider);
    }

     @Override
    public void allSubscribersRead() {
        for (Subscriber subscriber : subscribers) {
            subscriber.getInfo();
        }
    }

    @Override
    public void registerSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public boolean removeSubscriber(Subscriber subscriber) {
        return subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers() {
        // provider의 spot을 큐에 저장해놓고 admin이 notify 할때만 쌓여있던 큐를 알림
        for (Subscriber subscriber : subscribers) {
            subscriber.update("Basic");
        }
    }
}
