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
public class Lettore extends Persona {

    @Column(name = "reading_goal")
    @JsonProperty("readingGoal")
    private Integer readingGoal;

    @OneToMany(mappedBy = "lettore")
    @ToString.Exclude
    private List<Lettura> letture;


    @OneToMany(mappedBy = "lettore")
    private List<Valutazione> valutazioni;
}
