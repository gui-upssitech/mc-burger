package dev.upssitech.mcburger.controleur;

import dev.upssitech.mcburger.modele.aliment.*;
import dev.upssitech.mcburger.modele.bd.BDClient;
import dev.upssitech.mcburger.modele.bd.BDCommande;
import dev.upssitech.mcburger.modele.bd.Menu;
import dev.upssitech.mcburger.modele.profil.Client;
import dev.upssitech.mcburger.modele.profil.ProfilUtilisateur;

import java.util.ArrayList;
import java.util.List;

public class ControlCommander {

    // Attributes
    private final ControlVerifierIdentification controlVerifierIdentification;

    // Constructor
    public ControlCommander(ControlVerifierIdentification controlVerifierIdentification) {
        this.controlVerifierIdentification = controlVerifierIdentification;
    }

    // Methods
    public boolean verifierIdentification(int numClient) {
        return controlVerifierIdentification.verifierIdentification(ProfilUtilisateur.CLIENT, numClient);
    }

    public boolean verifierExistanceCarteBancaire(int numClient) {
        Client client = BDClient.getInstance().trouverClient(numClient);
        return client.verifierExistanceCarteBancaire();
    }

    private List<String> listeAlimentToString(AlimentMenu typeAliment) {
        Menu menu;
        List<?> listeAliments;
        List<String> listeNomItems;

        menu = Menu.getInstance();
        listeAliments = switch (typeAliment) {
            case HAMBURGER -> menu.getListeHamburger();
            case ACCOMPAGNEMENT -> menu.getListeAccompagnement();
            case BOISSON -> menu.getListeBoisson();
        };

        listeNomItems = new ArrayList<>();
        for(Object objetAliment : listeAliments) {
            Aliment aliment = (Aliment) objetAliment;
            listeNomItems.add(aliment.getNom());
        }

        return listeNomItems;
    }

    public List<String> donnerListeHamburger() {
        return listeAlimentToString(AlimentMenu.HAMBURGER);
    }

    public List<String> donnerListeAccompagnement() {
        return listeAlimentToString(AlimentMenu.ACCOMPAGNEMENT);
    }

    public List<String> donnerListeBoisson() {
        return listeAlimentToString(AlimentMenu.BOISSON);
    }

    public int enregistrerCommande(int numClient, int numeroHamburger, int numeroAccompagnement, int numeroBoisson) {
        Menu menu = Menu.getInstance();

        Hamburger hamburger = menu.choixHamburger(numeroHamburger);
        Accompagnement accompagnement = menu.choixAccompagnement(numeroAccompagnement);
        Boisson boisson = menu.choixBoisson(numeroBoisson);

        int numeroCommande = BDCommande.getInstance()
                .enregistrerCommande(numClient, hamburger, accompagnement, boisson);

        return numeroCommande;
    }

}
