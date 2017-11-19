package fr.univ_amu.iut;


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


    	//proprietaire = DonneesFerrovieres.accedeAuxDonnees().listeDEntrepise.getFirst();


    }

    
    public Train getNouveauTrain() {

    	switch (leType) {
    	case WAGON_BETAIL:
    		return getNouveauTrainBetail();
    	case WAGON_PASSAGER:
            return getNouveauTrainPassager ();
    	case WAGON_DECHET:
            getNouveauTrainDechet ();
    	case WAGON_LIQUIDE:
            getNouveauTrainLiquide ();
    	case WAGON_MARCHANDISE:
            getNouveauTrainMarchandise ();
		default:
			return null;
			//ERREUR_PAS_UN_WAGON
		}
    }

    public Train getNouveauTrainBetail () {
    	Train trainBetail;

        trainBetail = new TrainBetail();
        trainBetail.setVitesseMax(vitesseMax);
        trainBetail.setLargeur(largeur);
        trainBetail.setLongueur(longueur);
        trainBetail.setProprietaire(proprietaire);
        trainBetail.setTaille(taille);
        trainBetail.setVitesseMax(vitesseMax);
        for (int i = 0; i < nbWagon;++i){
            trainBetail.ajouteWagons(FabriqueWagon.getSingleton().getNouveauWagonBetail());
        }

        return trainBetail;
    }
    public Train getNouveauTrainPassager () {
        Train trainPassager;

        trainPassager = new TrainPassager();
        trainPassager.setVitesseMax(vitesseMax);
        trainPassager.setLargeur(largeur);
        trainPassager.setLongueur(longueur);
        trainPassager.setProprietaire(proprietaire);
        trainPassager.setTaille(taille);
        trainPassager.setVitesseMax(vitesseMax);
        for (int i = 0; i < nbWagon;++i){
            trainPassager.ajouteWagons(FabriqueWagon.getSingleton().getNouveauWagonPassager());
        }

        return trainPassager;
    }

    public Train getNouveauTrainDechet () {
        Train trainDechet;

        trainDechet = new TrainDechet();
        trainDechet.setVitesseMax(vitesseMax);
        trainDechet.setLargeur(largeur);
        trainDechet.setLongueur(longueur);
        trainDechet.setProprietaire(proprietaire);
        trainDechet.setTaille(taille);
        trainDechet.setVitesseMax(vitesseMax);
        for (int i = 0; i < nbWagon;++i){
            trainDechet.ajouteWagons(FabriqueWagon.getSingleton().getNouveauWagonDechet());
        }

        return trainDechet;
    }

    public Train getNouveauTrainLiquide () {
        Train trainLiquide;

        trainLiquide = new TrainLiquide();
        trainLiquide.setVitesseMax(vitesseMax);
        trainLiquide.setLargeur(largeur);
        trainLiquide.setLongueur(longueur);
        trainLiquide.setProprietaire(proprietaire);
        trainLiquide.setTaille(taille);
        trainLiquide.setVitesseMax(vitesseMax);
        for (int i = 0; i < nbWagon;++i){
            trainLiquide.ajouteWagons(FabriqueWagon.getSingleton().getNouveauWagonLiquide());
        }

        return trainLiquide;
    }

    public Train getNouveauTrainMarchandise () {
        Train trainMarchandise;

        trainMarchandise = new TrainMarchandise();
        trainMarchandise.setVitesseMax(vitesseMax);
        trainMarchandise.setLargeur(largeur);
        trainMarchandise.setLongueur(longueur);
        trainMarchandise.setProprietaire(proprietaire);
        trainMarchandise.setTaille(taille);
        trainMarchandise.setVitesseMax(vitesseMax);
        for (int i = 0; i < nbWagon;++i){
            trainMarchandise.ajouteWagons(FabriqueWagon.getSingleton().getNouveauWagonMarchandise());
        }

        return trainMarchandise;
    }


    
    
    
    private static FabriqueTrain laSeuleEtUniqueFabriqueTrain = null;
    
    public static FabriqueTrain getSingleton() {
    	if (laSeuleEtUniqueFabriqueTrain == null) {
    		laSeuleEtUniqueFabriqueTrain = new FabriqueTrain();
    	}
    	return laSeuleEtUniqueFabriqueTrain;
    }

}

