package fr.univ_amu.iut;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReceptionCommandesTerm extends ObvservableSemiConcret implements ReceptionCommandes {

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
		
		this.notifierObservateurs();
		choix = faitLaLecture();
		switch (choix) {
		case "1":
			
			break;
		case "2":
			
			break;
		case "3":
			
			break;
		case "4":
			
			break;

		default:
			
			break;
		}
	    

		
	}

	
		
}
