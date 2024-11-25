package Factory.Spot;


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
}
