package be.digitalcity.formation.jeu.personnage.heros;

public class Humain extends Heros{

    public Humain() {
        super();
        this.X = 0;
        this.Y = 0;
    }

    @Override
    public int getForce() {
        return super.getForce() + 1;
    }

    @Override
    public int getEndurance() {
        return super.getEndurance() + 1;
    }

    @Override
    public String toString() {
        return "Humain{" +
                "pv=" + pv +
                ", force=" + getForce() +
                ", endurance=" + getEndurance() +
                ", X=" + X +
                ", Y=" + Y +
                '}';
    }
}
