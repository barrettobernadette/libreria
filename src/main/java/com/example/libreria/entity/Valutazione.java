package com.example.libreria.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name = "valutazione", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id_persona", "id_libro"})
})
public class Valutazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idValutazione;

    @Column(name = "voto")
    @JsonProperty("voto")
    private Integer voto;

    @ManyToOne
    @JoinColumn(name = "id_libro")
    private Libro libro;

    @ManyToOne
    @JoinColumn(name = "id_persona")
    @ToString.Exclude //serve a evitare che Lombok includa quel campo nel metodo toString() generato automaticamente
    private Lettore lettore;
}
