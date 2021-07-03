package be.digitalcity.formation.jeu;

import be.digitalcity.formation.jeu.personnage.Personnage;
import be.digitalcity.formation.jeu.personnage.heros.Heros;

public class Jeu {
    public static void lancerJeu(){
//        Création du plateau de jeu
//        do {
//            La fonction du jeu
//        } while(monstre != 0 && Heros.getPv() != 0);


    }

    public static void combat(Heros heros, Personnage monstre){
        do {
            heros.frappe(monstre);
            if (monstre.getPv() <= 0) {
                System.out.printf("Bravo vous avez battu un %s ! Vous récupérez ses biens et continuer votre chemin\n\n",monstre.getClass().getSimpleName());

                heros.ramasserLoot(monstre); // Refaire le loot parce que fonctionne pas

                heros.rest();
            } else {
                monstre.frappe(heros);
            }
        } while(monstre.getPv() > 0 && heros.getPv() > 0);
        if (heros.getPv() <= 0){
            System.out.printf("Ton héro est mort tu peux recommencer une partie !\n\n");
        }
    }

    // Detecte si un monstre se trouve a proximité du héros
    public boolean detectionMonstre(Personnage personnage, Personnage[][] plateau){
        boolean ennemiesNearby = false;
        int positionX = personnage.getX();
        int positionY = personnage.getY();
        if (plateau[positionX-1][positionY] != null || plateau[positionX+1][positionY] != null) {
            ennemiesNearby = true;
        } else if (plateau[positionX][positionY+1] != null || plateau[positionX][positionY-1] != null) {
            ennemiesNearby = true;
        }
        return ennemiesNearby;
    }
}
