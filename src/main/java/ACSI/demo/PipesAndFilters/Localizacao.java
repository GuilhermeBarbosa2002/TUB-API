package ACSI.demo.PipesAndFilters;

public class Localizacao {
    private long brt;
    private double latitude;
    private double longitude;

    public long getBrt_id() {
        return brt;
    }

    public void setBrt_id(long brt) {
        this.brt = brt;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Localizacao(long brt_id, double latitude, double longitude) {
        this.brt = brt_id;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Localizacao() {
    }

    @Override
    public String toString() {
        return "Localizacao{" +
                "brt_id=" + brt +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
