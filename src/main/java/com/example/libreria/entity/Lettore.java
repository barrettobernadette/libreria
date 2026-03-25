package com.example.libreria.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lettore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLettore;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @Column(name = "reading_goal")
    @JsonProperty("readingGoal")
    private Integer readingGoal;

    @OneToMany(mappedBy = "lettore")
    @ToString.Exclude
    private List<Lettura> letture;

    public Integer getReadingGoal() {
        return this.readingGoal;
    }

    public void setReadingGoal(Integer readingGoal) {
        this.readingGoal = readingGoal;
    }

    public List<Lettura> getLetture() {
        return this.letture;
    }
}
