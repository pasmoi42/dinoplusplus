package fr.univ_amu.iut;

/**
 * Sert a obtenir une vue prete a l'emplois.
 */
public class FabriqueDeVue {

	public VueGenerique getFabriqueDebugConsole() {
		VueGenerique laVue;
				
		laVue = new VueDebugConsole();
		return laVue;
	}
}
