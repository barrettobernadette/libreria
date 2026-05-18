package com.example.libreria.enums;

public enum Tipologia {

    LETTORE("0", "lettore"),
    AUTORE("1", "autore");

    private String codice;
    private String desc;

    Tipologia(String codice, String desc) {
        this.codice = codice;
        this.desc = desc;
    }
}
