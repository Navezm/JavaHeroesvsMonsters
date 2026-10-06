package be.digitalcity.formation.game;

import be.digitalcity.formation.game.character.Creature;
import be.digitalcity.formation.game.character.heroes.Dwarf;
import be.digitalcity.formation.game.character.heroes.Hero;
import be.digitalcity.formation.game.character.heroes.Human;
import be.digitalcity.formation.game.util.Board;

import java.util.Scanner;

public class Game {

    private static final int ANIMATION_DELAY = 3000;

    private final Scanner scanner = new Scanner(System.in);
    private final Board board = new Board();
    private Hero hero;

    public void start() {
        hero = createCharacter();
        board.create(hero);
        do {
            board.display();
            move();
            checkMonsterEncounter();
        } while (board.getMonsterCount() > 0 && hero.getHp() > 0);

        if (hero.getHp() <= 0) {
            System.out.println("Your adventure stops here, you can start a new game!");
        } else {
            System.out.println("Congratulations, you have killed every monster in the dungeon!");
            System.out.println("You finish your adventure brilliantly!");
        }
        hero.displayBackpack();
    }

    private Hero createCharacter() {
        System.out.println("You can now choose your character. You have two races to choose from: dwarves and humans");
        System.out.println("To create a human type 1, to create a dwarf type 2");

        int choice = readChoice(1, 2, "Please enter 1 (human) or 2 (dwarf)");
        Hero chosenHero = choice == 1 ? new Human() : new Dwarf();

        System.out.printf("You chose to create a %s%n", chosenHero.getClass().getSimpleName());
        System.out.printf("Your stats are: %d hit points%n", chosenHero.getHp());
        System.out.printf("Your stats are: %d endurance points%n", chosenHero.getEndurance());
        System.out.printf("Your stats are: %d strength points%n", chosenHero.getStrength());
        return chosenHero;
    }

    private int readChoice(int min, int max, String errorMessage) {
        while (true) {
            String input = scanner.next();
            try {
                int choice = Integer.parseInt(input);
                if (choice >= min && choice <= max) {
                    return choice;
                }
            } catch (NumberFormatException ignored) {
            }
            System.out.println(errorMessage);
        }
    }

    private void move() {
        System.out.println("Which way do you want to move?");
        System.out.println("Up: U, Down: D, Left: L, Right: R");

        String direction = scanner.next().toUpperCase();
        int deltaX = switch (direction) {
            case "U" -> -1;
            case "D" -> 1;
            default -> 0;
        };
        int deltaY = switch (direction) {
            case "L" -> -1;
            case "R" -> 1;
            default -> 0;
        };
        if (deltaX == 0 && deltaY == 0) {
            System.out.println("Please enter a valid direction (U, D, L or R)");
            return;
        }

        int newX = hero.getX() + deltaX;
        int newY = hero.getY() + deltaY;
        if (newX < 0 || newX >= Board.SIZE || newY < 0 || newY >= Board.SIZE) {
            System.out.println("You cannot go any further in that direction");
            return;
        }

        Creature occupant = board.getCell(newX, newY);
        if (occupant != null) {
            fight(occupant);
            if (hero.getHp() <= 0) {
                return;
            }
        }

        board.moveCharacter(hero, newX, newY);
        System.out.printf("You are now at X: %d Y: %d%n%n", hero.getX(), hero.getY());
    }

    private void checkMonsterEncounter() {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] direction : directions) {
            if (hero.getHp() <= 0) {
                return;
            }
            int x = hero.getX() + direction[0];
            int y = hero.getY() + direction[1];
            if (x < 0 || x >= Board.SIZE || y < 0 || y >= Board.SIZE) {
                continue;
            }
            Creature neighbor = board.getCell(x, y);
            if (neighbor != null) {
                System.out.println("A monster appears! You have to fight");
                pause(ANIMATION_DELAY);
                fight(neighbor);
            }
        }
    }

    private void fight(Creature monster) {
        while (hero.getHp() > 0 && monster.getHp() > 0) {
            hero.attack(monster);
            if (monster.getHp() > 0) {
                monster.attack(hero);
            }
        }
        pause(ANIMATION_DELAY);

        if (monster.getHp() <= 0) {
            System.out.printf("Well done, you killed a %s! You take its belongings and continue on your way%n%n",
                    monster.getClass().getSimpleName());
            hero.pickUpLoot(monster);
            hero.displayBackpack();
            hero.rest();
            board.removeCharacter(monster.getX(), monster.getY());
            board.removeMonster();
        } else {
            System.out.println("Your hero is dead, you can start a new game!");
        }
    }

    private void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}