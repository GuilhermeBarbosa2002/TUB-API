package ACSI.demo.REST.movimento;

import ACSI.demo.REST.paragem.Paragem;
import ACSI.demo.REST.viagem.Viagem;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table
public class Movimento {
    @Id
    @SequenceGenerator(
            name = "movimento_sequence",
            sequenceName = "movimento_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "movimento_sequence"
    )
    private long id;

    @OneToOne
    @JoinColumn(name = "paragem_id")
    private Paragem paragem;


    private Long entradaPassageiros;

    private Long saidaPassageiros;

    private double tempoParagem;

    private LocalDateTime tempo;

    public Movimento(Paragem paragem, Long entradaPassageiros, Long saidaPassageiros, double tempoParagem) {
        this.paragem = paragem;
        this.entradaPassageiros = entradaPassageiros;
        this.saidaPassageiros = saidaPassageiros;
        this.tempoParagem = tempoParagem;
        this.tempo = LocalDateTime.now();
    }

    public LocalDateTime getLocalDateTime() {
        return tempo;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.tempo = localDateTime;
    }

    public Movimento() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Paragem getParagem() {
        return paragem;
    }

    public void setParagem(Paragem paragem) {
        this.paragem = paragem;
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

    public double getTempoParagem() {
        return tempoParagem;
    }

    public void setTempoParagem(double tempoParagem) {
        this.tempoParagem = tempoParagem;
    }
}
