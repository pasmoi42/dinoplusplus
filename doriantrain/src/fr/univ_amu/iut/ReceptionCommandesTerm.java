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
	
	private ECategorieEntreprise inputCategorieToEnum(String nomCat)
	{
		switch (nomCat) {
		case "animaux":
			return ECategorieEntreprise.ENT_ANIMAUX;
		case "cargo":
			return ECategorieEntreprise.ENT_CARGO;
		case "passagers":
			return ECategorieEntreprise.ENT_PASSAGERS;		
		default:
			//erreur: mauvaise entree.
			//TODO: faire une jolie exception
			System.err.println("erreur: pas une categorie valide");
			System.exit(-1);
			break;
		}	
		return null;
	}
	
	private int stringToInt(String num)
	{
		return Integer.parseInt(num);
	}
	
	private void litDonnesEntreprise()
	{
		String nomEntreprise;
		String categorie;
		ECategorieEntreprise eCat;
		String numero;
		int iNum;
		String siren;
		
		//lecture nomEntreprise
		nomEntreprise = faitLaLecture();
		//lecture categorie
		categorie = faitLaLecture();
		eCat = inputCategorieToEnum(categorie);
		//lecture numero
		numero = faitLaLecture();
		iNum = stringToInt(numero);		
		//lecture siren
		siren = faitLaLecture();
		
		ControlleurMVC.getSingleton().creeEntreprise(nomEntreprise, eCat, iNum, siren);
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
			this.notifierObservateurs(EFonctionaliteAAfficher.VUE_MENU_CREER_ENTREPRISE);
			litDonnesEntreprise();
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
