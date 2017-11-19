package fr.univ_amu.iut;

import java.util.Collection;
import java.util.LinkedList;

public class FabriqueTrain {
    
    private int largeur,longueur,taille,vitesseMax;
    private EntrepriseFerroviaire proprietaire;
    private Collection<Wagon> wagons = new LinkedList<>();

    public static Train getNouveauTrainBetail () {
        Train trainBetail;

        trainBetail = new TrainBetail();

        return trainBetail;
    }


}
