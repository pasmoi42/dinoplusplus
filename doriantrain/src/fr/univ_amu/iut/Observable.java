package fr.univ_amu.iut;

/**
 * L'objet observable qui generera des commandes a exectuer.
 * Peut etre le clavier (en menu terminal), ou autre ... 
 */
public interface Observable {
	
	public void enregistrerObservateur(ObservateurDeCommande observateur);
	public void supprimerObservateur(ObservateurDeCommande observateur);
	public void notifierObservateurs();

}
