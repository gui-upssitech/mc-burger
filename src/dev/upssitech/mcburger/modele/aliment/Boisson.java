package dev.upssitech.mcburger.modele.aliment;

public class Boisson extends Aliment {

    // Constructor
    public Boisson(String nom) {
        super(nom);
    }

    // Methods
    public String toString() {
        return "Boisson [" + toStringArgs() + "]";
    }
}
