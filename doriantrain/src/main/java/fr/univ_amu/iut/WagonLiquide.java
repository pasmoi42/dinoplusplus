package fr.univ_amu.iut;

/**
 * Created by t16005197 on 09/11/17.
 */
public class WagonLiquide implements FabriqueWagon {
    private double coutUnitaire;


    @Override
    public void setCoutUnitaire(double coutUnitaire) {
        this.coutUnitaire=coutUnitaire;
    }
}
