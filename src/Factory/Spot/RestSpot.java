package Factory.Spot;

public class RestSpot implements Spot{
    private String storeName;
    private String address;
    private SpotFlag spotFlag;
    private String provider;

    public RestSpot(String provider, String storeName, String address) {
        this.provider = provider;
        this.storeName = storeName;
        this.address = address;
    }

    public void getInfo() {
        System.out.println("휴식을 위한 스팟임~");
    }

    @Override
    public String getProvider() { return this.provider; }

    @Override
    public SpotFlag getSpotFlag() {
        return this.spotFlag;
    }


    // getter
    @Override
    public String getStoreName() { return this.storeName; }

    @Override
    public String getAddress() {
        return this.address;
    }


    // setter
    @Override
    public void setStoreName(String value) {
        this.storeName = storeName;
    }
    @Override
    public void setSpotFlag(SpotFlag spotFlag) {
        this.spotFlag = spotFlag;
    }
    @Override
    public void setAddress(String address) {
        this.address = address;
    }

}
