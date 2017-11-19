package fr.univ_amu.iut;

import java.util.LinkedList;

/**
 * Pas une classe completement concrete, car elle est juste par pour 
 * l'heritage: c'est la base commune de tous les systemes de
 * reception de commandes.
 * 
 * 
 * @author Dorian
 *
 */
public abstract class ObvservableSemiConcret implements Observable {

	LinkedList<ObservateurDeCommande> lesObservateurs;
	
	public ObvservableSemiConcret() {
		lesObservateurs = new LinkedList<ObservateurDeCommande>();
		
	}
	
	@Override
	public void enregistrerObservateur(ObservateurDeCommande observateur) {
		lesObservateurs.addLast(observateur);
	}

	@Override
	public void supprimerObservateur(ObservateurDeCommande observateur) {
		lesObservateurs.remove(observateur);
		/*int posObjetDansListe; 
		
		posObjetDansListe = lesObservateurs.indexOf(observateur);
		if (posObjetDansListe >= 0)
			lesObservateurs.remove(posObjetDansListe);*/		
	}

	@Override
	public void notifierObservateurs() {
		for (ObservateurDeCommande unObservateur : lesObservateurs) {
			unObservateur.mettreAJour();
		}
		
	}

}
