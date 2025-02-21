package be.digitalcity.formation.jeu.personnage.monstres;

import be.digitalcity.formation.jeu.utilitaire.Cuir;
import be.digitalcity.formation.jeu.utilitaire.De;
import be.digitalcity.formation.jeu.personnage.Personnage;
import be.digitalcity.formation.jeu.utilitaire.Loots;

import java.util.ArrayList;
import java.util.List;

public class Loup extends Personnage implements Loots {

    List<Cuir> stockCuir = new ArrayList<>();

    public List<Cuir> getCuir() {
        return this.stockCuir;
    }

    public Loup(int X, int Y) {
        this.X = X;
        this.Y = Y;
        int nombreCuir = De.lancerDe(4);
        for (int i = 0; i < nombreCuir; i++) {
            stockCuir.add(new Cuir());
        }
    }
}
