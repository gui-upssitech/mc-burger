package dev.upssitech.mcburger.modele.aliment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FabriqueAlimentTest {
    public static final Hamburger hamburger = new Hamburger("Mc Burger");
    public static final Accompagnement accompagnement = new Accompagnement("Mc Frites");
    public static final Boisson boisson = new Boisson("Mc EAU");

    @Test
    void creerAliment() {
        Assertions.assertEquals(
                FabriqueAliment.creerAliment(AlimentMenu.HAMBURGER, "Mc Burger"),
                hamburger
        );

        Assertions.assertEquals(
                FabriqueAliment.creerAliment(AlimentMenu.ACCOMPAGNEMENT, "Mc Frites"),
                accompagnement
        );

        Assertions.assertEquals(
                FabriqueAliment.creerAliment(AlimentMenu.BOISSON, "Mc EAU"),
                boisson
        );
    }
}