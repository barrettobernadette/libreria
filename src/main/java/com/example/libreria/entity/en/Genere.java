package com.example.libreria.entity.en;

public enum Genere {
    FANTASY("FAN","fantasy"),
    ROMANCE("ROM","romance"),
    HORROR("HOR","horror"),
    THRILLER("THR","thriller");

    private String codice;
    private String desc;

    Genere(String codice, String desc) {
        this.codice = codice;
        this.desc = desc;
    }
}
