package be.digitalcity.formation.jeu.utilitaire;

import be.digitalcity.formation.jeu.personnage.Personnage;
import be.digitalcity.formation.jeu.personnage.monstres.*;

import java.util.Random;

public class Plateau {

    public Personnage[][] plateau = new Personnage[15][15];

    Random rand = new Random();

    public void creationPlateau() {
        for (int i = 0; i < 12; i++) {
            int X = rand.nextInt(13) + 2;
            int Y = rand.nextInt(13) + 2;
            if (plateau[X][Y] == null
//                    plateau[X+1][Y] == null &&
//                    plateau[X+2][Y] == null &&
//                    plateau[X-1][Y] == null &&
//                    plateau[X-2][Y] == null &&
//                    plateau[X][Y+1] == null &&
//                    plateau[X][Y+2] == null &&
//                    plateau[X][Y-1] == null &&
//                    plateau[X][Y-2] == null
            ) {
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
                i = i - 1;
            }
        }
        System.out.println("Le plateau est créé");
    }

    public void enleverMonstre(int X, int Y) {
        plateau[X][Y] = null;
    }
}
