package fr.univ_amu.iut;

import java.util.Collection;
import java.util.LinkedList;

public abstract class Train {
    private int largeur,longueur,taille,vitesseMax;
    private EntrepriseFerroviaire proprietaire;
    private Collection<Wagon> wagons = new LinkedList<>();

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
    public void setWagons(Wagon wagon){
        this.wagons.add(wagon);
    }
    public abstract void getCout ();
}

