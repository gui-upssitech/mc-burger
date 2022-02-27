package dev.upssitech.mcburger.modele.bd;

import dev.upssitech.mcburger.modele.aliment.Accompagnement;
import dev.upssitech.mcburger.modele.aliment.Boisson;
import dev.upssitech.mcburger.modele.aliment.Hamburger;
import dev.upssitech.mcburger.modele.commande.Commande;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BDCommandeTest {

    public static final Hamburger hamburger = new Hamburger("Mc Burger");
    public static final Accompagnement accompagnement = new Accompagnement("Mc Frites");
    public static final Boisson boisson = new Boisson("Mc EAU");
    public static final int numClient = 1;

    public static final int expectedNumCommande = 1;

    @Test
    void enregistrerCommande() {
        BDCommande bd = BDCommande.getInstance();
        int numCommande = bd.enregistrerCommande(numClient, hamburger, accompagnement, boisson);

        Assertions.assertEquals(expectedNumCommande, numCommande);
    }

    @AfterAll
    @Test
    static void testToString() {
        Commande.initialiserNumeroCommande();
        Commande commande = new Commande(numClient, hamburger, accompagnement, boisson);
        String expectedToString = "BDCommande [mapCommandes={1="+ commande +"}]";

        Assertions.assertEquals(expectedToString, BDCommande.getInstance().toString());
    }
}