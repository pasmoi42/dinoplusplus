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
	
	public void initSimulation()
	{
		Sillon reservation;
		
		for (Train t : DonneesFerrovieres.accedeAuxDonnees().tousLesTrains) {
			reservation = t.aUneReservationALHeure(DonneesFerrovieres.getHeureActuelle());
			if (reservation != null)
			{
				t.placeTrainSillon(reservation, 0);
			}
		}
	}
	
	
	//TODO: faire avancer la simulation de n temps.
	/**
	 * 
	 * @param temps pourcentage d'une heure. Par exemple la valeur "0.5" correspond a 30 minutes.
	 */
	public void avanceSimulation(double temps)
	{
		Sillon reservation;
		double avancement;
		
		DonneesFerrovieres.accedeAuxDonnees().heureActuelle += temps;
		for (Train t : DonneesFerrovieres.accedeAuxDonnees().tousLesTrains) {
			reservation = t.aUneReservationALHeure(DonneesFerrovieres.getHeureActuelle());
			if (reservation != null)
			{
				avancement = t.progressionDansLeSillon;
				avancement += temps;
				if (avancement >= 1) //alors il a passe plus d'une heure dans le sillon
				{
					t.placeTrainGare(reservation.ligneDeCeSillon.getGareArrivee().getNom());					
				}
				else
				{
					t.placeTrainSillon(reservation, avancement);
				}
				
			}
		}
	}
	
	//TODO: quand un train sort d'un sillon, rajouter une facture d'utilisation de ce sillon a la liste des factures.
	
}
