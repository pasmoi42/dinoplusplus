package fr.univ_amu.iut;


/**
 * Cette classe est "abstraite" et est la base de tout wagon.
 * Ce n'est pas un vrai wagon fini complet.
 * C'est juste ce que tout wagon doit forcement avoir, et donc,
 * la partie commune a tous les differents types de wagons.
 * 
 * @author Dorianosaure
 *
 */
public class WagonBase implements FabriqueWagon  {
	
	private double coutUnitaire;

	@Override
	public void setCoutUnitaire(double coutUnitaire) {
		this.coutUnitaire=coutUnitaire;
	}

	@Override
	public double getCoutUnitaire() {
		return coutUnitaire;
	}


}
