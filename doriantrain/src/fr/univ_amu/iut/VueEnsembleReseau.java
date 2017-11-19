package fr.univ_amu.iut;

/**
 * d'apres le sujet:
 * Une vue qui affiche l'ensemble du reseau à l'etat actuel : les trains et leur situation dans le reseau, les gares
 * 
 * @author Dorian
 *
 */
public class VueEnsembleReseau  implements VueGenerique {
	
	@Override
	public void initialiseAffichage() {
		System.out.println("######################");
		System.out.println("# Initialisation...  #");
		System.out.println("######################");
	}

	@Override
	public void prendEnCompteNouvellesDonnes() {
		// TODO Auto-generated method stub

	}

	@Override
	public void metAJourAffichage() {
		System.out.println("#################################");
		System.out.println("# Etat de l'enssemble du Reseau #");
		System.out.println("#################################");
		System.out.println("#######    Heure: "+ DonneesFerrovieres.accedeAuxDonnees().getHeureActuelle()+"    ########");
		System.out.println("#################################");
		System.out.println("  Liste des gares: ");
		for (Gare uneGare : DonneesFerrovieres.accedeAuxDonnees().toutesLesGares) {
			System.out.print("    ");
			System.out.println(uneGare.getNom());
		}
		System.out.println("  Liste des Trains: ");
		for (Train unTrain : DonneesFerrovieres.accedeAuxDonnees().tousLesTrains) {
			System.out.print("    ");
			System.out.println(unTrain);
			System.out.print("      Position: ");
			switch (unTrain.etatActuel) {
			case TRAIN_HORS_RESEAU:
				System.out.println("Hors du reseau HyperFrisette.");
				break;
			case TRAIN_ARRET_GARE:
				System.out.print("Dans la gare: ");
				System.out.println(unTrain.nomGare);
				break;
			case TRAIN_AVANCE_SILLON:
				System.out.print("En chemin entre ");
				System.out.print(unTrain.positionActuelle.ligneDeCeSillon.getGareDepart().getNom());
				System.out.print(" et ");
				System.out.print(unTrain.positionActuelle.ligneDeCeSillon.getGareArrivee().getNom());
				System.out.print(". Avancement: ");
				System.out.print(unTrain.progressionDansLeSillon*100);
				System.out.println("%.");
				break;
			}
			
		}



	}

	@Override
	public void fermeAffichage() {
		// TODO Auto-generated method stub
	}

	@Override
	public void mettreAJour(EFonctionaliteAAfficher f) {
		// rien a faire pour cette vue.
		
	}
}
