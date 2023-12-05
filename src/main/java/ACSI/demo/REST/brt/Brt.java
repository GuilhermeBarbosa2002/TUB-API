package ACSI.demo.REST.brt;

import ACSI.demo.REST.camara.Camara;
import ACSI.demo.REST.viagem.Viagem;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

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

    private String latitude;

    private String longitude;
    @OneToMany
    @JoinTable(
            name = "brt_camara",
            joinColumns = @JoinColumn(name = "brt_id"),
            inverseJoinColumns = @JoinColumn(name = "camara_id")
    )
    private List<Camara> camaras;

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


    public List<Camara> getCamaras() {
        return camaras;
    }

    public void setCamaras(List<Camara> camaras) {
        this.camaras = camaras;
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

    public Brt(String matricula, LocalDate dataRegisto, Integer capacidade, List<Camara> camaras) {
        this.matricula = matricula;
        this.dataRegisto = dataRegisto;
        this.capacidade = capacidade;
        this.camaras = camaras;
        this.latitude = null;
        this.longitude = null;
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
