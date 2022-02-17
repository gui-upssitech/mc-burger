package dev.upssitech.mcburger.vueconsole;

import dev.upssitech.mcburger.Clavier;
import dev.upssitech.mcburger.controleur.ControlAjouterAlimentMenu;
import dev.upssitech.mcburger.modele.aliment.AlimentMenu;
import dev.upssitech.mcburger.modele.profil.ProfilUtilisateur;

public class BoundaryAjouterAlimentMenu {

    // Attributes
    private final ControlAjouterAlimentMenu controlAjouterAlimentMenu;

    // Constructor
    public BoundaryAjouterAlimentMenu(ControlAjouterAlimentMenu controlAjouterAlimentMenu) {
        this.controlAjouterAlimentMenu = controlAjouterAlimentMenu;
    }

    // Methods
    public void ajouterAlimentMenu(int numProfil) {
        int choix;
        String nomAliment;

        if(!controlAjouterAlimentMenu.verifierIdentificationProfilUtilisateur(ProfilUtilisateur.GERANT, numProfil))
            return;

        System.out.println("""
            Type d'aliment:
            1. Hamburger
            2. Accompagnement
            3. Boisson
        """);
        System.out.print("Votre choix (1/2/3): ");
        choix = Clavier.entrerClavierInt();

        System.out.print("Nom de l'aliment: ");
        nomAliment = Clavier.entrerClavierString();

        switch (choix) {
            case 1 -> controlAjouterAlimentMenu.ajouterAliment(AlimentMenu.HAMBURGER, nomAliment);
            case 2 -> controlAjouterAlimentMenu.ajouterAliment(AlimentMenu.ACCOMPAGNEMENT, nomAliment);
            case 3 -> controlAjouterAlimentMenu.ajouterAliment(AlimentMenu.BOISSON, nomAliment);
            default -> System.out.println("Erreur : Type d'aliment non reconnu !");
        }
    }

}
