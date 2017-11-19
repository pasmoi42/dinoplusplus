package fr.univ_amu.iut;

import java.util.ArrayList;
import java.util.Collection;

public class EntrepriseFerroviairePassagers extends EntrepriseFerroviaire {
    Collection<WagonPassager> listeWagon = new ArrayList<WagonPassager>();

    public EntrepriseFerroviairePassagers(ECategorieEntreprise categorie, String nom, String siren, int numero) {
        super(categorie, nom, siren, numero);
    }
}
