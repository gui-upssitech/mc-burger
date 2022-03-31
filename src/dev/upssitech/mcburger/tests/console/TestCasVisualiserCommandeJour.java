package dev.upssitech.mcburger.tests.console;


import dev.upssitech.mcburger.controleur.*;
import dev.upssitech.mcburger.modele.ThreadViderCommandeJour;
import dev.upssitech.mcburger.modele.aliment.AlimentMenu;
import dev.upssitech.mcburger.modele.profil.ProfilUtilisateur;
import dev.upssitech.mcburger.vue.console.BoundaryCommander;
import dev.upssitech.mcburger.vue.console.BoundaryEnregistrerCoordonneesBancaires;
import dev.upssitech.mcburger.vue.console.BoundaryVisualiserCommandeJour;

public class TestCasVisualiserCommandeJour {

	public static void main(String[] args) {
		// Création controlleurs
		ControlVerifierCoordonneesBancaires verifierCoordonneesBancaires = new ControlVerifierCoordonneesBancaires();
		ControlVerifierIdentification verifierIdentification = new ControlVerifierIdentification();
		ControlAjouterAlimentMenu controlAjouterAlimentMenu = new ControlAjouterAlimentMenu(verifierIdentification);

		ControlCreerProfil controlCreerProfil = new ControlCreerProfil();
		ControlSIdentifier controlSIdentifier = new ControlSIdentifier();
		
		
		// Mise en place de l'environnement
		controlAjouterAlimentMenu.ajouterAliment(AlimentMenu.HAMBURGER, "baconBurger");
		controlAjouterAlimentMenu.ajouterAliment(AlimentMenu.HAMBURGER, "chickenBurger");
		controlAjouterAlimentMenu.ajouterAliment(AlimentMenu.HAMBURGER, "cheeseBurger");
		controlAjouterAlimentMenu.ajouterAliment(AlimentMenu.ACCOMPAGNEMENT, "frites");
		controlAjouterAlimentMenu.ajouterAliment(AlimentMenu.ACCOMPAGNEMENT, "pommesChips");
		controlAjouterAlimentMenu.ajouterAliment(AlimentMenu.BOISSON, "coca");
		controlAjouterAlimentMenu.ajouterAliment(AlimentMenu.BOISSON, "orangeBubbles");

		//Cr�ation et connexion des profils clients
		controlCreerProfil.creerProfil(ProfilUtilisateur.CLIENT, "Dupond", "Hector", "cdh");
		int numClient = controlSIdentifier.sIdentifier(ProfilUtilisateur.CLIENT, "Hector.Dupond", "cdh");

		controlCreerProfil.creerProfil(ProfilUtilisateur.CLIENT, "Durand", "Jacques", "cdj");
		int numClient2 = controlSIdentifier.sIdentifier(ProfilUtilisateur.CLIENT, "Jacques.Durand", "cdj");
		
		//Cr�ation et connexion des profils cuisiniers
        controlCreerProfil.creerProfil(ProfilUtilisateur.PERSONNEl, "Martin", "Stephane", "pms");
        int numCuisinier = controlSIdentifier.sIdentifier(ProfilUtilisateur.PERSONNEl, "Stephane.Martin", "pms");
        
        controlCreerProfil.creerProfil(ProfilUtilisateur.PERSONNEl, "Bernard", "Christophe", "pbc");
        int numCuisinier2 = controlSIdentifier.sIdentifier(ProfilUtilisateur.PERSONNEl, "Christophe.Bernard", "pbc");

		// Initialisation vue du cas & cas Inclus/etendu
		BoundaryEnregistrerCoordonneesBancaires boundaryEnregistrerCoordonneesBancaires = new BoundaryEnregistrerCoordonneesBancaires(
				new ControlEnregistrerCoordonneesBancaires(verifierCoordonneesBancaires));
		BoundaryCommander boundaryCommander = new BoundaryCommander(new ControlCommander(verifierIdentification),
				boundaryEnregistrerCoordonneesBancaires);

		// creation pour la visualisation de la commande
		ControlVerifierIdentification controlVerifierIdentification = new ControlVerifierIdentification();
		ControlVisualiserCommandeJour controlVisualiserCommandeJour = new ControlVisualiserCommandeJour(controlVerifierIdentification);

		BoundaryVisualiserCommandeJour boundaryVisualiserCommandeJour = new BoundaryVisualiserCommandeJour(controlVisualiserCommandeJour);
		boundaryVisualiserCommandeJour.visualiserCommandeJour(numCuisinier);
		boundaryVisualiserCommandeJour.visualiserCommandeJour(numCuisinier2);

		// Thread
		ThreadViderCommandeJour threadViderCommande = new ThreadViderCommandeJour();
		threadViderCommande.start();

		//Lancement du test
		System.out.println("\nCommande client 1");
		boundaryCommander.commander(numClient);
		System.out.println("\nCommande client 2");
		boundaryCommander.commander(numClient2);
	}

}
