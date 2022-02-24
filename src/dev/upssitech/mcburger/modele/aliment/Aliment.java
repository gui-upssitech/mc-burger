package dev.upssitech.mcburger.modele.aliment;

import java.util.Objects;

public abstract class Aliment {

    // Attributes
    private String nom;

    // Constructor
    public Aliment(String nom) {
        this.nom = nom;
    }

    // Methods
    public String getNom() {
        return nom;
    }

    public String toStringArgs() {
        return "nom='" + nom + "'";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aliment aliment = (Aliment) o;
        return nom.equals(aliment.nom);
    }
}
