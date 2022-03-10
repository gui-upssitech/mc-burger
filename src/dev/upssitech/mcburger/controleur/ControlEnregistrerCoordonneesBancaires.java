package dev.upssitech.mcburger.controleur;

import dev.upssitech.mcburger.modele.bd.BDClient;
import dev.upssitech.mcburger.modele.profil.Client;

public class ControlEnregistrerCoordonneesBancaires {

    // Methods
    public static boolean enregistrerCoordonneesBancaires(int numeroClient, int numeroCarte, int dateCarte) {
        boolean carteValide = ControlVerifierCoordonneesBancaires.verifierCoordonneesBancaires(numeroCarte, dateCarte);

        if(carteValide) {
            Client client = BDClient.getInstance().trouverClient(numeroClient);
            client.enregistrerCoordonneesBancaires(numeroCarte, dateCarte);
        }

        return carteValide;
    }
}
