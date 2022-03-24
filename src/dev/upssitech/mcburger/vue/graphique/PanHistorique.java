package dev.upssitech.mcburger.vue.graphique;

import javax.swing.*;
import java.awt.*;

/**
 * class: PanHistorique
 * author: Guillaume Roussin
 * date: 10/03/2022
 */
public class PanHistorique extends JPanel {

    // Attributes
    private final String id = "HISTORIQUE";

    // controleurs du cas + panel des cas inclus ou etendus en lien avec un acteur
    // les attributs metiers (ex : numClient)

    // Les elements graphiques :
    // Declaration et creation des polices d'ecritures
    // Declaration et creation des ComboBox
    // Declaration et creation des Button
    // Declaration et creation des TextArea
    // Declaration et creation des Labels

    // Constructor
    public PanHistorique(
            // parametres pour l'initialisation des attributs metiers
            // parametres correspondants au controleur du cas + panels
            // des cas inclus ou etendus en lien avec un acteur
    ) {
        // initialisation des attributs metiers
        // initilaisation du controleur du cas + panels
        // des cas inclus ou etendus en lien avec un acteur
        initialisation();
    }

    // Methods


    public String getId() {
        return this.id;
    }

    public void initialisation() {
        this.setBackground(Color.CYAN);

        // creation des differents elements graphiques (JLabel, Combobox, Button, TextAera ...)

        // mise en page : placements des differents elements graphiques dans des Box
        // mise en page : placements des differentes box dans une box principale
        // mise en page : ajout de la box principale dans le panel
    }

    public void historique( /*parametres metiers*/ ) {
    }
}