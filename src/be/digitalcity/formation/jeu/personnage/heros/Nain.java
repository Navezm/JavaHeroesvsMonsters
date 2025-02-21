package be.digitalcity.formation.jeu.personnage.heros;

public class Nain extends Heros{
    @Override
    public int getEndurance() {
        return super.getEndurance() + 2;
    }
}
