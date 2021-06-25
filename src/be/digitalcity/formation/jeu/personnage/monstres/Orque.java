package be.digitalcity.formation.jeu.personnage.monstres;

import be.digitalcity.formation.jeu.De;
import be.digitalcity.formation.jeu.personnage.Personnage;

public class Orque extends Personnage {
    int or = De.lancerDe(6);

    @Override
    public int getForce() {
        return super.getForce() + 1;
    }
}
