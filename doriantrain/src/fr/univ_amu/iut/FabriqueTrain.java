package fr.univ_amu.iut;

import java.util.Collection;
import java.util.LinkedList;

public class FabriqueTrain {
    
    private int largeur,longueur,taille,vitesseMax;
    private EntrepriseFerroviaire proprietaire;
    int nbWagon;
    ETypeWagon leType;

    private FabriqueTrain()	{
    	leType = ETypeWagon.WAGON_PASSAGER;
    	largeur = 10;
    	longueur = 1000;
    	taille = 10;
    	vitesseMax = 600;


    	proprietaire = DonneesFerrovieres.accedeAuxDonnees().listeDEntrepise.getFirst();


    }

    
    public Train getNouveauTrain() {

    	switch (leType) {
    	case WAGON_BETAIL:
    		return getNouveauTrainBetail();
    	case WAGON_PASSAGER:

    		break;
    	case WAGON_DECHET:

    		break;
    	case WAGON_LIQUIDE:

    		break;
    	case WAGON_MARCHANDISE:

    		break;
		default:
			return null;
			//ERREUR_PAS_UN_WAGON
		}
		return null;
    	
    }

    public Train getNouveauTrainBetail () {
    	Train trainBetail;

   
        trainBetail = new TrainBetail();
        trainBetail.setVitesseMax(vitesseMax);
        

        return trainBetail;
    }
    
    
    
    private static FabriqueTrain laSeuleEtUniqueFabriqueTrain = null;
    
    public static FabriqueTrain getSingleton() {
    	if (laSeuleEtUniqueFabriqueTrain == null) {
    		laSeuleEtUniqueFabriqueTrain = new FabriqueTrain();
    	}
    	return laSeuleEtUniqueFabriqueTrain;
    }

}

