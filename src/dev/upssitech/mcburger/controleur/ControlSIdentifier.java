package dev.upssitech.mcburger.controleur;

import dev.upssitech.mcburger.modele.profil.ProfilUtilisateur;
import dev.upssitech.mcburger.modele.bd.BDClient;
import dev.upssitech.mcburger.modele.bd.BDPersonnel;

public class ControlSIdentifier {

    public static int sIdentifier(ProfilUtilisateur profilUtilisateur, String login, String mdp) {
        return switch(profilUtilisateur) {
            case CLIENT -> BDClient.getInstance().connexionClient(login, mdp);
            default -> BDPersonnel.getInstance().connexionPersonnel(login, mdp);
        };
    }

    public static String visualiserBDUtilisateur() {
        return BDPersonnel.getInstance() + "\n" + BDClient.getInstance() + "\n";
    }

}
