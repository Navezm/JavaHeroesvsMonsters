package be.digitalcity.formation.jeu.utilitaire;

import be.digitalcity.formation.jeu.personnage.Personnage;
import be.digitalcity.formation.jeu.personnage.monstres.Dragonnet;
import be.digitalcity.formation.jeu.personnage.monstres.Loup;
import be.digitalcity.formation.jeu.personnage.monstres.Orque;

import java.util.Random;

public class Plateau {

    public Personnage[][] plateau = new Personnage[15][15];

    Random rand = new Random();

    // 1 + (int)(Math.random() * ((13 - 10) + 1))

    public void creationPlateau() {
        for (int i = 0; i < 10; i++) {
            int X = rand.nextInt(14);
            int Y = rand.nextInt(14);
            if (plateau[X][Y] == null && espacementMonstre(X,Y,plateau)) {
                int monstreAleatoire = 1 + (int)(Math.random() * ((3 - 1) + 1));
                switch (monstreAleatoire) {
                    case 1:
                        Personnage monstreD = new Dragonnet(X,Y);
                        plateau[X][Y] = monstreD;
                        System.out.println("Dragonnet ajouté en position : "+X+" "+Y);
                        break;
                    case 2:
                        Personnage monstreL = new Loup(X,Y);
                        plateau[X][Y] = monstreL;
                        System.out.println("Loup ajouté en position : "+X+" "+Y);

                        break;
                    case 3:
                        Personnage monstreO = new Orque(X,Y);
                        plateau[X][Y] = monstreO;
                        System.out.println("Orque ajouté en position : "+X+" "+Y);
                        break;
                }
            } else {
                i --;
            }
        }
    }

    // Permet lors de la création du plateau de positionner les monstres de manière aléatoire
    public boolean espacementMonstre(int x, int y, Personnage[][] plateau){
        boolean monsterNearby = false;
        if((x - 2 >= 0 && y - 2 >= 0) && (x + 2 <= 14 && y + 2 <= 14)) {
            if ((plateau[x + 1][y] == null && plateau[x + 2][y] == null) &&
                    (plateau[x - 1][y] == null && plateau[x - 2][y] == null) &&
                    (plateau[x][y + 1] == null && plateau[x][y + 2] == null) &&
                    (plateau[x][y - 1] == null && plateau[x][y - 2] == null)){
                monsterNearby = false;
            } else {
                monsterNearby = true;
            }
        } else {

        }
//        (plateau[x + 1][y] == null && plateau[x + 2][y] == null) && (plateau[x - 1][y] == null && plateau[x - 2][y] == null) && (plateau[x][y + 1] == null && plateau[x][y + 2] == null) && (plateau[x][y - 1] == null && plateau[x][y - 2] == null);
        return monsterNearby;
    }

}
