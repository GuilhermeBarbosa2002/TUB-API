package ACSI.demo.REST.viagem;

import ACSI.demo.REST.brt.Brt;
import ACSI.demo.REST.motorista.Motorista;
import ACSI.demo.REST.movimento.Movimento;
import ACSI.demo.REST.rota.Rota;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

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
    @ManyToOne
    @JoinColumn(name = "rota_id")
    private Rota rota;
    @ManyToOne
    @JoinColumn(name = "motorista_id")
    private Motorista motorista;
    @ManyToOne
    @JoinColumn(name = "brt_id")
    private Brt brt;


    private Long totalPessoas;

    private Long atualPessoas;

    @OneToMany
    @JoinTable(
            name = "viagem_movimento",
            joinColumns = @JoinColumn(name = "viagem_id"),
            inverseJoinColumns = @JoinColumn(name = "movimento_id")
    )
    private List<Movimento> movimentos;

    public Viagem() {
    }

    public Viagem(LocalDateTime data, EstadoViagem estado, Rota rota, Motorista motorista, Brt brt, Long totalPessoas, Long atualPessoas, List<Movimento> movimentos) {
        this.data = data;
        this.estado = estado;
        this.rota = rota;
        this.motorista = motorista;
        this.brt = brt;
        this.totalPessoas = totalPessoas;
        this.atualPessoas = atualPessoas;
        this.movimentos = movimentos;
    }

    public Long getTotalPessoas() {
        return totalPessoas;
    }

    public void setTotalPessoas(Long totalPessoas) {
        this.totalPessoas = totalPessoas;
    }

    public Long getAtualPessoas() {
        return atualPessoas;
    }

    public void setAtualPessoas(Long atualPessoas) {
        this.atualPessoas = atualPessoas;
    }

    public List<Movimento> getMovimentos() {
        return movimentos;
    }

    public void setMovimentos(List<Movimento> movimentos) {
        this.movimentos = movimentos;
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
