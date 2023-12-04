package ACSI.demo.REST.movimento;

import jakarta.persistence.Column;

public class MovimentoCamara {
    private Long id_camera;
    private Long entradaPassageiros;
    private Long saidaPassageiros;

    public MovimentoCamara() {

    }

    public MovimentoCamara(Long id_camera, Long entradaPassageiros, Long saidaPassageiros) {
        this.id_camera = id_camera;
        this.entradaPassageiros = entradaPassageiros;
        this.saidaPassageiros = saidaPassageiros;
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
