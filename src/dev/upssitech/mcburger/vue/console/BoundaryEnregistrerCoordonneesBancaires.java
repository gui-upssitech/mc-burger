package dev.upssitech.mcburger.vue.console;

import dev.upssitech.mcburger.Clavier;
import dev.upssitech.mcburger.controleur.ControlEnregistrerCoordonneesBancaires;

public class BoundaryEnregistrerCoordonneesBancaires {

    // Attributes
    private final ControlEnregistrerCoordonneesBancaires controlEnregistrerCoordonneesBancaires;

    // Constructor
    public BoundaryEnregistrerCoordonneesBancaires(ControlEnregistrerCoordonneesBancaires controlEnregistrerCoordonneesBancaires) {
        this.controlEnregistrerCoordonneesBancaires = controlEnregistrerCoordonneesBancaires;
    }

    // Methods
    public void enregistrerCoordonneesBancaires(int numClient) {
        int numeroCarte, dateCarte;

        System.out.print("Numéro de carte: ");
        numeroCarte = Clavier.entrerClavierInt();

        System.out.print("Date d'expiration de la carte: ");
        dateCarte = Clavier.entrerClavierInt();

        boolean carteValide = controlEnregistrerCoordonneesBancaires.enregistrerCoordonneesBancaires(numClient, numeroCarte, dateCarte);
        if (!carteValide)
            System.out.println("Carte invalide ! La commande a échouée");
    }
}
