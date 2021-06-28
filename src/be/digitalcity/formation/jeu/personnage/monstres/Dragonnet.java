package be.digitalcity.formation.jeu.personnage.monstres;

import be.digitalcity.formation.jeu.utilitaire.Cuir;
import be.digitalcity.formation.jeu.utilitaire.De;
import be.digitalcity.formation.jeu.personnage.Personnage;
import be.digitalcity.formation.jeu.utilitaire.Or;

public class Dragonnet extends Personnage implements Or, Cuir {
    int or = De.lancerDe(6);
    int cuir = De.lancerDe(4);

    public int getOr() {
        return or;
    }

    public int getCuir() {
        return cuir;
    }

    @Override
    public int getEndurance() {
        return super.getEndurance() + 1;
    }
}
