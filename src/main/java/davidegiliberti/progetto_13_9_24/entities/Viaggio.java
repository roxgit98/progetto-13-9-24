package davidegiliberti.progetto_13_9_24.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "viaggio")
public class Viaggio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String destinazione;
    private LocalDate data;
    private String statoViaggio;

    public Viaggio() {
    }

    public Viaggio(String destinazione, LocalDate data, String statoViaggio) {
        this.destinazione = destinazione;
        this.data = data;
        this.statoViaggio = statoViaggio;
    }

    public long getId() {
        return id;
    }

    public String getDestinazione() {
        return destinazione;
    }

    public void setDestinazione(String destinazione) {
        this.destinazione = destinazione;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getStatoViaggio() {
        return statoViaggio;
    }

    public void setStatoViaggio(String statoViaggio) {
        this.statoViaggio = statoViaggio;
    }

    @Override
    public String toString() {
        return "Viaggio{" +
                "id=" + id +
                ", destinazione='" + destinazione + '\'' +
                ", data=" + data +
                ", statoViaggio=" + statoViaggio +
                '}';
    }
}
