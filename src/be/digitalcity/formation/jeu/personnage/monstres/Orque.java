package be.digitalcity.formation.jeu.personnage.monstres;

import be.digitalcity.formation.jeu.utilitaire.De;
import be.digitalcity.formation.jeu.personnage.Personnage;
import be.digitalcity.formation.jeu.utilitaire.Or;

import java.util.Objects;

public class Orque extends Personnage implements Or {
    int or = De.lancerDe(6);

    @Override
    public int getForce() {
        return super.getForce() + 1;
    }

    @Override
    public int getOr() {
        return this.or;
    }

    public Orque(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orque orque = (Orque) o;
        return or == orque.or;
    }

    @Override
    public int hashCode() {
        return Objects.hash(or);
    }

    @Override
    public String toString() {
        return "Orque{" +
                "pv=" + pv +
                ", force=" + getForce() +
                ", endurance=" + getEndurance() +
                ", X=" + X +
                ", Y=" + Y +
                ", or=" + or +
                '}';
    }
}
