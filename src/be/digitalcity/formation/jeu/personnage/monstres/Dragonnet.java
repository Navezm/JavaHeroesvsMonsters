package be.digitalcity.formation.jeu.personnage.monstres;

import be.digitalcity.formation.jeu.De;
import be.digitalcity.formation.jeu.personnage.Personnage;

public class Dragonnet extends Personnage {
    int or = De.lancerDe(6);
    int cuir = De.lancerDe(4);

    @Override
    public int getEndurance() {
        return super.getEndurance() + 1;
    }
}
