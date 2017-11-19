package fr.univ_amu.iut;

import java.util.ArrayList;
import java.util.Collection;

public class EntrepriseFerroviaireCargo extends EntrepriseFerroviaire {
    Collection<Wagon> listeWagon = new ArrayList<Wagon>();

    public EntrepriseFerroviaireCargo(FabriqueEntreprise categorie, String nom, String siren, int numero) {
        super(categorie, nom, siren, numero);
    }
}
