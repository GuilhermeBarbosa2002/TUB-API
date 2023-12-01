package ACSI.demo.REST.motorista;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table
public class Motorista {
    @Id
    @SequenceGenerator(
            name = "motorista_sequence",
            sequenceName = "motorista_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "motorista_sequence"
    )
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    private String email;
    private String numerocc;
    private String telefone;
    private LocalDate dof;

    @ElementCollection
    private List<LocalDate> horario;

    public Motorista() {
    }

    public Motorista(String nome, String email, String numerocc, String telefone, LocalDate dof) {
        this.nome = nome;
        this.email = email;
        this.numerocc = numerocc;
        this.telefone = telefone;
        this.dof = dof;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumerocc() {
        return numerocc;
    }

    public void setNumerocc(String numerocc) {
        this.numerocc = numerocc;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDof() {
        return dof;
    }

    public void setDof(LocalDate dof) {
        this.dof = dof;
    }

    public List<LocalDate> getHorario() {
        return horario;
    }

    public void setHorario(List<LocalDate> horario) {
        this.horario = horario;
    }
}
