package fr.univ_amu.iut;

public class VueDebugConsole implements VueGenerique {

	@Override
	public void initialiseAffichage() {
		System.out.println("######################");
		System.out.println("# Debut du programme #");
		System.out.println("######################");

	}

	@Override
	public void prendEnCompteNouvellesDonnes() {
		// TODO Auto-generated method stub

	}

	@Override
	public void metAJourAffichage() {
		// TODO Auto-generated method stub
		System.out.println("#####################");
		System.out.println("# Nouvel affichage: #");
		System.out.println("#####################");
		System.out.println("  Liste des gares: ");
		for (Gare uneGare : DonneesFerrovieres.accedeAuxDonnees().toutesLesGares) {
			System.out.print("    ");
			System.out.println(uneGare.toString());
		}
		System.out.println("  Liste des lignes: ");
		for (LigneFerroviaire uneLigne : DonneesFerrovieres.accedeAuxDonnees().toutesLesLignes) {
			System.out.print("    ");
			System.out.println(uneLigne.toString());
		}
		
		
		System.out.println("...");
		System.out.println("############################");
		System.out.println("# Fin du Nouvel affichage: #");
		System.out.println("############################");

	}

	@Override
	public void fermeAffichage() {
		// TODO Auto-generated method stub
		System.out.println("############");
		System.out.println("# bye bye! #");
		System.out.println("############");
	}

	/**
	 * Le mettreAJour du pattern observeur qui en fait, la, 
	 * nous demande juste de rafficher le menu pour que 
	 * l'utilisateur puisse faire un choix d'action au 
	 * clavier.
	 */
	@Override
	public void mettreAJour() {
		// TODO Auto-generated method stub
		System.out.println("#####################");
		System.out.println("# Ze super Menu:    #");
		System.out.println("#####################");
		System.out.println("1) Le choix 1");
		System.out.println("2) Le choix 2");
		System.out.println("3) Le choix 3");
		System.out.println("4) Le choix 4");
		System.out.println("D) La réponse D ...");
	}
}
