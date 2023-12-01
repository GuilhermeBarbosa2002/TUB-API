package ACSI.demo.REST.paragem;

import jakarta.persistence.*;

@Entity
@Table
public class Paragem {
    @Id
    @SequenceGenerator(
            name = "paragem_sequence",
            sequenceName = "paragem_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "paragem_sequence"
    )
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    private String Latitude;
    private String Longitude;


    public Paragem() {

    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public Paragem(String nome, String latitude, String longitude) {
        this.nome = nome;
        Latitude = latitude;
        Longitude = longitude;
    }
}
