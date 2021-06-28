package be.digitalcity.formation.jeu.personnage.monstres;

import be.digitalcity.formation.jeu.utilitaire.De;
import be.digitalcity.formation.jeu.personnage.Personnage;
import be.digitalcity.formation.jeu.utilitaire.Or;

public class Orque extends Personnage implements Or {
    int or = De.lancerDe(6);

    public int getOr() {
        return or;
    }

    @Override
    public int getForce() {
        return super.getForce() + 1;
    }
}
