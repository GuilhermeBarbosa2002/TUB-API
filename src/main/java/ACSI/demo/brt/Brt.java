package ACSI.demo.brt;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Brt {
    @Id
    @SequenceGenerator(
            name = "brt_sequence",
            sequenceName = "brt_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy =GenerationType.SEQUENCE,
            generator = "brt_sequence"
    )
    private Long id;
    private String matricula;
    private LocalDate dataRegisto;
    private Integer capacidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public LocalDate getDataRegisto() {
        return dataRegisto;
    }

    public void setDataRegisto(LocalDate dataRegisto) {
        this.dataRegisto = dataRegisto;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public Brt(Long id, String matricula, LocalDate dataRegisto, Integer capacidade) {
        this.id = id;
        this.matricula = matricula;
        this.dataRegisto = dataRegisto;
        this.capacidade = capacidade;
    }
    public Brt( String matricula, LocalDate dataRegisto, Integer capacidade) {
        this.matricula = matricula;
        this.dataRegisto = dataRegisto;
        this.capacidade = capacidade;
    }

    public Brt() {

    }

    @Override
    public String toString() {
        return "Brt{" +
                "id=" + id +
                ", matricula='" + matricula + '\'' +
                ", dataRegisto=" + dataRegisto +
                ", capacidade=" + capacidade +
                '}';
    }
}
