package ACSI.demo.REST.coroa;

import ACSI.demo.REST.camara.EstadoCamara;
import ACSI.demo.REST.rota.Rota;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;

@Entity
@Table(name = "coroa")
public class Coroa {
    @Id
    @SequenceGenerator(
            name = "coroa_sequence",
            sequenceName = "coroa_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "coroa_sequence"
    )
    private Long id;

    public Coroa(double price, ArrayList<Rota> rotas) {
        this.price = price;
        this.rotas = rotas;
    }

    private double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ArrayList<Rota> getRotas() {
        return rotas;
    }

    public void setRotas(ArrayList<Rota> rotas) {
        this.rotas = rotas;
    }

    @OneToMany
    @JoinTable(
            name = "coroa_rotas",
            joinColumns = @JoinColumn(name = "coroa_id"),
            inverseJoinColumns = @JoinColumn(name = "rota_id")
    )
    private ArrayList<Rota> rotas;




}
