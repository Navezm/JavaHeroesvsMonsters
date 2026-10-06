package be.digitalcity.formation.game.character.heroes;

public class Human extends Hero {
    @Override
    public int getStrength() {
        return super.getStrength() + 1;
    }

    @Override
    public int getEndurance() {
        return super.getEndurance() + 1;
    }
}