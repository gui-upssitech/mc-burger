package dev.upssitech.mcburger.controleur;

import dev.upssitech.mcburger.modele.bd.BDClient;
import dev.upssitech.mcburger.modele.profil.Client;

public class ControlEnregistrerCoordonneesBancaires {

    // Attributes
    private final ControlVerifierCoordonneesBancaires controlVerifierCoordonneesBancaires;

    // Constructor
    public ControlEnregistrerCoordonneesBancaires(ControlVerifierCoordonneesBancaires controlVerifierCoordonneesBancaires) {
        this.controlVerifierCoordonneesBancaires = controlVerifierCoordonneesBancaires;
    }

    // Methods
    public boolean enregistrerCoordonneesBancaires(int numeroClient, int numeroCarte, int dateCarte) {
        boolean carteValide = controlVerifierCoordonneesBancaires.verifierCoordonneesBancaires(numeroCarte, dateCarte);

        if(carteValide) {
            Client client = BDClient.getInstance().trouverClient(numeroClient);
            client.enregistrerCoordonneesBancaires(numeroCarte, dateCarte);
        }

        return carteValide;
    }
}
