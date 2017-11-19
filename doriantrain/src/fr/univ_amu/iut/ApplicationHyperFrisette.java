package fr.univ_amu.iut;


//import java.util.ArrayList;

public class ApplicationHyperFrisette {
	
	/*
	 * Architecture du simulateur HyperFrisette:
	 * 
	 * on va organiser tout le logiciel autour d'un pattern mvc:
	 * - pattern mvc:
	 *   - on va avoir un gros bordel ferroviere, avec des sillions (la partie la plus importante du truc),
	 *      des lignes, des garres, des trains, et des sous.
	 *      => ca va etre le modele.
	 *   - on va avoir des "vues": ça va etre nos vue.
	 *     a la fin du sujet:
	 *       * Une vue "debug" uniquement destineee a afficher nos test lors du dev.
	 *       * Une vue qui affiche l'ensemble du réseau à l'etat actuel : les trains et leur 
	 *         situation dans le reseau, les gares
	 *       * Une vue qui affiche le panneau des temps d'arrivee estimes dans les gares
	 *       * Une vue qui affiche le panneau des temps de départ estimes dans les gares
	 *       * Un panneau affichant les perturbations dans le reseau : retards, pannes
	 *          dans les trains ou dans les gares
	 *    - Pour mettre tout ca en mouvement, et dire a l'application de faire des trucs,
	 *      on va avoir un controlleur pour la controller:
	 *        On pourrait imaginer differents types de controlleurs:
	 *        * un fichier avec une liste de trucs a faire
	 *        * la lecture sur la ligne de commande de stdin, avec un menu et le choix
	 *          d'actions possibles ...
	 *        * ... (des clicks sur les jolis boutons d'une jolie interface graphique). 
	 *     - Dans le controlleurs, de maniere separee une reception des ordre/ des commandes,
	 *       on va avoir chaque traitement possible qu'on va coder: moteur de simulation.
	 * 
	 */
	
	VueGenerique laVue;
	
	
	public static void test_viteuf1() {
		System.out.println("Plop !");
		FabriqueTrain factory = new TrainBetail();
		Train train = new Train(factory);
		train.creationTrain();
        System.out.println(train);

		FabriqueWagon factoryPassagers = new WagonPassager();
		FabriqueWagon factoryBetail = new WagonBetail();
		FabriqueWagon factoryDechet = new WagonDechets();
		FabriqueWagon factoryLiquide = new WagonLiquide();
		FabriqueWagon factoryMarchandise = new WagonMarchandise();

        Wagon wagonPassager = new Wagon(factoryPassagers,100);
		Wagon wagonBetail = new Wagon(factoryBetail, 200);
        Wagon wagonDechet = new Wagon(factoryDechet,300);
        Wagon wagonLiquide = new Wagon(factoryLiquide,400);
        Wagon wagonMarchandise = new Wagon(factoryMarchandise,500);


        System.out.println(wagonPassager);
        System.out.println(wagonBetail);
        System.out.println(wagonDechet);
        System.out.println(wagonLiquide);
        System.out.println(wagonMarchandise);

		FabriqueEntreprise entreprisePassagers = new EntrepriseFerroviairePassagers();
		FabriqueEntreprise entrepriseAnimaux = new EntrepriseFerroviaireAnimaux();
		FabriqueEntreprise entrepriseCargo = new EntrepriseFerroviaireCargo();

		EntrepriseFerroviaire entrepriseFerroviairePassager = new EntrepriseFerroviaire(entreprisePassagers,"meddyPassager","pinpom",100);
		EntrepriseFerroviaire entrepriseFerroviaireAnimaux = new EntrepriseFerroviaire(entrepriseAnimaux,"meddyAnimaux","pinpom",200);
		EntrepriseFerroviaire entrepriseFerroviaireCargo = new EntrepriseFerroviaire(entrepriseCargo,"meddyCargo","pinpom",300);

		System.out.println(entrepriseFerroviairePassager);
		System.out.println(entrepriseFerroviaireAnimaux);
		System.out.println(entrepriseFerroviaireCargo);

		Gare gareAix = Gare.creeGare("Aix-en-Provence");
		Gare gareTataouineLesBains = Gare.creeGare("Tataouine-les-Bains");
		System.out.println(gareAix + "\n" + gareTataouineLesBains);

		
		Train t = FabriqueTrain.getSingleton().getNouveauTrain();
		
	}
	
	private void fermetureProgramme()
	{
		laVue.fermeAffichage();
	}

	public void monSleepDeBoucle() {
		try
		{
			Thread.sleep(1000);
		}
		catch (Exception e) {
			// bah ... non ... ca doit marcher!
		}
	}
		
	
	public void boucleApplication() {
		ReceptionCommandesTerm monInput;
		
		monInput = new ReceptionCommandesTerm();
		monInput.enregistrerObservateur(laVue);
		while (true)
		{
			laVue.metAJourAffichage();
			monInput.obtiensActionSuivanteAFaire();
			monSleepDeBoucle();
		}
		
	}
		

	/**
	 * Tout le programme.
	 * (main objet).
	 */
	public void lance() {
		
		

		//mettre en place le modele: Initialiser tous les trucs par defaut qui doivent toujours exister.
		DonneesFerrovieres.accedeAuxDonnees(); //on appelle le  getSingleton pour forcer l'initilisation ici.

		// demarrer l'affichage d'une ou plusieurs vues.
		laVue = FabriqueDeVue.getFabriqueDebugConsole();

		// prendre en compte (en boucle?) les odres du/des controlleurs pour ... que le programme fasse quelquechose.


		boucleApplication();
		//test_viteuf1();
	}

	public static void main(String[] args) {
		ApplicationHyperFrisette leSimulateur;

		leSimulateur = new ApplicationHyperFrisette();
		leSimulateur.lance();
		leSimulateur.fermetureProgramme();
	}
}

