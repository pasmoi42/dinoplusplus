package fr.univ_amu.iut;

public abstract class Wagon {
    private double coutUnitaire;

    public void setCoutUnitaire (double coutUnitaire){
        this.coutUnitaire = coutUnitaire;
    }
    
    public String getTypeStr()
    {
    	return "non instanciable";
    }
}
