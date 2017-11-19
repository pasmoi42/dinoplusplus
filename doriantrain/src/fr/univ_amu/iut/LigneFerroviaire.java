package fr.univ_amu.iut;

public class LigneFerroviaire  {

	private static final int NB_SILLON = 24;
    private Gare gareDepart;
    private Gare gareArrivee;
    Sillon[] lesSillons; //les sillons de cette ligne    
    
    private void creeSillons(int coutBase)
    {
    	int i;
    	
    	lesSillons = new Sillon[NB_SILLON];
        for (i=NB_SILLON-1 ; i >= 0; --i)
        {
        	if (i > 10 && i < 22)
        		lesSillons[i] = new Sillon(i, coutBase*2, this); //heures pleinnes: double tarif
        	else
        		lesSillons[i] = new Sillon(i, coutBase, this);  //heures creuses: simple tarif
		}
    }
    
    Sillon getSillon(int i)
    {
    	assert(i >= 0);
    	assert(i <= 23);
    	return lesSillons[i];
    }
    
    private LigneFerroviaire (Gare d, Gare a, int coutBase)
    {  		
        this.gareDepart = d;
        this.gareArrivee = a;
        creeSillons(coutBase);
    }

    private LigneFerroviaire (String gareD, String gareA, int coutBase)
    {    	
    	this.gareDepart = Gare.creeGare(gareD);
    	this.gareArrivee = Gare.creeGare(gareA);
    	creeSillons(coutBase);
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
    public static LigneFerroviaire creeUneLigne(String gareD, String gareA, int coutBase)
    {
    	LigneFerroviaire nouvelleLigne;
    	
    	nouvelleLigne = new LigneFerroviaire (gareD, gareA, coutBase);
    	nouvelleLigne =  DonneesFerrovieres.accedeAuxDonnees().ajouteUneLigneAuReseau(nouvelleLigne);    	
    	return nouvelleLigne;
    }
    
    
    
}