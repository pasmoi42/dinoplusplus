package fr.univ_amu.iut;

public class EntrepriseFerroviaire {
    private FabriqueEntreprise categorie;
    private String nom,siren;
    private int numero;

    public EntrepriseFerroviaire(FabriqueEntreprise categorie, String nom, String siren, int numero){
        this.categorie=categorie;
        this.nom=nom;
        this.numero=numero;
        this.siren=siren;
    }

    @Override
    public String toString() {
            return "EntrepriseFerroviaire{" +
                    "categorie=" + categorie +
                    ", nom='" + nom + '\'' +
                    ", siren='" + siren + '\'' +
                    ", numero=" + numero +
                    '}';
    }
}
