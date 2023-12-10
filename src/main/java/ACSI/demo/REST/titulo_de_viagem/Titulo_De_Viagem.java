package ACSI.demo.REST.titulo_de_viagem;

import ACSI.demo.REST.rota.Rota;
import jakarta.persistence.*;

@Entity
@Table(name = "titulo_de_viagem")
public class Titulo_De_Viagem {
    @Id
    @SequenceGenerator(
            name = "titulo_de_viagem_sequence",
            sequenceName = "titulo_de_viagem_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "titulo_de_viagem_sequence"
    )
    private Long id;
    @ManyToOne
    @JoinColumn(name = "rota_id")
    private Rota rota;
    private boolean Validado;

    public Titulo_De_Viagem(Rota rota) {
        this.rota = rota;
    }

    public Titulo_De_Viagem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Rota getRota() {
        return rota;
    }

    public boolean isValidado() {
        return Validado;
    }

    public void setValidado(boolean validado) {
        Validado = validado;
    }
}
