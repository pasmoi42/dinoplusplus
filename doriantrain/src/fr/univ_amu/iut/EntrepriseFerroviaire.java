package fr.univ_amu.iut;

public abstract class EntrepriseFerroviaire {
    private ECategorieEntreprise categorie;
    private String nom;
    private String siren; //numero d'identification unique du "Systeme d'identification du repertoire des entreprises n"
    private int numero;

    protected EntrepriseFerroviaire(ECategorieEntreprise categorie, String nom, String siren, int numero){
        this.categorie=categorie;
        this.nom=nom;
        this.numero=numero;
        this.siren=siren;
    }
    
    public static EntrepriseFerroviaire creeEntreprise(ECategorieEntreprise categorie, String nom, String siren, int numero) {
    	EntrepriseFerroviaire laNouvEnt;
    	
    	laNouvEnt = null;
    	switch (categorie) {
    	case ENT_ANIMAUX:
    		laNouvEnt = new EntrepriseFerroviaireAnimaux(categorie, nom, siren, numero);
    		break;
    	case ENT_CARGO:
    		laNouvEnt = new EntrepriseFerroviaireCargo(categorie, nom, siren, numero);
    		break;
    	case ENT_PASSAGERS:
    		laNouvEnt = new EntrepriseFerroviairePassagers(categorie, nom, siren, numero);
    		break;
    	default:
    		// erreur: type d'entreprise inconnu.
    		laNouvEnt = null;
    		break;
    	}
    	    	
    	laNouvEnt = DonneesFerrovieres.accedeAuxDonnees().ajouteUneEntrepriseAuReseau(laNouvEnt);
    	return laNouvEnt;
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
    
    public String getSiren()
    {
    	return siren;
    }

    public String getNom()
    {
    	return nom;
    }
        
    public void demandeUneReservationDeSillon(Train t, LigneFerroviaire l, int heure)    
    {
    	ControlleurMVC.getSingleton().reserveSillon(t, l, heure);
    }

    
}
