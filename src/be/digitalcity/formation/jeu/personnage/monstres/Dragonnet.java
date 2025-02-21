package be.digitalcity.formation.jeu.personnage.monstres;

import be.digitalcity.formation.jeu.utilitaire.Cuir;
import be.digitalcity.formation.jeu.utilitaire.De;
import be.digitalcity.formation.jeu.personnage.Personnage;
import be.digitalcity.formation.jeu.utilitaire.Loots;
import be.digitalcity.formation.jeu.utilitaire.Or;

import java.util.ArrayList;
import java.util.List;

public class Dragonnet extends Personnage implements Loots {

    private List<Or> listOr = new ArrayList<>();
    private List<Cuir> listCuir = new ArrayList<>();

    @Override
    public int getEndurance() {
        return super.getEndurance() + 1;
    }

    public List<Or> getOr() {
        return this.listOr;
    }

    public List<Cuir> getCuir() {
        return this.listCuir;
    }

    public Dragonnet(int X, int Y) {
        this.X = X;
        this.Y = Y;
        int nombreOr = De.lancerDe(6);
        int nombreCuir = De.lancerDe(4);
        for (int i = 0; i < nombreOr; i++) {
            listOr.add(new Or());
        }
        for (int i = 0; i < nombreCuir; i++) {
            listCuir.add(new Cuir());
        }
    }
}
