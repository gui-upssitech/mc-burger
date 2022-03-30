package dev.upssitech.mcburger.tests.graphique;

import dev.upssitech.mcburger.controleur.ControlCommander;
import dev.upssitech.mcburger.controleur.ControlCreerProfil;
import dev.upssitech.mcburger.controleur.ControlSIdentifier;
import dev.upssitech.mcburger.modele.profil.ProfilUtilisateur;
import dev.upssitech.mcburger.vue.graphique.FrameClient;

/**
 * class: TestEcranClient
 * author: Guillaume Roussin
 * date: 10/03/2022
 */
public class TestEcranClient {

    public static void main(String[] args) {
        ControlCreerProfil controlCreerProfil = new ControlCreerProfil();
        ControlSIdentifier controlSIdentifier = new ControlSIdentifier();

        controlCreerProfil.creerProfil(ProfilUtilisateur.CLIENT, "Dupont", "Jean", "cjd");
        int numClient = controlSIdentifier.sIdentifier(ProfilUtilisateur.CLIENT, "Jean.Dupont", "cjd");

        new FrameClient(numClient);
    }

}