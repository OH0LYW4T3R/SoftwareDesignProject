package Factory.Spot;

public interface Spot {
    // doStuff()
    public void getInfo();


    public String getStoreName();
    public Double getLatitude();
    public Double getLongitude();

    public void setStoreName(String value);
    public void setLatitude(Double value);
    public void setLongitude(Double vale);
}
