package be.digitalcity.formation.jeu.personnage.heros;

public class Nain extends Heros{
    @Override
    public int getEndurance() {
        return super.getEndurance() + 2;
    }

    public Nain() {
        super();
        this.X = 0;
        this.Y = 0;
    }

    @Override
    public String toString() {
        return "Nain{" +
                "pv=" + pv +
                ", force=" + getForce() +
                ", endurance=" + getEndurance() +
                ", X=" + X +
                ", Y=" + Y +
                '}';
    }
}
