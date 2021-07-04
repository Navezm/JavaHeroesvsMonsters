package be.digitalcity.formation.jeu.personnage.monstres;

import be.digitalcity.formation.jeu.utilitaire.Cuir;
import be.digitalcity.formation.jeu.utilitaire.De;
import be.digitalcity.formation.jeu.personnage.Personnage;

import java.util.Objects;

public class Loup extends Personnage implements Cuir{
    int cuir = De.lancerDe(4);

    @Override
    public int getCuir() {
        return this.cuir;
    }

    public Loup(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loup loup = (Loup) o;
        return cuir == loup.cuir;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cuir);
    }

    @Override
    public String toString() {
        return "Loup{" +
                "pv=" + pv +
                ", force=" + getForce() +
                ", endurance=" + getEndurance() +
                ", X=" + X +
                ", Y=" + Y +
                ", cuir=" + cuir +
                '}';
    }
}
