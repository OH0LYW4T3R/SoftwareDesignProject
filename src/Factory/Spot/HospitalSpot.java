package Factory.Spot;

import Event.Event;
import Observer.Subscriber;
import Event.SpotDisableEvent;

import java.util.Random;

public class HospitalSpot implements Spot{
    private String storeName;
    private String address;
    private SpotFlag spotFlag;
    private String provider;
    public HospitalSpot(String provider, String storeName, String address) {
        this.provider = provider;
        this.storeName = storeName;
        this.address = address;
    }

    public void getInfo() {
        System.out.println("먹거리를 위한 스팟임~");
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

    @Override
    public boolean randomDisable(Subscriber subscriber) {
        Random random = new Random();
        int max = 100;
        int min = 1;
        int disableNumber = random.nextInt(max - min + 1) + min;

        if(disableNumber < 3) { // 확률 30퍼
            Event spotDisableEvent = new SpotDisableEvent();
            spotDisableEvent.applyEffect(subscriber);
            return true;
        }

        return false;
    }
}