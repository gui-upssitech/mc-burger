package dev.upssitech.mcburger.vueconsole;

import dev.upssitech.mcburger.Clavier;
import dev.upssitech.mcburger.controleur.ControlSIdentifier;
import dev.upssitech.mcburger.modele.profil.ProfilUtilisateur;

public class BoundarySIdentifierPersonnel {

    private final ControlSIdentifier controlSIdentifier;

    public BoundarySIdentifierPersonnel(ControlSIdentifier controlSIdentifier) {
        this.controlSIdentifier = controlSIdentifier;
    }

    public int sIdentifierPersonnel() {
        String login, mdp;

        System.out.println("Login personnel\n===\n");

        System.out.print("Login: ");
        login = Clavier.entrerClavierString();

        System.out.print("Mot de passe: ");
        mdp = Clavier.entrerClavierString();

        return controlSIdentifier.sIdentifier(ProfilUtilisateur.PERSONNEl, login, mdp);
    }
}