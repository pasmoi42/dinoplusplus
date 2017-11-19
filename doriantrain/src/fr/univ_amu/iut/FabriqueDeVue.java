package fr.univ_amu.iut;

/**
 * Sert a obtenir une vue prete a l'emplois.
 */
public class FabriqueDeVue {

	/**
	 * donne un objet VueDebugConsole pret a l'emplois.
	 */
	public static VueGenerique getFabriqueDebugConsole() {
		VueGenerique laVue;
				
		laVue = new VueDebugConsole();
		laVue.initialiseAffichage();
		
		//TODO: enregistrer la vue
		return laVue;
	}
	
	public static VueGenerique getFabriqueEnssembleReseau() {
		VueGenerique laVue;
				
		laVue = new VueEnsembleReseau();
		laVue.initialiseAffichage();
		
		//TODO: enregistrer la vue
		return laVue;
	}
}
