package dev.upssitech.mcburger.modele.profil;

public class CarteBancaire {

    // Attributes
    private final int numeroCarte, dateCarte;

    // Constructor
    public CarteBancaire(int numeroCarte, int dateCarte) {
        this.numeroCarte = numeroCarte;
        this.dateCarte = dateCarte;
    }

    // Methods
    @Override
    public String toString() {
        return "CarteBancaire [" +
                "numeroCarte=" + numeroCarte +
                ", dateCarte=" + dateCarte +
                ']';
    }
}
