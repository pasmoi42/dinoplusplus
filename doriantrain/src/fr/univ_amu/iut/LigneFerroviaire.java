package fr.univ_amu.iut;

public class LigneFerroviaire  {

	private static final int NB_SILLON = 24;
    private Gare gareDepart;
    private Gare gareArrivee;
    Sillon[] lesSillons; //les sillons de cette ligne
    
    private void creeSillons()
    {
    	int i;
    	
    	lesSillons = new Sillon[NB_SILLON];
        for (i=NB_SILLON-1 ; i > 0; --i)
        {
        	lesSillons[i] = new Sillon();
		}
    }
    
    private LigneFerroviaire (Gare d, Gare a)
    {  		
        this.gareDepart = d;
        this.gareArrivee = a;
        creeSillons();
    }

    private LigneFerroviaire (String gareD, String gareA)
    {    	
    	this.gareDepart = Gare.creeGare(gareD);
    	this.gareArrivee = Gare.creeGare(gareA);
    	creeSillons();
    }

    public Gare getGareArrivee() {
        return gareArrivee;
    }

    public Gare getGareDepart() {
        return gareDepart;
    }

    @Override
    public String toString() {
        return "La ligne va de " + this.getGareDepart() + " à " + this.getGareArrivee();
    }

    /**
     * Si la ligne n'existe pas encore, ca la cree et l'ajoute au reseau
     * Sinon, ca retourne la ligne existante 
     */
    public static LigneFerroviaire creeUneLigne(String gareD, String gareA)
    {
    	LigneFerroviaire nouvelleLigne;
    	
    	nouvelleLigne = new LigneFerroviaire (gareD, gareA);
    	nouvelleLigne =  DonneesFerrovieres.accedeAuxDonnees().ajouteUneLigneAuReseau(nouvelleLigne);    	
    	return nouvelleLigne;
    }
    
}