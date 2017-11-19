package fr.univ_amu.iut;

public class Gare {
    private String nom;
    public Gare (String nom) {
        this.nom = nom;
    }

    public boolean estLaMemeGare(String nomAutreGare) {
    	return nom.equalsIgnoreCase(nomAutreGare);
	}
    
    @Override
    public String toString() {
        return "Gare{" +
                "nom='" + nom + '\'' +
                '}';
    }
}
