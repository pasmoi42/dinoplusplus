package fr.univ_amu.iut;

public class Gare {
    private String nom;
          
    private Gare (String nom) {
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
    
    public String getNom() {
		return nom;
	}
    
    public static Gare creeGare(String nomGare) {
    	Gare laGare;
    	
    	laGare = new Gare(nomGare);
    	DonneesFerrovieres.accedeAuxDonnees().ajouteUneGareAuReseau(laGare);
    	return laGare;
	}
        
}
