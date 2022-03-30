package dev.upssitech.mcburger.controleur;

import dev.upssitech.mcburger.modele.profil.ProfilUtilisateur;
import dev.upssitech.mcburger.modele.bd.BDClient;
import dev.upssitech.mcburger.modele.bd.BDPersonnel;

public class ControlSIdentifier {

    private final BDClient bdClient;
    private final BDPersonnel bdPersonnel;

    public ControlSIdentifier() {
        bdClient = BDClient.getInstance();
        bdPersonnel = BDPersonnel.getInstance();
    }

    public int sIdentifier(ProfilUtilisateur profilUtilisateur, String login, String mdp) {
        return (profilUtilisateur == ProfilUtilisateur.CLIENT)
            ? bdClient.connexionClient(login, mdp)
            : bdPersonnel.connexionPersonnel(login, mdp);
    }

    public String visualiserBDUtilisateur() {
        return bdPersonnel + "\n" + bdClient + "\n";
    }

}
