package dev.upssitech.mcburger.modele.bd;

import dev.upssitech.mcburger.modele.aliment.Accompagnement;
import dev.upssitech.mcburger.modele.aliment.Boisson;
import dev.upssitech.mcburger.modele.aliment.Hamburger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    public static final Hamburger hamburger = new Hamburger("Mc Burger");
    public static final Accompagnement accompagnement = new Accompagnement("Mc Frites");
    public static final Boisson boisson = new Boisson("Mc EAU");

    public static Menu menu;

    @BeforeAll
    static void setup() {
        menu = Menu.getInstance();
    }

    @Test
    void ajouterHamburger() {
        menu.ajouterAliment(hamburger);
        Assertions.assertEquals(1, menu.getListeHamburger().size());
    }

    @Test
    void ajouterAccompagnement() {
        menu.ajouterAliment(accompagnement);
        Assertions.assertEquals(1, menu.getListeAccompagnement().size());
    }

    @Test
    void ajouterBoisson() {
        menu.ajouterAliment(boisson);
        Assertions.assertEquals(1, menu.getListeBoisson().size());
    }

    @Test
    void choixHamburger() {
        Assertions.assertEquals(hamburger, menu.choixHamburger(0));
    }

    @Test
    void choixAccompagnement() {
        Assertions.assertEquals(accompagnement, menu.choixAccompagnement(0));
    }

    @Test
    void choixBoisson() {
        Assertions.assertEquals(boisson, menu.choixBoisson(0));
    }

    @AfterAll
    @Test
    static void testToString() {
        String expectedToString =
                "Menu [" +
                "listeHamburger=[" + hamburger + "], " +
                "listeBoisson=[" + boisson + "], " +
                "listeAccompagnement=[" + accompagnement + "]" +
                "]";

        Assertions.assertEquals(expectedToString, menu.toString());
    }
}