package be.digitalcity.formation.game.character.monsters;

import be.digitalcity.formation.game.character.Creature;
import be.digitalcity.formation.game.util.Die;
import be.digitalcity.formation.game.util.Gold;
import be.digitalcity.formation.game.util.Leather;
import be.digitalcity.formation.game.util.Loot;

import java.util.ArrayList;
import java.util.List;

public class Dragonling extends Creature {

    private final List<Loot> loots = new ArrayList<>();

    public Dragonling(int x, int y) {
        setX(x);
        setY(y);
        int numberOfGold = Die.roll(6);
        int numberOfLeather = Die.roll(4);
        for (int i = 0; i < numberOfGold; i++) {
            loots.add(new Gold());
        }
        for (int i = 0; i < numberOfLeather; i++) {
            loots.add(new Leather());
        }
    }

    @Override
    public int getEndurance() {
        return super.getEndurance() + 1;
    }

    @Override
    public List<Loot> getLoots() {
        return loots;
    }
}