package fr.univ_amu.iut;

/**
 * 
 * Une facture est emise lors qu'on a fini d'utiliser un sillon.
 * On ne peut pas l'emmetre avant, car les incidents peuvent modifier
 * le montant facturer au moment de l'utilisation du sillon.
 * 
 * @author Dorian
 *
 */
public class Facture {
	EntrepriseFerroviaire e;
	Sillon s;
	Train t;
	int montantAPayer;
	int idUniqueDeFacture;

	@Override
	public String toString()
	{
		String enTexte;
		
		enTexte ="Facture "+idUniqueDeFacture+":\n";
		enTexte +="Montant a payer: "+montantAPayer+"\n";
		enTexte +="Par l'entreprise: "+e.getNom()+"\n";
		enTexte +="Pour le passage du tain: "+t.getIdUnique()+"\n";
		//enTexte +="Dans le sillon: "+s.get???+"\n";
		
		
		return enTexte;	
	}
	
	static int compteurDeFacture = 0; //pour generer l'idUniqueDeFacture
}
