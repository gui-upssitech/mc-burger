package dev.upssitech.mcburger.modele.profil;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonnelTest {

    public static final String NOM = "Dupont";
    public static final String PRENOM = "Jean";
    public static final String MDP = "pjd";

    public static Personnel personnel;

    public static final String expectedToString = "Personnel [gerant=false, nom='Dupont', prenom='Jean', login='Jean.Dupont', mdp='pjd', connecte=false]";

    @BeforeAll
    static void setup() {
        Assumptions.assumeTrue(NOM != null);
        Assumptions.assumeTrue(PRENOM != null);
        Assumptions.assumeTrue(MDP != null);

        personnel = new Personnel(NOM, PRENOM, MDP);
    }

    @Test
    void verifierCorrespondanceProfil() {
        boolean isAccount = personnel.verifierCorrespondanceProfil(PRENOM+"."+NOM, MDP);
        Assertions.assertTrue(isAccount);
    }

    @Test
    void isConnecte() {
        Personnel personnel2 = new Personnel(NOM, PRENOM, MDP);
        Assertions.assertFalse(personnel2.isConnecte());
        personnel2.connexionProfil();
        Assertions.assertTrue(personnel2.isConnecte());
    }

    @Test
    void isGerant() {
        Personnel personnel2 = new Personnel(NOM, PRENOM, MDP);
        Assertions.assertFalse(personnel2.isGerant());
        personnel2.setGerant();
        Assertions.assertTrue(personnel2.isGerant());
    }

    @Test
    void testToString() {
        Assertions.assertEquals(personnel.toString(), expectedToString);
    }
}