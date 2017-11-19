package fr.univ_amu.iut;


/**
 * Cette entite represente en quelque sorte le regulateur du systeme 
 * qui veille au bon fonctionnement de celui-ci. Notamment, le controleur 
 * a la responsabilite d'affecter des sillons a des trains.
 * 
 * Choix technique: 
 *  * Il semble logique qu'il ne puisse exister qu'un seul controleur. (sinon conflits).
 *  * Et puis aussi, de nombreux modules differents vont souvent avoir besoin de demander
 *  * des choses au controlleur, il sera pratique d'y acceder depuis ... partout en fait.
 * Pour cette raison, le controlleur semble repondre parfaitement au cas d'utilisation
 * du pattern "singleton".
 *
 */
public class ControleurDeTrains {
	
	private ControleurDeTrains()	{
		
	}
 
	private static ControleurDeTrains leSeulEtUniqueControlleur = null;
	 
	/** seule et unique maniere d'acceder a notre singleton-controlleur */
	public static ControleurDeTrains getControlleur() {
		if (leSeulEtUniqueControlleur == null) {
			leSeulEtUniqueControlleur = new ControleurDeTrains();
		}
		return leSeulEtUniqueControlleur;
	}
	
	/** recoit la demande d'une entreprise de mettre un train sur un sillon (et repond accepte ou reffuse).*/
	public boolean reserveSillon(Train t, LigneFerroviaire l, int heureSillon)
	{
		Sillon s;

		s = l.getSillon(heureSillon);
		if (s.estLibre())
		{
			s.setTrain(t);
			return true;
		}
		else
			return false;
	}

}