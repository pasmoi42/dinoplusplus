package fr.univ_amu.iut;

import java.util.LinkedList;

/**
 * Toutes les donnes utilisees par ce logiciel de simulation. Constitue le
 * Modele du pattern MVC autour du quel est achitecture ce logiciel.
 * 
 * 
 * @author Dorian
 *
 */
public class DonneesFerrovieres {
	
	LinkedList<Gare> toutesLesGares;
	
	private DonneesFerrovieres() {
		toutesLesGares = new LinkedList<Gare>();
	}
	
	private static DonneesFerrovieres leSeulEtUniqueModele = null;

	/** seule et unique maniere d'acceder a notre singleton-controlleur */
	public static DonneesFerrovieres accedeAuxDonnees() {
		if (leSeulEtUniqueModele == null) {
			leSeulEtUniqueModele = new DonneesFerrovieres();
		}
		return leSeulEtUniqueModele;
	}

	/**
	 * Cree le monde ...
	 */
	public static void creeUnReseau()
	{
		Gare.creeGare("Paris");	
		Gare.creeGare("Marseille");
		Gare.creeGare("Lyon");
		Gare.creeGare("Bordeaux");	
		Gare.creeGare("Lille");	
		Gare.creeGare("Nice");
		
	}


		
	public Gare ajouteUneGareAuReseau(Gare laNouvelleGare) {
				
		for (Gare uneGare : toutesLesGares) 
		{
			if ( uneGare.estLaMemeGare(laNouvelleGare.getNom()) )
			{
				return uneGare;
			}
		}
		
		toutesLesGares.addLast(laNouvelleGare);
		return laNouvelleGare;
	}


}
