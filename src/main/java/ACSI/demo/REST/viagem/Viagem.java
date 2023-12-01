package ACSI.demo.REST.viagem;

import ACSI.demo.REST.brt.Brt;
import ACSI.demo.REST.motorista.Motorista;
import ACSI.demo.REST.rota.Rota;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table
public class Viagem {
    @Id
    @SequenceGenerator(
            name = "viagem_sequence",
            sequenceName = "viagem_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "viagem_sequence"
    )
    private Long id;
    private LocalDateTime data;

    private EstadoViagem estado;
    @OneToOne
    @JoinColumn(name = "rota_id")
    private Rota rota;
    @OneToOne
    @JoinColumn(name = "motorista_id")
    private Motorista motorista;
    @OneToOne
    @JoinColumn(name = "brt_id")
    private Brt brt;

    public Viagem() {
    }

    public Viagem(LocalDateTime data, EstadoViagem estado, Rota rota, Motorista motorista, Brt brt) {
        this.data = data;
        this.estado = estado;
        this.rota = rota;
        this.motorista = motorista;
        this.brt = brt;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public EstadoViagem getEstado() {
        return estado;
    }

    public void setEstado(EstadoViagem estado) {
        this.estado = estado;
    }

    public Rota getRota() {
        return rota;
    }

    public Brt getBrt() {
        return brt;
    }

    public void setBrt(Brt brt) {
        this.brt = brt;
    }

    public void setRota(Rota rota) {
        this.rota = rota;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }
}
