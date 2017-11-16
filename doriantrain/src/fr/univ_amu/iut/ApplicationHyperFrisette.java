package fr.univ_amu.iut;


//import java.util.ArrayList;

public class ApplicationHyperFrisette {
	public static void main(String[] args) {
		System.out.println("Plop !");
		FabriqueTrain factory = new TrainBetail();
		Train train = new Train(factory);
		train.creationTrain();
        System.out.println(train);

		FabriqueWagon factoryPassagers = new WagonPassager();
		FabriqueWagon factoryBetail = new WagonBetail();
		FabriqueWagon factoryDechet = new WagonDechets();
		FabriqueWagon factoryLiquide = new WagonLiquide();
		FabriqueWagon factoryMarchandise = new WagonMarchandise();

        Wagon wagonPassager = new Wagon(factoryPassagers,100);
		Wagon wagonBetail = new Wagon(factoryBetail, 200);
        Wagon wagonDechet = new Wagon(factoryDechet,300);
        Wagon wagonLiquide = new Wagon(factoryLiquide,400);
        Wagon wagonMarchandise = new Wagon(factoryMarchandise,500);


        System.out.println(wagonPassager);
        System.out.println(wagonBetail);
        System.out.println(wagonDechet);
        System.out.println(wagonLiquide);
        System.out.println(wagonMarchandise);

		FabriqueEntreprise entreprisePassagers = new EntrepriseFerroviairePassagers();
		FabriqueEntreprise entrepriseAnimaux = new EntrepriseFerroviaireAnimaux();
		FabriqueEntreprise entrepriseCargo = new EntrepriseFerroviaireCargo();

		EntrepriseFerroviaire entrepriseFerroviairePassager = new EntrepriseFerroviaire(entreprisePassagers,"meddyPassager","pinpom",100);
		EntrepriseFerroviaire entrepriseFerroviaireAnimaux = new EntrepriseFerroviaire(entrepriseAnimaux,"meddyAnimaux","pinpom",200);
		EntrepriseFerroviaire entrepriseFerroviaireCargo = new EntrepriseFerroviaire(entrepriseCargo,"meddyCargo","pinpom",300);

		System.out.println(entrepriseFerroviairePassager);
		System.out.println(entrepriseFerroviaireAnimaux);
		System.out.println(entrepriseFerroviaireCargo);

		Gare gareAix = new Gare ("Aix-en-Provence");
		Gare gareTataouineLesBains = new Gare ("Tataouine-les-Bains");
		System.out.println(gareAix + "\n" + gareTataouineLesBains);

	}
}

