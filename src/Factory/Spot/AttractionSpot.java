package Factory.Spot;

public class AttractionSpot implements Spot {
    private String storeName;
    private Double latitude; // 위도
    private Double longitude; // 경도
    public void getInfo() {
        System.out.println("놀거리 정보를 가진 장소임~");
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
