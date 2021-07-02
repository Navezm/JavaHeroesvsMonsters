package be.digitalcity.formation.jeu.personnage.monstres;

import be.digitalcity.formation.jeu.utilitaire.Cuir;
import be.digitalcity.formation.jeu.utilitaire.De;
import be.digitalcity.formation.jeu.personnage.Personnage;
import be.digitalcity.formation.jeu.utilitaire.Or;

public class Dragonnet extends Personnage implements Or, Cuir {
    private int or = De.lancerDe(6);
    private int cuir = De.lancerDe(4);

    @Override
    public int getEndurance() {
        return super.getEndurance() + 1;
    }

    @Override
    public int getOr() {
        return this.or;
    }

    @Override
    public int getCuir() {
        return this.cuir;
    }

    public Dragonnet(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }
}
