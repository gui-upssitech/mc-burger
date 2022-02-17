package dev.upssitech.mcburger.modele.aliment;

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


}
