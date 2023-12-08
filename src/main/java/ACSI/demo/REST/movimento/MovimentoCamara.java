package ACSI.demo.REST.movimento;

import jakarta.persistence.Column;

import java.time.LocalDateTime;

public class MovimentoCamara {
    private Long id_camera;
    private Long entradaPassageiros;
    private Long saidaPassageiros;

    private String latitude;
    private double tempoParagem;
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

    public double getTempoParagem() {
        return tempoParagem;
    }

    public void setTempoParagem(double tempoParagem) {
        this.tempoParagem = tempoParagem;
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
