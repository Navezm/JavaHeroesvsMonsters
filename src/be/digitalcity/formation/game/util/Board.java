package be.digitalcity.formation.game.util;

import be.digitalcity.formation.game.character.Creature;
import be.digitalcity.formation.game.character.heroes.Hero;
import be.digitalcity.formation.game.character.monsters.Dragonling;
import be.digitalcity.formation.game.character.monsters.Orc;
import be.digitalcity.formation.game.character.monsters.Wolf;

import java.util.Random;

public class Board {

    public static final int SIZE = 15;
    private static final int MONSTER_COUNT = 12;
    // Minimum distance (in cells) between two characters, the hero included
    private static final int MIN_SPACING = 3;
    private static final int MAX_ATTEMPTS = 5000;

    private final Creature[][] cells = new Creature[SIZE][SIZE];
    private final Random random = new Random();
    private int monsterCount;

    public void create(Hero hero) {
        placeCharacter(hero, 0, 0);

        int monstersPlaced = 0;
        int attempts = 0;
        while (monstersPlaced < MONSTER_COUNT && attempts < MAX_ATTEMPTS) {
            attempts++;
            int x = random.nextInt(SIZE);
            int y = random.nextInt(SIZE);
            if (!isValidPosition(x, y)) {
                continue;
            }
            placeCharacter(createRandomMonster(x, y), x, y);
            monstersPlaced++;
        }
        monsterCount = monstersPlaced;

        System.out.println("The board has been created");
        System.out.println("Number of monsters: " + monsterCount);
    }

    private Creature createRandomMonster(int x, int y) {
        return switch (random.nextInt(3)) {
            case 0 -> new Dragonling(x, y);
            case 1 -> new Wolf(x, y);
            default -> new Orc(x, y);
        };
    }

    private boolean isValidPosition(int x, int y) {
        if (cells[x][y] != null) {
            return false;
        }
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (cells[i][j] == null) {
                    continue;
                }
                int distance = Math.max(Math.abs(i - x), Math.abs(j - y));
                if (distance < MIN_SPACING) {
                    return false;
                }
            }
        }
        return true;
    }

    public Creature getCell(int x, int y) {
        return cells[x][y];
    }

    public void placeCharacter(Creature creature, int x, int y) {
        creature.setX(x);
        creature.setY(y);
        cells[x][y] = creature;
    }

    public void moveCharacter(Creature creature, int newX, int newY) {
        removeCharacter(creature.getX(), creature.getY());
        placeCharacter(creature, newX, newY);
    }

    public void removeCharacter(int x, int y) {
        cells[x][y] = null;
    }

    public void display() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                Creature creature = cells[i][j];
                char symbol = creature != null ? creature.getSymbol() : '-';
                System.out.printf("| %c ", symbol);
            }
            System.out.println("|");
        }
    }

    public int getMonsterCount() {
        return monsterCount;
    }

    public void removeMonster() {
        this.monsterCount--;
    }
}