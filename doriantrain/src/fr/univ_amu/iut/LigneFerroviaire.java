package fr.univ_amu.iut;

public class LigneFerroviaire  {

    private Gare gareDepart;
    private Gare gareArrivee;

    private LigneFerroviaire (Gare d, Gare a)
    {
        this.gareDepart = d;
        this.gareArrivee = a;
    }

    public LigneFerroviaire (String gareD, String gareA)
    {
    	this.gareDepart = Gare.creeGare(gareD);
    	this.gareArrivee = Gare.creeGare(gareA);
    }

    public Gare getGareArrivee() {
        return gareArrivee;
    }

    public Gare getGareDepart() {
        return gareDepart;
    }

    public void afficher() {
        System.out.print("La ligne va de " + this.getGareDepart() + " à " + this.getGareArrivee());
    }
    
    public static LigneFerroviaire creeUneLigne(String gareD, String gareA)
    {
    	LigneFerroviaire nouvelleLigne;
    	
    	nouvelleLigne = new LigneFerroviaire (gareD, gareA);
    	nouvelleLigne =  DonneesFerrovieres.accedeAuxDonnees().ajouteUneLigneAuReseau(nouvelleLigne);    	
    	return nouvelleLigne;
    }
    
}