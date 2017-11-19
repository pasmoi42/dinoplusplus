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
	
	public void creeTrain(String siren, int iLarg, int iLong, int iTaille, int iVitMax, ETypeWagon eTypeWagon, int nbWagon)
	{
		Train.creeTrain(siren, iLarg, iLong, iTaille, iVitMax, eTypeWagon, nbWagon);
	}

	/**  recoit la demande d'une entreprise de mettre un train sur un sillon (et repond accepte ou reffuse). */
	public boolean reserveSillon(Train t, LigneFerroviaire l, int heureSillon)
	{
		return ControleurDeTrains.getControlleur().reserveSillon(t, l, heureSillon);
	}

	
	//TODO: lance la simulation:
	//TODO: faire avancer la simulation de n temps.
	
	//TODO: quand un train sort d'un sillon, rajouter une facture d'utilisation de ce sillon a la liste des factures.
	
}
