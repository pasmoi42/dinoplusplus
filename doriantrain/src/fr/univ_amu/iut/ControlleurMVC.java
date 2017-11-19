package fr.univ_amu.iut;

/**
 * Partie du logiciel qui fait tous les traitements.
 * Contient tous les calculs interne au logiciels.
 * 
 * @author Dorian
 *
 */
public class ControlleurMVC {
	

	private ControlleurMVC() {
		
	}

    private static ControlleurMVC leSeulEtUniqueControlleurMVC = null;

    public static ControlleurMVC getSingleton() {
        if (leSeulEtUniqueControlleurMVC == null) {
        	leSeulEtUniqueControlleurMVC = new ControlleurMVC();
        }
        return leSeulEtUniqueControlleurMVC;
    }
	
	

	public void creeEntreprise(String nom, ECategorieEntreprise cat, int  numero, String siren)
	{
		EntrepriseFerroviaire.creeEntreprise(cat, nom, siren, numero);
	}
	
	public void creeTrain(String nom, ECategorieEntreprise cat, int  numero, String siren)
	{
		EntrepriseFerroviaire.creeEntreprise(cat, nom, siren, numero);
	}

	
}
