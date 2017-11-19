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

	public static void creeUnReseau()
	{
		//DonneesFerrovieres.accedeAuxDonnees();
		DonneesFerrovieres.accedeAuxDonnees().creeUneGare("Paris");
		DonneesFerrovieres.accedeAuxDonnees().creeUneGare("Marseille");
		DonneesFerrovieres.accedeAuxDonnees().creeUneGare("Lyon");
		DonneesFerrovieres.accedeAuxDonnees().creeUneGare("Bordeaux");	
		DonneesFerrovieres.accedeAuxDonnees().creeUneGare("Lille");	
		DonneesFerrovieres.accedeAuxDonnees().creeUneGare("Nice");
		
	}


	public Gare creeUneGare(String nomGare) {
		Gare g;
		
		g = new Gare(nomGare);
		for (Gare uneGare : toutesLesGares) 
		{
			if (uneGare.toString().equalsIgnoreCase(g.toString()))
			{
				return uneGare;
			}
		}
		
		
		toutesLesGares.addLast(g);
		return g;
	}

}
