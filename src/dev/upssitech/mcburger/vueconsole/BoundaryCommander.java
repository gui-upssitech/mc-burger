package dev.upssitech.mcburger.vueconsole;

import dev.upssitech.mcburger.Clavier;
import dev.upssitech.mcburger.controleur.ControlCommander;

import java.util.List;

public class BoundaryCommander {

    // Attributes
    private final BoundaryEnregistrerCoordonneesBancaires boundaryEnregistrerCoordonneesBancaires;
    private final ControlCommander controlCommander;

    // Constructor
    public BoundaryCommander(ControlCommander controlCommander, BoundaryEnregistrerCoordonneesBancaires boundaryEnregistrerCoordonneesBancaires) {
        this.controlCommander = controlCommander;
        this.boundaryEnregistrerCoordonneesBancaires = boundaryEnregistrerCoordonneesBancaires;
    }

    // Methods
    public void commander(int numClient) {
        int numBurger, numAccompagnement, numBoisson, numCommande;
        boolean carteRenseignee;

        if(!controlCommander.verifierIdentification(numClient))
            return;

        numBurger = selectionnerBurger();
        numAccompagnement = selectionnerAccompagnement();
        numBoisson = selectionnerBoisson();

        carteRenseignee = controlCommander.verifierExistanceCarteBancaire(numClient);

        if(!carteRenseignee) {
            System.out.println("");
            boundaryEnregistrerCoordonneesBancaires.enregistrerCoordonneesBancaires(numClient);
        }

        numCommande = controlCommander.enregistrerCommande(numClient, numBurger, numAccompagnement, numBoisson);
        System.out.println("Votre numéro de commande est: " + numCommande);
    }

    private int selectionnerBurger() {
        System.out.println("\nChoix de hamburger: ");
        return selectionnerDansListe(
                controlCommander.donnerListeHamburger()
        );
    }

    private int selectionnerAccompagnement() {
        System.out.println("\nChoix d'accompagnement: ");
        return selectionnerDansListe(
                controlCommander.donnerListeAccompagnement()
        );
    }

    private int selectionnerBoisson() {
        System.out.println("\nChoix de boisson");
        return selectionnerDansListe(
                controlCommander.donnerListeBoisson()
        );
    }

    private int selectionnerDansListe(List<String> liste) {
        int id;

        for(int i = 0; i < liste.size(); i++) {
            System.out.println((i+1) + ". " + liste.get(i));
        }

        do {
            System.out.print("Votre choix: ");
            id = Clavier.entrerClavierInt();
            if(id < 1 || id > liste.size())
                System.out.println("Choix invalide");
        } while(id < 1 || id > liste.size());

        return id - 1;
    }

}
