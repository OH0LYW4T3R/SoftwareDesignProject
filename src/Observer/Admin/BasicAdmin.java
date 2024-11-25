package Observer.Admin;

import Factory.Spot.Spot;
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
    public void allReadProvider() {
        for (Provider provider : providers) {
            System.out.println(provider.getName() + " " + provider.getAge() + " " + provider.getEmail());
        }
    }

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
        List<Spot> spotList;
        // 알람을 보낸 내용들은 없애야함.
        for (Provider provider : providers) {
            spotList = provider.getSpotList();

            for (Spot spot : spotList) {
                // 나중에 필터링이 필요하다면 알고리즘을 추가 할 수 있음.
                for (Subscriber subscriber : subscribers) {
                    subscriber.update(subscriber.getName() + "님! ->" + spot.getStoreName() + "가 " + spot.getAddress() + "에 새로 생겼습니다!");
                }

                // spot을 구독자에게 보냈다면 삭제
                provider.deleteSpot(spot);
            }
        }
    }
}
