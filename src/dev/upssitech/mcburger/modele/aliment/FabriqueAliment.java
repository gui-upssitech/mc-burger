package dev.upssitech.mcburger.modele.aliment;

public class FabriqueAliment {

    // Methods
    public static Aliment creerAliment(AlimentMenu typeAliment, String nom) {
        return switch (typeAliment) {
            case BOISSON -> new Boisson(nom);
            case HAMBURGER -> new Hamburger(nom);
            case ACCOMPAGNEMENT -> new Accompagnement(nom);
        };
    }

}
