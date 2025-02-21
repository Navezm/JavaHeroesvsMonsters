package be.digitalcity.formation.jeu.personnage.monstres;

import be.digitalcity.formation.jeu.utilitaire.De;
import be.digitalcity.formation.jeu.personnage.Personnage;
import be.digitalcity.formation.jeu.utilitaire.Loots;
import be.digitalcity.formation.jeu.utilitaire.Or;

import java.util.ArrayList;
import java.util.List;

public class Orque extends Personnage implements Loots {

    private List<Or> listOr = new ArrayList<>();

    @Override
    public int getForce() {
        return super.getForce() + 1;
    }

    public List<Or> getOr() {
        return this.listOr;
    }

    public Orque(int X, int Y) {
        this.X = X;
        this.Y = Y;
        int nombreOr = De.lancerDe(6);
        for (int i = 0; i < nombreOr; i++) {
            listOr.add(new Or());
        }
    }
}
