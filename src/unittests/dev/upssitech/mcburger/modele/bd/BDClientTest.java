package dev.upssitech.mcburger.modele.bd;

import dev.upssitech.mcburger.modele.profil.Client;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class BDClientTest {

    public static final String login = "Jean.Dupont";
    public static final String mdp = "cjd";
    public static final int numClient = 0;

    public static final Client client = new Client("Dupont", "Jean", mdp);
    public static final Client newClient = new Client("Massiet", "Jean", "cjm");
    public static BDClient bd;

    @BeforeAll
    static void setup() {
        Assumptions.assumeTrue(client != null);
        Assumptions.assumeTrue(newClient != null);

        bd = BDClient.getInstance();
        bd.addClient(client);
    }

    @Test
    void addClient() {
        int expectedId = 1;
        bd.addClient(newClient);

        Client clientTrouve = bd.trouverClient(expectedId);
        Assertions.assertEquals(clientTrouve, newClient);
    }

    @Test
    void connexionClient() {
        int numClientConnecte = bd.connexionClient(login, mdp);
        int numClientOOB = bd.connexionClient("x", "x");

        Assertions.assertEquals(-1, numClientOOB);
        Assertions.assertEquals(numClient, numClientConnecte);
        Assertions.assertTrue(client.isConnecte());
    }

    @AfterAll
    @Test
    static void testToString() {
        String expectedToString = "BDClient [listeClients={0="+ client +", 1="+ newClient +"}]";
        Assertions.assertEquals(expectedToString, bd.toString());
    }
}