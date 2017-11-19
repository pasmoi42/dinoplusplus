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
	
	@Override
	public void obtiensActionSuivanteAFaire() {
				
		++iter;
		switch (iter) {
		case 1:
			plopRails = EntrepriseFerroviaire.creeEntreprise(ECategorieEntreprise.ENT_PASSAGERS, "PlopRails", "S1r3n", 1);
			break;
		case 2:
			Train.creeTrain("S1r3n", 5, 5, 5, 5, ETypeWagon.WAGON_PASSAGER, 3);
			break;
		case 3:
			trainHuitW = Train.creeTrain("S1r3n", 5, 5, 5, 5, ETypeWagon.WAGON_PASSAGER, 8);
			break;
		case 4:
			Train.creeTrain("S1r3n", 5, 5, 5, 10, ETypeWagon.WAGON_PASSAGER, 1);
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

}
