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

	@Override
	public void mettreAJour() {
		// TODO Auto-generated method stub
		
	}

}
