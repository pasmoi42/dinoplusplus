package fr.univ_amu.iut;

public class Wagon {
    private FabriqueWagon categorie;
    private double coutWagon;

    public Wagon(FabriqueWagon categorie, double coutWagon){
        this.categorie=categorie;
        this.coutWagon=coutWagon;
    }

    public void creerWagon(){
        categorie.setCoutUnitaire(coutWagon);
    }

    @Override
    public String toString() {
        return "Wagon{" +
                "categorie=" + categorie +
                ", coutWagon=" + coutWagon +
                '}';
    }
}
