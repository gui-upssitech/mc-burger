package dev.upssitech.mcburger.tests.graphique;

import dev.upssitech.mcburger.controleur.*;
import dev.upssitech.mcburger.modele.aliment.AlimentMenu;
import dev.upssitech.mcburger.modele.profil.ProfilUtilisateur;
import dev.upssitech.mcburger.vue.graphique.FrameClient;

import java.util.List;

/**
 * class: TestEcranClient
 * author: Guillaume Roussin
 * date: 10/03/2022
 */
public class TestEcranClient {

    public static void main(String[] args) {
        new TestEcranClient().start();
    }

    private final ControlAjouterAlimentMenu controlAjouterAlimentMenu;

    public TestEcranClient() {
        controlAjouterAlimentMenu = new ControlAjouterAlimentMenu(new ControlVerifierIdentification());
    }

    public void start() {
        ControlCreerProfil controlCreerProfil = new ControlCreerProfil();
        ControlSIdentifier controlSIdentifier = new ControlSIdentifier();

        controlCreerProfil.creerProfil(ProfilUtilisateur.CLIENT, "Dupont", "Jean", "cjd");
        int numClient = controlSIdentifier.sIdentifier(ProfilUtilisateur.CLIENT, "Jean.Dupont", "cjd");

        addMenuItems(AlimentMenu.HAMBURGER, List.of("Mc Burger", "Mc Tasty", "Mc Don"));
        addMenuItems(AlimentMenu.ACCOMPAGNEMENT, List.of("Mc Eau", "Mc Java"));
        addMenuItems(AlimentMenu.BOISSON, List.of("Mc Donut", "Mc Pantouffle"));

        new FrameClient(numClient);
    }

    private void addMenuItems(AlimentMenu type, List<String> items) {
        for(String s : items) controlAjouterAlimentMenu.ajouterAliment(type, s);
    }
}