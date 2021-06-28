package be.digitalcity.formation.jeu.personnage.monstres;

import be.digitalcity.formation.jeu.utilitaire.Cuir;
import be.digitalcity.formation.jeu.utilitaire.De;
import be.digitalcity.formation.jeu.personnage.Personnage;

public class Loup extends Personnage implements Cuir{
    int cuir = De.lancerDe(4);

    @Override
    public int getCuir() {
        return this.cuir;
    }
}
