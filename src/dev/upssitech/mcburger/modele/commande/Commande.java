package dev.upssitech.mcburger.modele.commande;

import dev.upssitech.mcburger.modele.aliment.Accompagnement;
import dev.upssitech.mcburger.modele.aliment.Boisson;
import dev.upssitech.mcburger.modele.aliment.Hamburger;

public class Commande {

    // Attributes
    private final int numClient;
    private final Hamburger hamburger;
    private final Accompagnement accompagnement;
    private final Boisson boisson;

    private final int numeroCommandeAttribuee;
    private static int numeroCommande = 0;

    // Constructor
    public Commande(int numClient, Hamburger hamburger, Accompagnement accompagnement, Boisson boisson) {
        numeroCommande++;
        numeroCommandeAttribuee = numeroCommande;

        this.numClient = numClient;
        this.hamburger = hamburger;
        this.accompagnement = accompagnement;
        this.boisson = boisson;
    }

    // Methods
    public int getNumeroCommandeAttribuee() {
        return numeroCommandeAttribuee;
    }

    public int getNumClient() {
        return numClient;
    }

    public Hamburger getHamburger() {
        return hamburger;
    }

    public Accompagnement getAccompagnement() {
        return accompagnement;
    }

    public Boisson getBoisson() {
        return boisson;
    }

    public static void initialiserNumeroCommande() {
        numeroCommande = 0;
    }
}
