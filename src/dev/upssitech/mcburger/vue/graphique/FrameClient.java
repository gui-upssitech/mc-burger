package dev.upssitech.mcburger.vue.vuegraphique;

import javax.swing.*;

/**
 * class: FrameClient
 * author: Guillaume Roussin
 * date: 10/03/2022
 */
public class FrameClient extends JFrame {

    // Attributes

    private int numClient;
    // Les attributs metiers (ex : numClient)
    // Declaration et creation des elements graphiques (JLabel)
    // Declaration et creation de la barre de menu (MenuBar)
    // Declaration et creation des differents panels
    // Declaration et creation du gestionnaire des cartes (CardLayout)

    // Constructor
    public FrameClient(int numClient) {
        // initialisation des attributs metiers
        this.numClient = numClient;

        // mise en forme de la frame (titre, dimension, ...)
        this.setTitle("Mc Burger");
        this.setSize(900, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // initialisation des differents panels : appel a leur methode d'initialisation
        // ajout des pannels dans le ContentPane de la Frame
        // mise en page : mises en place des cartes
        // mise en place du menu

        this.initialisationMenu();
        this.initialisationAcceuil();

        this.setVisible(true);
    }

    // Methods

    private void initialisationMenu() {
    }

    private void initialisationAcceuil(){
    }

}