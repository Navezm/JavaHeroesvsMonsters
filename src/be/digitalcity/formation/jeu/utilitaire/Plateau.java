package be.digitalcity.formation.jeu.utilitaire;

import be.digitalcity.formation.jeu.personnage.Personnage;
import be.digitalcity.formation.jeu.personnage.heros.Heros;
import be.digitalcity.formation.jeu.personnage.monstres.*;

import java.util.Random;

public class Plateau {

    int nombreMonstre = 0;

    public Personnage[][] plateau = new Personnage[15][15];

    Random rand = new Random();

    public void creationPlateau(Heros heros) {
        plateau[0][0] = heros;
        for (int i = 0; i < 12; i++) {
            int X = rand.nextInt(13) + 2;
            int Y = rand.nextInt(13) + 2;
            if (plateau[X][Y] == null) {
                int monstreAleatoire = rand.nextInt(4);
                switch (monstreAleatoire) {
                    case 1:
                        Personnage monstreD = new Dragonnet(X,Y);
                        plateau[X][Y] = monstreD;
                        nombreMonstre++;
                        break;
                    case 2:
                        Personnage monstreL = new Loup(X,Y);
                        plateau[X][Y] = monstreL;
                        nombreMonstre++;
                        break;
                    case 3:
                        Personnage monstreO = new Orque(X,Y);
                        plateau[X][Y] = monstreO;
                        nombreMonstre++;
                        break;
                }
            } else {
                i--;
            }
        }
        System.out.println("Le plateau est créé");
        System.out.println("Nombre de monstres : " + nombreMonstre);
    }

    public void enleverPersonnage(int X, int Y) {
        plateau[X][Y] = null;
    }

    public void afficherPlateau() {
        for (int i = 0; i < 15; i ++) {
            for (int j = 0; j < 15; j ++) {
                System.out.printf("| %s ", plateau[i][j] != null ? plateau[i][j].getClass().getSimpleName().charAt(0) : "-");
                if (j == 14) {
                    System.out.print("|\n");
                }
            }
        }
    }

    public int getNombreMonstre() {
        return nombreMonstre;
    }

    public void retirerUnMonstre() {
        this.nombreMonstre--;
    }
}
