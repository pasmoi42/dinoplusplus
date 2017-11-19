package fr.univ_amu.iut;

/**
 * 
 * Ce que doit faire toute "vue" (en gros tout affichage), 
 * pour fonctionner.
 * 
 * 
 * @author dorian
 *
 */
public interface VueGenerique 
{
	
	/**
	 * Va regarder ce qui a change dans le modele (DonneesFerrovieres)
	 * pour le prendre en comtpe pour "l'affichage".
	 */
	public void prendEnCompteNouvellesDonnes();
	
	
}
