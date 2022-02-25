package dev.upssitech.mcburger.modele.profil;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    public static final String NOM = "Dupont";
    public static final String PRENOM = "Jean";
    public static final String MDP = "cjd";

    public static final int NUM_CARTE = 123456789;
    public static final int DATE_CARTE = 1234;

    public static final String expectedToString = "Client [carteBancaire=null, nom='Dupont', prenom='Jean', login='Jean.Dupont', mdp='cjd', connecte=false]";

    public static Client client;

    @BeforeAll
    static void setup() {
        Assumptions.assumeTrue(NOM != null);
        Assumptions.assumeTrue(PRENOM != null);
        Assumptions.assumeTrue(MDP != null);

        client = new Client(NOM, PRENOM, MDP);
    }

    @Test
    void verifierExistanceCarteBancaire() {
        Client client2 = new Client(NOM, PRENOM, MDP);

        Assertions.assertFalse(client2.verifierExistanceCarteBancaire());

        client2.enregistrerCoordonneesBancaires(NUM_CARTE, DATE_CARTE);
        Assertions.assertTrue(client2.verifierExistanceCarteBancaire());
    }

    @Test
    void testToString() {
        Assertions.assertEquals(client.toString(), expectedToString);
    }
}