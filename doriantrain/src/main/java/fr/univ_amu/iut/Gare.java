package fr.univ_amu.iut;

import java.io.Serializable;

/**
 * Created by p16003786 on 14/11/17.
 */
public class Gare {
    private String nom;
    public Gare (String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Gare{" +
                "nom='" + nom + '\'' +
                '}';
    }
}
