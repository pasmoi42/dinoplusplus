package fr.univ_amu.iut;

public class Gare {
    private String nom;
    public Gare (String nom) {
        this.nom = nom;
    }

    /**
     * @return true si et seulement si la string nomAutreGare nomme
     * la meme gare que this. 
     * @param nomAutreGare string du nom d'une autre gare.
     */
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
