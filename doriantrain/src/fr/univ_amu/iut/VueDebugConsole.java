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
			System.out.println(uneLigne);
		}
		System.out.println("  Liste des Entreprises: ");
		for (EntrepriseFerroviaire uneEnt : DonneesFerrovieres.accedeAuxDonnees().toutesLesEntreprises) {
			System.out.print("    ");
			System.out.println(uneEnt);
		}
		
		
		System.out.println("...");
		System.out.println("############################");
		System.out.println("# Fin du Nouvel affichage: #");
		System.out.println("############################");

	}

	@Override
	public void fermeAffichage() {
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
	public void mettreAJour(EFonctionaliteAAfficher f) {
		
		switch (f) {
		case VUE_MENU_PRINCIPAL:
			System.out.println("#####################");
			System.out.println("# Ze super Menu:    #");
			System.out.println("#####################");
			System.out.println("1) Le choix 1");
			System.out.println("2) Creer une entreprise");
			System.out.println("3) Le choix 3");
			System.out.println("4) Le choix 4");
			System.out.println("D) La réponse D ...");
			break;
		case VUE_MENU_CREER_ENTREPRISE:
			System.out.println("###################################");
			System.out.println("# Sous menu: creer entreprise:    #");
			System.out.println("###################################");
			System.out.println("  Entrer le nom d'entreprise, puis tapper entrer,");
			System.out.println("  puis entrer la categorie de l'entreprise (passagers ou animaux ou cargo), puis tapper entrer,");
			System.out.println("  puis entrer le numero de l'entreprise, puis tapper entrer,");
			System.out.println("  puis entrer le siren de l'entreprise, puis tapper entrer");
			break;
		default:
			//ERR_RIEN
			// Donc on n'affiche rien ...
			break;
		}		
		
	}
}
