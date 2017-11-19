package fr.univ_amu.iut;

import java.util.Collection;
import java.util.LinkedList;

public abstract class Train {
    private int largeur,longueur,taille,vitesseMax;
    private EntrepriseFerroviaire proprietaire;
    private Collection<Wagon> wagons = new LinkedList<>();
    private int idUniqueDuTrain; //un num unique pour savoir quel train c'est ... // lecture seule
    
    private LinkedList<Sillon> lesReservations; //reference sur sillon reserves, pour que ca soit pratique de faire rouler le train    
    
    public EEtatTrain etatActuel;
    public Sillon positionActuelle; // 
    public double progressionDansLeSillon;
    String nomGare;    
    double coutObtenuDuTrain;
    
    
    public Train() {
    	idUniqueDuTrain = compteurNouveauTrain;
    	++compteurNouveauTrain;
    	lesReservations = new LinkedList<Sillon>();
    	positionActuelle = null;
    	progressionDansLeSillon = 0;
    	nomGare = "";
    	etatActuel = EEtatTrain.TRAIN_HORS_RESEAU;
    	coutObtenuDuTrain = 0;
	}
    
    public int getIdUnique() { //un getteur mais surtout pas de setter, car lecture seule!
    	return idUniqueDuTrain;
    }
    

    public void memoriseReservationDeSillon(Sillon s){
    	lesReservations.add(s);
    }
    
    public void deplacer(){
    }

    public void setLargeur(int largeur){
        this.largeur = largeur;
    }
    public void setLongueur(int longueur){
        this.longueur = longueur;
    }
    public void setTaille(int taille){
        this.taille = taille;
    }
    public void setVitesseMax(int vitesseMax){
        this.vitesseMax = vitesseMax;
    }
    public void setProprietaire(EntrepriseFerroviaire proprietaire){
        this.proprietaire = proprietaire;
    }
    public void ajouteWagons(Wagon wagon){
        this.wagons.add(wagon);
    }
    
    @Override
    public String toString(){
    	String trainEnTexte;
    	trainEnTexte = "Train "+idUniqueDuTrain+" de "+wagons.size()+" wagons de l'entreprise "+proprietaire.getNom()+" wagons:";
    	for (Wagon wagon : wagons) {
    		trainEnTexte += "(" +wagon.getTypeStr()+ ")-";
		}
    	trainEnTexte += "o";
    	return trainEnTexte;
    }
    
    public Sillon aUneReservationALHeure(double h)
    {
    	for (Sillon sillon : lesReservations) {
			if (sillon.heure <= h && h <= sillon.heure+1 )
				return sillon;
		}
    	return null;
    }
    
    public void placeTrainSillon(Sillon s, double avancement)
    {
    	etatActuel = EEtatTrain.TRAIN_AVANCE_SILLON;
    	positionActuelle = s;
    	progressionDansLeSillon = avancement;
    	nomGare = "";
    }
    
    public void placeTrainGare(String paramNomGare)    
    {
    	if (etatActuel == EEtatTrain.TRAIN_AVANCE_SILLON)
    	{
    		//donc a on fini ce sillon, donc on peut l'ajouter au cout du train
    		coutObtenuDuTrain += positionActuelle.getCoututilisation() * wagons.size();
    		/*
    		System.err.println("wagons.size(): "+ wagons.size());
    		System.err.println("positionActuelle.getCoututilisation(): "+ positionActuelle.getCoututilisation());
    		System.err.println("coutObtenuDuTrain: "+ coutObtenuDuTrain);*/

    	}
    	
    	nomGare = paramNomGare;
    	etatActuel = EEtatTrain.TRAIN_ARRET_GARE;
    	positionActuelle = null;
    	progressionDansLeSillon = 0;    	
    }
    
    public void sortTrainDuReseau()    
    {
    	if (etatActuel == EEtatTrain.TRAIN_AVANCE_SILLON)
    	{
    		//donc a on fini ce sillon, donc on peut l'ajouter au cout du train
    		coutObtenuDuTrain += positionActuelle.getCoututilisation() * wagons.size();
    	}
    	
    	nomGare = "";
    	etatActuel = EEtatTrain.TRAIN_HORS_RESEAU;
    	positionActuelle = null;
    	progressionDansLeSillon = 0;    	
    }
    
    public double getCout ()
    {
    	return coutObtenuDuTrain;
    }
    
    
    private static int compteurNouveauTrain = 0;

    /**
     * Cree un nouveau train dans le systeme.
     * @param siren
     * @param iLarg
     * @param iLong
     * @param iTaille
     * @param iVitMax
     * @param eTypeWagon
     * @param nbWagon
     * @return
     */
    public static Train creeTrain(String siren, int iLarg, int iLong, int iTaille, int iVitMax, ETypeWagon eTypeWagon, int nbWagon) {
    	Train nouvTrain;
    	
    	nouvTrain = null;
    	switch (eTypeWagon) {
    	case WAGON_BETAIL:
    		nouvTrain = new TrainBetail();
        	for (int i = nbWagon ; i > 0 ; --i)
        	{
        		Wagon wagon = FabriqueWagon.getSingleton().getNouveauWagonBetail();
        		nouvTrain.ajouteWagons(wagon);
        	}
    		break;
    	case WAGON_DECHET:
    		nouvTrain = new TrainDechet();
        	for (int i = nbWagon ; i > 0 ; --i)
        	{
        		Wagon wagon = FabriqueWagon.getSingleton().getNouveauWagonDechet();
        		nouvTrain.ajouteWagons(wagon);
        	}
    		break;
    	case WAGON_LIQUIDE:
    		nouvTrain = new TrainLiquide();
        	for (int i = nbWagon ; i > 0 ; --i)
        	{
        		Wagon wagon = FabriqueWagon.getSingleton().getNouveauWagonLiquide();
        		nouvTrain.ajouteWagons(wagon);
        	}
    		break;
    	case WAGON_MARCHANDISE:
    		nouvTrain = new TrainMarchandise();
        	for (int i = nbWagon ; i > 0 ; --i)
        	{
        		WagonMarchandise wagon = new WagonMarchandise();
        		nouvTrain.ajouteWagons(wagon);
        	}
    		break;
    	case WAGON_PASSAGER:
    		nouvTrain = new TrainPassager();
        	for (int i = nbWagon ; i > 0 ; --i)
        	{
        		Wagon wagon = FabriqueWagon.getSingleton().getNouveauWagonPassager();
        		nouvTrain.ajouteWagons(wagon);
        	}
    		break;
    	default:
    		//ERREUR_PAS_UN_WAGON
    		// erreur: type d'entreprise inconnu.
    		nouvTrain = null;
    		break;
    	}
    	nouvTrain.setLargeur(iLarg);
    	nouvTrain.setLongueur(iLong);
    	nouvTrain.setProprietaire(DonneesFerrovieres.accedeAuxDonnees().getEntreprise(siren));
    	nouvTrain.setTaille(iTaille);
    	nouvTrain.setVitesseMax(iVitMax);
    	    	
    	nouvTrain = DonneesFerrovieres.accedeAuxDonnees().ajouteUnTrainAuReseau(nouvTrain);
    	return nouvTrain;
	}

}

