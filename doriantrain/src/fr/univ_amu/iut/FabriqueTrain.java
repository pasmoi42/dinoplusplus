package fr.univ_amu.iut;

public class FabriqueTrain extends Train {

    public static Train getNouveauTrainBetail () {
        Train trainBetail;

        return trainBetail = new TrainBetail();
    }


}
