package fr.univ_amu.iut;

public class WagonBetail implements FabriqueWagon {

    private double coutUnitaire;

    @Override
    public void setCoutUnitaire(double coutUnitaire) {
        this.coutUnitaire=coutUnitaire;
    }
}