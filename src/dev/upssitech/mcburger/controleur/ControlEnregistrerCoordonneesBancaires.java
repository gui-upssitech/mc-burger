package dev.upssitech.mcburger.controleur;

import dev.upssitech.mcburger.modele.bd.BDClient;
import dev.upssitech.mcburger.modele.profil.Client;

public class ControlEnregistrerCoordonneesBancaires {

    private final ControlVerifierCoordonneesBancaires controlVerifierCoordonneesBancaires;
    private final BDClient bdClient;

    public ControlEnregistrerCoordonneesBancaires(ControlVerifierCoordonneesBancaires controlVerifierCoordonneesBancaires) {
        this.controlVerifierCoordonneesBancaires = controlVerifierCoordonneesBancaires;
        this.bdClient = BDClient.getInstance();
    }

    // Methods
    public boolean enregistrerCoordonneesBancaires(int numeroClient, int numeroCarte, int dateCarte) {
        boolean carteValide = controlVerifierCoordonneesBancaires.verifierCoordonneesBancaires(numeroCarte, dateCarte);

        if(carteValide) {
            Client client = bdClient.trouverClient(numeroClient);
            client.enregistrerCoordonneesBancaires(numeroCarte, dateCarte);
        }

        return carteValide;
    }
}
