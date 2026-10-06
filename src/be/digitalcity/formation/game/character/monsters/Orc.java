package be.digitalcity.formation.game.character.monsters;

import be.digitalcity.formation.game.character.Creature;
import be.digitalcity.formation.game.util.Die;
import be.digitalcity.formation.game.util.Gold;
import be.digitalcity.formation.game.util.Loot;

import java.util.ArrayList;
import java.util.List;

public class Orc extends Creature {

    private final List<Loot> golds = new ArrayList<>();

    public Orc(int x, int y) {
        setX(x);
        setY(y);
        int numberOfGold = Die.roll(6);
        for (int i = 0; i < numberOfGold; i++) {
            golds.add(new Gold());
        }
    }

    @Override
    public int getStrength() {
        return super.getStrength() + 1;
    }

    @Override
    public List<Loot> getLoots() {
        return golds;
    }
}