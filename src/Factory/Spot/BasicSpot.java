package Factory.Spot;

public class BasicSpot implements Spot {
    private String storeName;
    private Double latitude; // 위도
    private Double longitude; // 경도

    public BasicSpot(String storeName, Double latitude, Double longitude) {
        this.storeName = storeName;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public void getInfo() {
        System.out.println();
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
