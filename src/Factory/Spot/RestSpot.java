package Factory.Spot;

public class RestSpot implements Spot{
    private String storeName;
    private Double latitude; // 위도
    private Double longitude; // 경도

    public void getInfo() {
        System.out.println("휴식을 위한 스팟임~");
    }

    // getter
    public String getStoreName() { return this.storeName; }
    public Double getLatitude() { return this.latitude; }
    public Double getLongitude() { return this.longitude; }


    // setter
    public void setStoreName(String value) {}
    public void setLatitude(Double value) {}
    public void setLongitude(Double value) {}
}
