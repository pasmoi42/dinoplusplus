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
	
	public ReceptionCommandesAuto() {
		super();
		iter = 0;
	}
	
	@Override
	public void obtiensActionSuivanteAFaire() {
		++iter;
		
		switch (iter) {
		case 1:
			EntrepriseFerroviaire.creeEntreprise(ECategorieEntreprise.ENT_PASSAGERS, "PlopRails", "S1r3n", 1);
			break;
		case 2:
			Train.creeTrain("S1r3n", 5, 5, 5, 5, ETypeWagon.WAGON_PASSAGER, 3);
			break;
		case 3:
			Train.creeTrain("S1r3n", 5, 5, 5, 5, ETypeWagon.WAGON_PASSAGER, 8);
			break;
		case 4:
			Train.creeTrain("S1r3n", 5, 5, 5, 10, ETypeWagon.WAGON_PASSAGER, 1);
			break;

		default:
			break;
		}
		
	}

}
