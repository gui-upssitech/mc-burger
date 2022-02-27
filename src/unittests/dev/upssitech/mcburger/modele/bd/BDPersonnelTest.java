package dev.upssitech.mcburger.modele.bd;

import dev.upssitech.mcburger.modele.profil.Personnel;
import org.junit.jupiter.api.*;

class BDPersonnelTest {

    public static final String login = "Ping.Pong";
    public static final String mdp = "ppp";
    public static final int numPersonnel = 0;

    public static final Personnel personnel = new Personnel("Pong", "Ping", mdp);
    public static final Personnel newPersonnel = new Personnel("Pang", "Peng", "pdp");

    public static BDPersonnel bd;

    @BeforeAll
    static void setup() {
        Assumptions.assumeTrue(personnel != null);
        Assumptions.assumeTrue(newPersonnel != null);

        bd = BDPersonnel.getInstance();
        bd.addPersonnel(personnel);
    }

    @Test
    void addPersonnel() {
        int expectedId = 1;
        bd.addPersonnel(newPersonnel);

        Personnel personnelTrouve = bd.trouverPersonnel(expectedId);
        Assertions.assertEquals(personnelTrouve, newPersonnel);
    }

    @Test
    void connexionPersonnel() {
        int numPersonnelConnecte = bd.connexionPersonnel(login, mdp);
        int numPersonnelOOB = bd.connexionPersonnel("x", "x");

        Assertions.assertEquals(-1, numPersonnelOOB);
        Assertions.assertEquals(numPersonnel, numPersonnelConnecte);
        Assertions.assertTrue(personnel.isConnecte());
    }

    @AfterAll
    @Test
    static void testToString() {
        String expectedToString = "BDPersonnel [listePersonnel={0="+ personnel +", 1="+ newPersonnel +"}]";
        Assertions.assertEquals(expectedToString, bd.toString());
    }
}