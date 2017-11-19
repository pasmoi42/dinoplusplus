package fr.univ_amu.iut;



/**
 * 
 * Permet d'obtenir les actions a faire, de maniere 
 * automatique, depuis une liste d'action pre-etablie
 * 
 * @author Dorian
 *
 */
public class ReceptionCommandesAuto extends ObvservableSemiConcret implements ReceptionCommandes {

	int iter;

	EntrepriseFerroviaire plopRails;
	Train trainHuitW;

	public ReceptionCommandesAuto() {
		super();
		iter = 0;
		plopRails = null;
		trainHuitW = null;

	}
	
	public void scenario1() {		
		++iter;
		switch (iter) {
		case 1:
			plopRails = EntrepriseFerroviaire.creeEntreprise(ECategorieEntreprise.ENT_PASSAGERS, "PlopRails", "S1r3n", 1);
			break;
		case 2:
			Train.creeTrain("S1r3n", 5, 5, 5, 5, ETypeWagon.WAGON_PASSAGER, 3);
			break;
		case 3:
			trainHuitW = Train.creeTrain("S1r3n", 5, 5, 5, 5, ETypeWagon.WAGON_BETAIL, 8);
			break;
		case 4:
			Train.creeTrain("S1r3n", 5, 5, 5, 10, ETypeWagon.WAGON_DECHET, 1);
			break;
		case 5:
			LigneFerroviaire ligne;

			ligne = DonneesFerrovieres.accedeAuxDonnees().toutesLesLignes.getFirst();
			plopRails.demandeUneReservationDeSillon(trainHuitW, ligne, 12);
			break;

		default:
			break;
		}		
	}
	
	public void scenario2() {		
		++iter;
		switch (iter) {
		case 1:
			plopRails = EntrepriseFerroviaire.creeEntreprise(ECategorieEntreprise.ENT_PASSAGERS, "PlopRails", "S1r3n", 1);
			Train.creeTrain("S1r3n", 5, 5, 5, 5, ETypeWagon.WAGON_PASSAGER, 3);
			trainHuitW = Train.creeTrain("S1r3n", 5, 5, 5, 5, ETypeWagon.WAGON_BETAIL, 8);
			Train.creeTrain("S1r3n", 5, 5, 5, 10, ETypeWagon.WAGON_DECHET, 1);
			break;
		case 2:
		
			LigneFerroviaire ligne;

			ligne = DonneesFerrovieres.accedeAuxDonnees().toutesLesLignes.getFirst();
			plopRails.demandeUneReservationDeSillon(trainHuitW, ligne, 12);
			break;

		case 3:
			ControlleurMVC.getSingleton().initSimulation();
			break;
		case 4:
			ControlleurMVC.getSingleton().avanceSimulation(0.5);
			break;
		default:
			ControlleurMVC.getSingleton().avanceSimulation(0.5);

			break;
		}		
	}
		
	
	@Override
	public void obtiensActionSuivanteAFaire() {
		scenario2();
	}

}
