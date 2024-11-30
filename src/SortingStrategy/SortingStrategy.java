package SortingStrategy;

import Observer.Subscriber;

public interface SortingStrategy {
    public String getStrategy();
    public void setStrategy();
    public void excute(Subscriber subscriber);
}

