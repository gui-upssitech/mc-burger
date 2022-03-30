package dev.upssitech.mcburger.vue.graphique;

import dev.upssitech.mcburger.controleur.ControlCommander;
import dev.upssitech.mcburger.controleur.ControlEnregistrerCoordonneesBancaires;
import dev.upssitech.mcburger.controleur.ControlVerifierCoordonneesBancaires;
import dev.upssitech.mcburger.controleur.ControlVerifierIdentification;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * class: FrameClient
 * author: Guillaume Roussin
 * date: 10/03/2022
 */
public class FrameClient extends JFrame {

    // Attributes

    private final int numClient;

    // Declaration et creation de la barre de menu (MenuBar)
    private final MenuBar menuBar = new MenuBar();
    private final CardLayout cartes = new CardLayout();

    // Declaration et creation des differents panels
    private final JPanel panContents = new JPanel();
    private final PanCommander panCommander;
    private final PanModifierProfil panModifierProfil;
    private final PanHistorique panHistorique;
    private final PanEnregistrerCoordonneesBancaires panEnregistrerCoordonneesBancaires;

    // Constructor
    public FrameClient(int numClient) {
        this.numClient = numClient;

        ControlVerifierIdentification verifierIdentification = new ControlVerifierIdentification();
        ControlCommander controlCommander = new ControlCommander(verifierIdentification);

        ControlVerifierCoordonneesBancaires verifierCoordonneesBancaires = new ControlVerifierCoordonneesBancaires();
        ControlEnregistrerCoordonneesBancaires enregistrerCoordonneesBancaires = new ControlEnregistrerCoordonneesBancaires(verifierCoordonneesBancaires);

        this.panEnregistrerCoordonneesBancaires = new PanEnregistrerCoordonneesBancaires(enregistrerCoordonneesBancaires);

        this.panCommander = new PanCommander(controlCommander, panEnregistrerCoordonneesBancaires);
        this.panModifierProfil = new PanModifierProfil();
        this.panHistorique = new PanHistorique();

        // Mise en forme de la fenetre
        this.setTitle("Mc Burger");
        this.setSize(900, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Remplissage de la fenetre
        this.initialisationLayout();
        this.initialisationMenu();
        this.initialisationAcceuil();

        this.setVisible(true);
    }

    // Methods

    private void initialisationLayout() {
        panContents.setLayout(cartes);
        panContents.add(panCommander, panCommander.getId());
        panContents.add(panEnregistrerCoordonneesBancaires, panEnregistrerCoordonneesBancaires.getId());
        panContents.add(panModifierProfil, panModifierProfil.getId());
        panContents.add(panHistorique, panHistorique.getId());

        getContentPane().add(panContents);
    }

    private void initialisationMenu() {
        Menu menuProfil = new Menu("Mon compte");
        Menu menuDeconnexion = new Menu("Déconnexion");

        menuProfil.add(createClickableItem("Commander", panCommander.getId(), event -> panCommander.commander(numClient)));
        menuProfil.add(createClickableItem("Modifier profil", panModifierProfil.getId()));
        menuProfil.add(createClickableItem("Historique", panHistorique.getId()));

        menuBar.add(menuProfil);
        menuBar.add(menuDeconnexion);

        setMenuBar(menuBar);
    }

    private MenuItem createClickableItem(String label, String paneId, ActionListener l) {
        MenuItem menuItem = new MenuItem(label);
        menuItem.addActionListener(event -> {
            cartes.show(panContents, paneId);
            l.actionPerformed(event);
        });

        return menuItem;
    }

    private MenuItem createClickableItem(String label, String paneId) {
        return createClickableItem(label, paneId, event -> {});
    }

    private void initialisationAcceuil() {
        JPanel panAccueil = new JPanel();

        panAccueil.setBackground(Color.ORANGE);
        JLabel texteAccueil = new JLabel("Bienvenu à Burger Resto");
        texteAccueil.setFont(new Font("Calibri", Font.BOLD, 24));
        panAccueil.add(texteAccueil);
        panAccueil.setVisible(true);
        panContents.add(panAccueil, "ECRAN_ACCUEIL");
        cartes.show(panContents, "ECRAN_ACCUEIL");
    }

}