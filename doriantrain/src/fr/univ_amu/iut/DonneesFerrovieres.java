package fr.univ_amu.iut;

import java.util.Collection;

/**
 * Toutes les donnes utilisees par ce logiciel de simulation. Constitue le
 * Modele du pattern MVC autour du quel est achitecture ce logiciel.
 * 
 * 
 * @author Dorian
 *
 */
public class DonneesFerrovieres {
	
	private DonneesFerrovieres() {
		
	}
	
	private static DonneesFerrovieres leSeulEtUniqueModele = null;

	/** seule et unique maniere d'acceder a notre singleton-controlleur */
	public static DonneesFerrovieres accedeAuxDonnees() {
		if (leSeulEtUniqueModele == null) {
			leSeulEtUniqueModele = new DonneesFerrovieres();
		}
		return leSeulEtUniqueModele;
	}
}
