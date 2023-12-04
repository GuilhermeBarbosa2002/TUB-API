package ACSI.demo.REST.rota;

import ACSI.demo.REST.paragem.Paragem;
import ACSI.demo.REST.viagem.Viagem;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table
public class Rota {
    @Id
    @SequenceGenerator(
            name = "rota_sequence",
            sequenceName = "rota_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "rota_sequence"
    )
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @ElementCollection
    private List<LocalDate> horario;

    @ManyToMany
    @JoinTable(
            name = "rota_paragem",
            joinColumns = @JoinColumn(name = "rota_id"),
            inverseJoinColumns = @JoinColumn(name = "paragem_id")
    )
    private List<Paragem> paragens;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<LocalDate> getHorario() {
        return horario;
    }

    public void setHorario(List<LocalDate> horario) {
        this.horario = horario;
    }

    public List<Paragem> getParagens() {
        return paragens;
    }

    public void setParagens(List<Paragem> paragens) {
        this.paragens = paragens;
    }

    // Constructors
    public Rota() {
        // Construtor padrão necessário para JPA
    }

    public Rota(String nome, List<LocalDate> horario, List<Paragem> paragens) {
        this.nome = nome;
        this.horario = horario;
        this.paragens = paragens;
    }
}
