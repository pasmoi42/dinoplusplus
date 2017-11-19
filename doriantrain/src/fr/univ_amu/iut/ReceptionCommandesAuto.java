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
			
			break;
		case 2:
			
			break;
		case 3:
			
			break;

		default:
			break;
		}
		
	}

}
