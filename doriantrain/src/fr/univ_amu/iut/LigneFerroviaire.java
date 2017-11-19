package fr.univ_amu.iut;

public class LigneFerroviaire  {

    private Gare gareDepart;
    private Gare gareArrivee;

    public LigneFerroviaire (Gare d, Gare a)
    {
        this.gareDepart = d;
        this.gareArrivee = a;
    }

    public LigneFerroviaire (String gareD, String gareA)
    {
        this.gareDepart = new Gare(gareD);
        this.gareArrivee = new Gare(gareA);
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
}