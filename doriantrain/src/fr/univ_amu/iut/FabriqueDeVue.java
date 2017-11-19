package fr.univ_amu.iut;

/**
 * Sert a obtenir une vue prete a l'emplois.
 */
public class FabriqueDeVue {

	/**
	 * donne un objet VueDebugConsole pret a l'emplois.
	 */
	public VueGenerique getFabriqueDebugConsole() {
		VueGenerique laVue;
				
		laVue = new VueDebugConsole();
		return laVue;
	}
}
