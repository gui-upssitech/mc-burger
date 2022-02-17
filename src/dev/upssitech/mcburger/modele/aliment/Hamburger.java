package dev.upssitech.mcburger.modele.aliment;

public class Hamburger extends Aliment {

    // Constructor
    public Hamburger(String nom) {
        super(nom);
    }

    // Methods
    public String toString() {
        return "Hamburger [" + toStringArgs() + "]";
    }

}
