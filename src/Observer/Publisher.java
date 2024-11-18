package Observer;

public interface Publisher {
    // 어드민 -> 신고처리하는 어드민, 알람보내는 어드민, ...
    public void registerSubscriber(Subscriber subscriber);
    public boolean removeSubscriber(Subscriber subscriber);
    public void allSubscribersRead();
    public void notifySubscribers();
}

