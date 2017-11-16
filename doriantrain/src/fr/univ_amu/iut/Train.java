package fr.univ_amu.iut;

//import java.util.Collection;

public class Train {
    FabriqueTrain categorie;
     public Train(FabriqueTrain categorie) {
         this.categorie=categorie;
    }
    public void creationTrain() {
         categorie.setLargeur(1);
         categorie.setLongueur(1);
         //categorie.setProprietaire(Apple);
         categorie.setTaille(5);
    }

    @Override
    public String toString() {
        return "Train{" +
                "categorie=" + categorie +
                "Taille=" + categorie.getTaille() +
                "Largeur=" + categorie.getLargeur() +
                "Longueur=" + categorie.getLongueur() +
                '}';
    }
}
