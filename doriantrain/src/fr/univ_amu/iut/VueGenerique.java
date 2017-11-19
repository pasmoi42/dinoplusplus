package fr.univ_amu.iut;

/**
 * 
 * Ce que doit faire toute "vue" (en gros tout affichage), 
 * pour fonctionner.
 * 
 * Toutes les vues du logiciels doivent obligatoirement 
 * implementer la presente interface: VueGenerique.
 * 
 * @author dorian
 *
 */
public interface VueGenerique 
{
	
	/**
	 * Initialise l'affichage
	 */
	public void initialiseAffichage();
	
	/**
	 * Va regarder ce qui a change dans le modele (DonneesFerrovieres)
	 * pour le prendre en comtpe pour "l'affichage".
	 */
	public void prendEnCompteNouvellesDonnes();

	/**
	 * Initialise l'affichage
	 */
	public void metAJourAffichage();
	

	/**
	 * Initialise l'affichage
	 */
	public void fermeAffichage();

	
}
