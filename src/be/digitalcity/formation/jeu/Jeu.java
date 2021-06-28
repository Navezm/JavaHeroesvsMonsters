package be.digitalcity.formation.jeu;

import be.digitalcity.formation.jeu.personnage.Personnage;
import be.digitalcity.formation.jeu.personnage.heros.Heros;
import be.digitalcity.formation.jeu.personnage.monstres.Monstre;

public class Jeu {
    public static void lancerJeu(){
//        do {
//            La fonction du jeu
//        } while(monstre != 0 && Heros.getPv() != 0);


    }

    public static void combat(Heros heros, Monstre monstre){
        do {
            heros.frappe(monstre);
            if (monstre.getPv() < 0) {
                System.out.printf("Bravo vous avez battu un %s ! Vous récupérez ses biens et continuer votre chemin\n\n",monstre.getClass().getSimpleName());

                heros.ramasserLoot(monstre);

                heros.rest();
            } else {
                monstre.frappe(heros);
            }
        } while(monstre.getPv() > 0 && heros.getPv() > 0);
        if (heros.getPv() <= 0){
            System.out.printf("Ton héro est mort tu peux recommencer une partie !\n\n");
        }
    }
}
