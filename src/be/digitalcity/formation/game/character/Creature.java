package be.digitalcity.formation.game.character;

import be.digitalcity.formation.game.util.Die;
import be.digitalcity.formation.game.util.Loot;

import java.util.Arrays;
import java.util.List;

public abstract class Creature {
    private final int strength;
    private final int endurance;
    private int hp;
    private int x;
    private int y;

    protected Creature() {
        this.strength = rollStat();
        this.endurance = rollStat();
        this.hp = this.getEndurance() + modifier(this.getEndurance());
    }

    // Roll 4 dice and keep the 3 best results
    private static int rollStat() {
        int[] dice = new int[4];
        for (int i = 0; i < dice.length; i++) {
            dice[i] = Die.roll(6);
        }
        Arrays.sort(dice);
        return dice[1] + dice[2] + dice[3];
    }

    public int getStrength() {
        return strength;
    }

    public int getEndurance() {
        return endurance;
    }

    public int getHp() {
        return hp;
    }

    public void takeDamage(int damage) {
        this.hp = Math.max(0, this.hp - damage);
    }

    public void restoreHp(int hp) {
        this.hp = hp;
    }

    // Monsters override this method to drop their loot
    public List<Loot> getLoots() {
        return List.of();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char getSymbol() {
        return getClass().getSimpleName().charAt(0);
    }

    public void attack(Creature target) {
        int damage = Math.max(1, Die.roll(4) + modifier(this.getStrength()));
        target.takeDamage(damage);
        System.out.printf("%s takes %d damage, it has %d HP left%n",
                target.getClass().getSimpleName(), damage, target.getHp());
    }

    // Stat-based modifier (D&D-like rule)
    public static int modifier(int stat) {
        if (stat < 5) {
            return -1;
        } else if (stat > 15) {
            return 2;
        } else if (stat >= 10) {
            return 1;
        }
        return 0;
    }
}