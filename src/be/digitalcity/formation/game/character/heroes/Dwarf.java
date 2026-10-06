package be.digitalcity.formation.game.character.heroes;

public class Dwarf extends Hero {
    @Override
    public int getEndurance() {
        return super.getEndurance() + 2;
    }
}