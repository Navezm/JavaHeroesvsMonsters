package be.digitalcity.formation.jeu.utilitaire;

import be.digitalcity.formation.jeu.personnage.Personnage;
import be.digitalcity.formation.jeu.personnage.monstres.*;

import java.util.Random;

public class Plateau {

    public Personnage[][] plateau = new Personnage[15][15];

    Random rand = new Random();

    public void creationPlateau() {
        for (int i = 0; i < 1 + (int)(Math.random() * ((13 - 10) + 1)); i++) {
            int X = rand.nextInt(15);
            int Y = rand.nextInt(15);
            if (plateau[X][Y] == null) {
                int monstreAleatoire = rand.nextInt(4);
                switch (monstreAleatoire) {
                    case 1:
                        Personnage monstreD = new Dragonnet(X,Y);
                        plateau[X][Y] = monstreD;
                        break;
                    case 2:
                        Personnage monstreL = new Loup(X,Y);
                        plateau[X][Y] = monstreL;
                        break;
                    case 3:
                        Personnage monstreO = new Orque(X,Y);
                        plateau[X][Y] = monstreO;
                        break;
                }
            } else {
                i --;
            }
        }
    }

    public void enleverMonstre(int X, int Y) {
        plateau[X][Y] = null;
    }
}
