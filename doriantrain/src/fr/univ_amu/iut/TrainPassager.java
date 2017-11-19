package fr.univ_amu.iut;

public class TrainPassager extends Train {
    private int taille = 0,longueur = 0, largeur = 0;
    //private EntrepriseFerroviaire proprietaire;

    @Override
    public void setTaille(int taille) {
        this.taille=taille;
    }

    @Override
    public void setLongueur(int longueur) {
        this.longueur=longueur;
    }

    @Override
    public void setLargeur(int largeur) {
        this.largeur=largeur;
    }

    // @Override
    // public void setProprietaire(EntrepriseFerroviaire proprietaire) {
    // this.proprietaire=proprietaire;
    // }
    @Override
    public int getTaille() {
        return taille;
    }
    @Override
    public int getLongueur() {
        return longueur;
    }
    @Override
    public int getLargeur() {
        return largeur;
    }
}
