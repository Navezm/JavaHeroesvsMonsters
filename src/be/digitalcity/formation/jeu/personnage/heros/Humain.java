package be.digitalcity.formation.jeu.personnage.heros;

public class Humain extends Heros{
    @Override
    public int getForce() {
        return super.getForce() + 1;
    }

    @Override
    public int getEndurance() {
        return super.getEndurance() + 1;
    }
}
