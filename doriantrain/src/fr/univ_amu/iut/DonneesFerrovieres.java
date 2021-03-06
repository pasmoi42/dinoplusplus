package fr.univ_amu.iut;

import java.util.LinkedList;

/**
 * Toutes les donnes utilisees par ce logiciel de simulation. Constitue le
 * Modele du pattern MVC autour du quel est achitecture ce logiciel.
 * 
 * 
 * @author Dorian
 *
 */
public class DonneesFerrovieres {
	double heureActuelle;
	LinkedList<Gare> toutesLesGares;
	LinkedList<LigneFerroviaire> toutesLesLignes;
	LinkedList<EntrepriseFerroviaire> toutesLesEntreprises;
	LinkedList<Train> tousLesTrains;
	
	private DonneesFerrovieres() {
		toutesLesGares = new LinkedList<Gare>();
		toutesLesLignes = new LinkedList<LigneFerroviaire>();		
		toutesLesEntreprises = new LinkedList<EntrepriseFerroviaire>();
		tousLesTrains = new LinkedList<Train>();
		heureActuelle = 0;
	}
	
	private static DonneesFerrovieres leSeulEtUniqueModele = null;

	/** seule et unique maniere d'acceder a notre singleton-controlleur */
	public static DonneesFerrovieres accedeAuxDonnees() {
		if (leSeulEtUniqueModele == null) {
			leSeulEtUniqueModele = new DonneesFerrovieres();
			creeUnReseau();
		}
		return leSeulEtUniqueModele;
	}

	/**
	 * Cree le monde ...
	 */
	public static void creeUnReseau()
	{
		Gare.creeGare("Paris");	
		Gare.creeGare("Marseille");
		Gare.creeGare("Lyon");
		Gare.creeGare("Bordeaux");	
		Gare.creeGare("Lille");	
		Gare.creeGare("Nice");
		Gare.creeGare("Aix-en-Provence");
		Gare.creeGare("Tataouine-les-Bains");

		LigneFerroviaire.creeUneLigne("Paris", "Lyon", 5);
		
	}


		
	public Gare ajouteUneGareAuReseau(Gare laNouvelleGare) {
				
		for (Gare uneGare : toutesLesGares) 
		{
			if ( uneGare.estLaMemeGare(laNouvelleGare.getNom()) )
			{
				return uneGare;
			}
		}
		
		toutesLesGares.addLast(laNouvelleGare);
		return laNouvelleGare;
	}
	
    /**
     * Si la ligne n'existe pas encore dans le reseau, ca l'y ajoute.
     * Sinon, ca retourne la ligne existante 
     */
	public LigneFerroviaire ajouteUneLigneAuReseau(LigneFerroviaire nouvelleLigne) {
		
		for (LigneFerroviaire uneLigne : toutesLesLignes) {
			if (uneLigne.getGareDepart().estLaMemeGare(nouvelleLigne.getGareDepart().getNom()) &&
					uneLigne.getGareArrivee().estLaMemeGare(nouvelleLigne.getGareArrivee().getNom())	)
			{
				return uneLigne;
			}			
		}				
		toutesLesLignes.addLast(nouvelleLigne);		
		return nouvelleLigne;
	}
	

    /**
     * Si l'entreprise n'existe pas encore dans le reseau, ca l'y ajoute.
     * Sinon, ca retourne l'entreprise existante 
     */
	public EntrepriseFerroviaire ajouteUneEntrepriseAuReseau(EntrepriseFerroviaire nouvelleEnt) {
		
		for (EntrepriseFerroviaire uneEnt : toutesLesEntreprises) {
			if (uneEnt.getSiren().equalsIgnoreCase(nouvelleEnt.getSiren()))
			{
				return uneEnt;
			}			
		}				
		toutesLesEntreprises.addLast(nouvelleEnt);		
		return nouvelleEnt;
	}
	
	/**
     * Si l'entreprise n'existe pas encore dans le reseau, ca l'y ajoute.
     * Sinon, ca retourne l'entreprise existante 
     */
	public EntrepriseFerroviaire getEntreprise(String siren) {
		
		for (EntrepriseFerroviaire uneEnt : toutesLesEntreprises) {
			if (uneEnt.getSiren().equalsIgnoreCase(siren))
			{
				return uneEnt;
			}			
		}						
		return null;
	}
	

	public static double getHeureActuelle()
	{
		return DonneesFerrovieres.accedeAuxDonnees().heureActuelle;
	}
  
	public Train ajouteUnTrainAuReseau(Train nouvTrain) {
		
		for (Train unTrain : tousLesTrains) {
			if (unTrain.getIdUnique() == nouvTrain.getIdUnique())
			{
				return unTrain;
			}			
		}				
		tousLesTrains.addLast(nouvTrain);		
		return nouvTrain;
	}


}
