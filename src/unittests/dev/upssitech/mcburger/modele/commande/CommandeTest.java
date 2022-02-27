package dev.upssitech.mcburger.modele.commande;

import dev.upssitech.mcburger.modele.aliment.Accompagnement;
import dev.upssitech.mcburger.modele.aliment.Boisson;
import dev.upssitech.mcburger.modele.aliment.Hamburger;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CommandeTest {

    // Attributes
    public static final Hamburger hamburger = new Hamburger("Mc Burger");
    public static final Accompagnement accompagnement = new Accompagnement("Mc Frites");
    public static final Boisson boisson = new Boisson("Mc EAU");
    public static final int numClient = 1;

    public static final int NUM_COMMANDE = 1;

    public static Commande commande;

    // Methods
    @BeforeAll
    static void setup() {
        Assumptions.assumeTrue(hamburger != null);
        Assumptions.assumeTrue(accompagnement != null);
        Assumptions.assumeTrue(boisson != null);

        Commande.initialiserNumeroCommande();
        commande = new Commande(numClient, hamburger, accompagnement, boisson);
    }

    @Test
    void getNumeroCommandeAttribuee() {
        Assertions.assertEquals(commande.getNumeroCommandeAttribuee(), NUM_COMMANDE);
    }

    @Test
    void getNumClient() {
        Assertions.assertEquals(commande.getNumClient(), numClient);
    }

    @Test
    void getHamburger() {
        Assertions.assertEquals(commande.getHamburger(), hamburger);
    }

    @Test
    void getAccompagnement() {
        Assertions.assertEquals(commande.getAccompagnement(), accompagnement);
    }

    @Test
    void getBoisson() {
        Assertions.assertEquals(commande.getBoisson(), boisson);
    }

    @Test
    void initialiserNumeroCommande() {
        Commande.initialiserNumeroCommande();
        Commande commande2 = new Commande(numClient, hamburger, accompagnement, boisson);

        Assertions.assertEquals(commande2.getNumeroCommandeAttribuee(), NUM_COMMANDE);
    }
}