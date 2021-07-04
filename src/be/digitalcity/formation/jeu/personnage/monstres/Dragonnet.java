package be.digitalcity.formation.jeu.personnage.monstres;

import be.digitalcity.formation.jeu.utilitaire.Cuir;
import be.digitalcity.formation.jeu.utilitaire.De;
import be.digitalcity.formation.jeu.personnage.Personnage;
import be.digitalcity.formation.jeu.utilitaire.Or;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dragonnet dragonnet = (Dragonnet) o;
        return or == dragonnet.or && cuir == dragonnet.cuir;
    }

    @Override
    public int hashCode() {
        return Objects.hash(or, cuir);
    }

    @Override
    public String toString() {
        return "Dragonnet{" +
                "pv=" + pv +
                ", X=" + X +
                ", Y=" + Y +
                ", or=" + or +
                ", cuir=" + cuir +
                '}';
    }
}
