package ACSI.demo.PipesAndFilters;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Localizacao {
    @JsonProperty("brt")
    private long brt;
    private String latitude;
    private String longitude;

    public long getBrt_id() {
        return brt;
    }

    public void setBrt_id(long brt) {
        this.brt = brt;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Localizacao(long brt_id, String latitude, String longitude) {
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
