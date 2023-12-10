package ACSI.demo.REST.titulo_de_viagem;

import ACSI.demo.REST.coroa.Coroa;
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

    @OneToOne
    @JoinColumn(name="coroa_id")
    private Coroa coroa;

    public void setRota(Rota rota) {
        this.rota = rota;
    }

    public Coroa getCoroa() {
        return coroa;
    }

    public void setCoroa(Coroa coroa) {
        this.coroa = coroa;
    }

    public Titulo_De_Viagem(Rota rota) {
        this.rota = rota;
        setValidado(false);
    }

    public Titulo_De_Viagem() {
        setValidado(false);
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
