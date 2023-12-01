package ACSI.demo.REST.camara;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "camara")
public class Camara {
    @Id
    @SequenceGenerator(
            name = "camara_sequence",
            sequenceName = "camara_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "camara_sequence"
    )
    private Long id;

    @Column(nullable = false)
    private String modelo;

    @Column(name = "nr_serie", nullable = false, unique = true)
    private String nrSerie;

    @Column(name = "data_aquisicao", nullable = false)
    private LocalDate dataAquisicao;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private String resolucao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoCamara estado;

    public Camara() {
    }

    public Camara(String modelo, String nrSerie, LocalDate dataAquisicao, String marca, String resolucao, EstadoCamara estado) {
        this.modelo = modelo;
        this.nrSerie = nrSerie;
        this.dataAquisicao = dataAquisicao;
        this.marca = marca;
        this.resolucao = resolucao;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNrSerie() {
        return nrSerie;
    }

    public void setNrSerie(String nrSerie) {
        this.nrSerie = nrSerie;
    }

    public LocalDate getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(LocalDate dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getResolucao() {
        return resolucao;
    }

    public void setResolucao(String resolucao) {
        this.resolucao = resolucao;
    }

    public EstadoCamara getEstado() {
        return estado;
    }

    public void setEstado(EstadoCamara estado) {
        this.estado = estado;
    }

}
