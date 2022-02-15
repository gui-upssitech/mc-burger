package dev.upssitech.mcburger.vueconsole;

import dev.upssitech.mcburger.Clavier;
import dev.upssitech.mcburger.controleur.ControlSIdentifier;
import dev.upssitech.mcburger.modele.ProfilUtilisateur;

public class BoundarySIdentifierClient {

    private final ControlSIdentifier controlSIdentifier;

    public BoundarySIdentifierClient(ControlSIdentifier controlSIdentifier) {
        this.controlSIdentifier = controlSIdentifier;
    }

    public int sIdentifierClient() {
        String login, mdp;

        System.out.println("Login client\n===\n");

        System.out.print("Login: ");
        login = Clavier.entrerClavierString();

        System.out.print("Mot de passe: ");
        mdp = Clavier.entrerClavierString();

        return controlSIdentifier.sIdentifier(ProfilUtilisateur.CLIENT, login, mdp);
    }
}
