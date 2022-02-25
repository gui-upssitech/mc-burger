package dev.upssitech.mcburger.modele.profil;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FabriqueProfilTest {

    public static final String NOM = "Dupont";
    public static final String PRENOM = "Jean";
    public static final String MDP = "cjd";

    public static final Client clientTest = new Client(NOM, PRENOM, MDP);
    public static final Personnel personnelTest = new Personnel(NOM, PRENOM, MDP);

    @Test
    void creerProfil() {
        Assumptions.assumeTrue(clientTest != null);
        Assumptions.assumeTrue(personnelTest != null);

        // Test client
        Client client = (Client) FabriqueProfil.creerProfil(ProfilUtilisateur.CLIENT, NOM, PRENOM, MDP);
        Assertions.assertEquals(client, clientTest);

        // Test personnel
        Personnel personnel = (Personnel) FabriqueProfil.creerProfil(ProfilUtilisateur.PERSONNEl, NOM, PRENOM, MDP);
        Assertions.assertEquals(personnel, personnelTest);

        // Test gérant
        personnelTest.setGerant();
        Personnel gerant = (Personnel) FabriqueProfil.creerProfil(ProfilUtilisateur.GERANT, NOM, PRENOM, MDP);
        Assertions.assertEquals(gerant, personnelTest);

    }
}