package be.digitalcity.formation.game.character.heroes;

import be.digitalcity.formation.game.character.Creature;
import be.digitalcity.formation.game.util.Gold;
import be.digitalcity.formation.game.util.Leather;
import be.digitalcity.formation.game.util.Loot;

import java.util.ArrayList;
import java.util.List;

public abstract class Hero extends Creature {

    private final List<Loot> backpack = new ArrayList<>();

    protected Hero() {
        setX(0);
        setY(0);
    }

    @Override
    public char getSymbol() {
        return '@';
    }

    public void displayBackpack() {
        System.out.printf("Your backpack contains %d Leather and %d Gold%n",
                count(Leather.class), count(Gold.class));
    }

    public void rest() {
        restoreHp(this.getEndurance() + modifier(this.getEndurance()));
        System.out.printf("Your hero rested and now has %d HP!%n", getHp());
    }

    public void pickUpLoot(Creature monster) {
        List<Loot> loots = monster.getLoots();
        backpack.addAll(loots);
        long leathers = loots.stream().filter(l -> l instanceof Leather).count();
        long golds = loots.stream().filter(l -> l instanceof Gold).count();
        if (golds > 0) {
            System.out.printf("Well done, you picked up %d gold!%n", golds);
        }
        if (leathers > 0) {
            System.out.printf("Well done, you picked up %d leather!%n", leathers);
        }
    }

    private long count(Class<? extends Loot> type) {
        return backpack.stream().filter(type::isInstance).count();
    }
}