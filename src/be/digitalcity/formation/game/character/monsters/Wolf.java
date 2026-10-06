package be.digitalcity.formation.game.character.monsters;

import be.digitalcity.formation.game.character.Creature;
import be.digitalcity.formation.game.util.Die;
import be.digitalcity.formation.game.util.Leather;
import be.digitalcity.formation.game.util.Loot;

import java.util.ArrayList;
import java.util.List;

public class Wolf extends Creature {

    private final List<Loot> leathers = new ArrayList<>();

    public Wolf(int x, int y) {
        setX(x);
        setY(y);
        int numberOfLeather = Die.roll(4);
        for (int i = 0; i < numberOfLeather; i++) {
            leathers.add(new Leather());
        }
    }

    @Override
    public List<Loot> getLoots() {
        return leathers;
    }
}