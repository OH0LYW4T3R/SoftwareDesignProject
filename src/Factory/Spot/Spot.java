package Factory.Spot;


import Observer.Subscriber;

public interface Spot {
    // doStuff()
    public void getInfo();

    public SpotFlag getSpotFlag();
    public void setSpotFlag(SpotFlag spotFlag);
    public String getProvider();
    public String getStoreName();
    public String getAddress();

    public void setStoreName(String value);
    public void setAddress(String address);

    public boolean randomDisable(Subscriber subscriber);
}
