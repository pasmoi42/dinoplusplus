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
	

	private ETypeWagon inputTypeWagonToEnum(String nomCat)
	{
		switch (nomCat) {
		case "betail":
			return ETypeWagon.WAGON_BETAIL;
		case "dechet":
			return ETypeWagon.WAGON_DECHET;
		case "liquide":
			return ETypeWagon.WAGON_LIQUIDE;		
		case "marchandise":
			return ETypeWagon.WAGON_MARCHANDISE;		
		case "passagers":
			return ETypeWagon.WAGON_PASSAGER;		
		default:
			//erreur: mauvaise entree.
			//TODO: faire une jolie exception
			System.err.println("erreur: pas un type de wagon valide");
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
	
	private int litSaisieInt()
	{
		String longueur;
		int iLong;

		longueur = faitLaLecture();
		iLong = stringToInt(longueur);		
		return iLong;
	}
	
	private void litDonnesTrain()
	{
		String siren;
		int iLarg;
		int iLong;
		int iTaille;
		int iVitMax;

		String nomEntreprise;
		String typeWagon;
		ETypeWagon eTypeWagon;
		
		//lecture siren
		siren = faitLaLecture();

		
		//lecture nomEntreprise
		nomEntreprise = faitLaLecture();
		//lecture largeur
		iLarg = litSaisieInt();
		//lecture longueur
		iLong = litSaisieInt();
		//lecture taille
		iTaille = litSaisieInt();
		//lecture taille
		iTaille = litSaisieInt();
		//lecture vitesseMax
		iVitMax = litSaisieInt();

		//lecture type de wagon
		typeWagon = faitLaLecture();
		eTypeWagon = inputTypeWagonToEnum(typeWagon);
		
		
		ControlleurMVC.getSingleton().creeTrain(nomEntreprise, eCat, iNum, siren);
		
		
		/*
		 		
		 System.out.println("  Saisir le siren de l'entreprise proprietaire du train, puis tapper entrer,");
			System.out.println("  puis saisir la largeur du train puis tapper entrer,");
			System.out.println("  puis saisir la longueur du train puis tapper entrer,");
			System.out.println("  puis saisir la taille du train puis tapper entrer,");
			System.out.println("  puis saisir la vitesseMax du train puis tapper entrer,");
			System.out.println("  puis saisir le type de wagon du train (Wagon ...), puis tapper entrer,");
			System.out.println("  puis saisir le nombre de wagons du train, puis tapper entrer.");
 
		 */
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
		case "3": //Creer un train"
			this.notifierObservateurs(EFonctionaliteAAfficher.VUE_MENU_CREER_TRAIN);
			litDonnesTrain();			
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
