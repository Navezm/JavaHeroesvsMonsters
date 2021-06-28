package be.digitalcity.formation.jeu.personnage.monstres;

import be.digitalcity.formation.jeu.personnage.Personnage;
import be.digitalcity.formation.jeu.utilitaire.Cuir;
import be.digitalcity.formation.jeu.utilitaire.Or;

public class Monstre extends Personnage implements Or, Cuir {
    Or or;
    Cuir cuir;

    public Or getOr() {
        return or;
    }

    public Cuir getCuir() {
        return cuir;
    }
}
