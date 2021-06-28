package be.digitalcity.formation.jeu.personnage.monstres;

import be.digitalcity.formation.jeu.utilitaire.Cuir;
import be.digitalcity.formation.jeu.utilitaire.De;
import be.digitalcity.formation.jeu.personnage.Personnage;
import be.digitalcity.formation.jeu.utilitaire.Or;

public class Dragonnet extends Monstre {
    Or or = De.lancerDe(6);
    int cuir = De.lancerDe(4);

    @Override
    public int getEndurance() {
        return super.getEndurance() + 1;
    }
}
