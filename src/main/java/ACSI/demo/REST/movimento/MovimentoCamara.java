package ACSI.demo.REST.movimento;

import jakarta.persistence.Column;

public class MovimentoCamara {
    private Long id_camera;
    private Long entradaPassageiros;
    private Long saidaPassageiros;

    private String latitude;

    private String longitude;

    public MovimentoCamara() {

    }

    public MovimentoCamara(Long id_camera, Long entradaPassageiros, Long saidaPassageiros, String latitude, String longitude) {
        this.id_camera = id_camera;
        this.entradaPassageiros = entradaPassageiros;
        this.saidaPassageiros = saidaPassageiros;
        this.latitude = latitude;
        this.longitude = longitude;
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

    public Long getId_camera() {
        return id_camera;
    }

    public void setId_camera(Long id_camera) {
        this.id_camera = id_camera;
    }

    public Long getEntradaPassageiros() {
        return entradaPassageiros;
    }

    public void setEntradaPassageiros(Long entradaPassageiros) {
        this.entradaPassageiros = entradaPassageiros;
    }

    public Long getSaidaPassageiros() {
        return saidaPassageiros;
    }

    public void setSaidaPassageiros(Long saidaPassageiros) {
        this.saidaPassageiros = saidaPassageiros;
    }
}
