package fr.univ_amu.iut;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * Permet d'obtenir les actions a faire, depuis un choix de 
 * l'utilisateur, dans un menu dans le terminal.
 * 
 * @author Dorian
 *
 */

public class ReceptionCommandesTerm extends ObvservableSemiConcret implements ReceptionCommandes {

	public ReceptionCommandesTerm() {
		super();
	}
	
	private String faitLaLecture() {
		String ret;
		
		ret = new String("erreur");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try
		{
			ret = br.readLine();

		}catch (IOException e) {
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public void obtiensActionSuivanteAFaire() {
		String choix;
		
		this.notifierObservateurs(EFonctionaliteAAfficher.VUE_MENU_PRINCIPAL);
		choix = faitLaLecture();
		switch (choix) {
		case "1":
			System.out.println("Vous avez choisis 1");
			break;
		case "2": //Creer une entreprise
			this.notifierObservateurs(EFonctionaliteAAfficher.VUE_MENU_PRINCIPAL);
			break;
		case "3":
			
			break;
		case "4":
			
			break;

		case "D":
			System.out.println("Vous etes fan de gad elmaleh");
			break;

		default:
			
			break;
		}
	    

		
	}

	
		
}
