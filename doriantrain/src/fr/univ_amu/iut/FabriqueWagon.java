package fr.univ_amu.iut;

public class FabriqueWagon {
    private double coutWagonBetail;
    private double coutWagonDechets;
    private double coutWagonLiquide;
    private double coutWagonMarchandise;
    private double coutWagonPassager;

    private FabriqueWagon (){
        coutWagonBetail = 10;
        coutWagonDechets = 20;
        coutWagonLiquide = 30;
        coutWagonMarchandise = 40;
        coutWagonPassager = 50;
    }

    public Wagon getNouveauWagonBetail (){
        Wagon wagonBetail;

        wagonBetail = new WagonBetail();
        wagonBetail.setCoutUnitaire(coutWagonBetail);

        return wagonBetail;
    }

    public Wagon getNouveauWagonDechet (){
        Wagon wagonDechet;

        wagonDechet = new WagonDechets();
        wagonDechet.setCoutUnitaire(coutWagonDechets);

        return wagonDechet;
    }

    public Wagon getNouveauWagonLiquide (){
        Wagon wagonLiquide;

        wagonLiquide = new WagonLiquide();
        wagonLiquide.setCoutUnitaire(coutWagonLiquide);

        return wagonLiquide;
    }

    public Wagon getNouveauWagonMarchandise (){
        Wagon wagonMarchandise;

        wagonMarchandise = new WagonMarchandise();
        wagonMarchandise.setCoutUnitaire(coutWagonMarchandise);

        return wagonMarchandise;
    }

    public Wagon getNouveauWagonPassager (){
        Wagon wagonPassager;

        wagonPassager = new WagonPassager();
        wagonPassager.setCoutUnitaire(coutWagonPassager);

        return wagonPassager;
    }



    private static FabriqueWagon laSeuleEtUniqueFabriqueWagon = null;

    public static FabriqueWagon getSingleton() {
        if (laSeuleEtUniqueFabriqueWagon == null) {
            laSeuleEtUniqueFabriqueWagon = new FabriqueWagon();
        }
        return laSeuleEtUniqueFabriqueWagon;
    }
}
