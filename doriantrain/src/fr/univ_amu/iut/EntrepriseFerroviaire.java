package fr.univ_amu.iut;

public class EntrepriseFerroviaire {
    private ECategorieEntreprise categorie;
    private String nom,siren;
    private int numero;

    public EntrepriseFerroviaire(ECategorieEntreprise categorie, String nom, String siren, int numero){
        this.categorie=categorie;
        this.nom=nom;
        this.numero=numero;
        this.siren=siren;
    }

    @Override
    public String toString() {
            return "EntrepriseFerroviaire{" +
                    "categorie=" + CategorieToString(categorie) +
                    ", nom='" + nom + '\'' +
                    ", siren='" + siren + '\'' +
                    ", numero=" + numero +
                    '}';
    }
    
    private String CategorieToString(ECategorieEntreprise c)
    {
    	switch (c) {
		case ENT_ANIMAUX:
			return "Entreprise de transport d'animaux";
		case ENT_CARGO:
			return "Entreprise de transport cargo";
		case ENT_PASSAGERS:
			return "Entreprise de transport de passagers";
		}
    	return "erreur";
    }
}
