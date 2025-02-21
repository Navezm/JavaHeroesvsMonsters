package be.digitalcity.formation.jeu;

import be.digitalcity.formation.jeu.personnage.Personnage;
import be.digitalcity.formation.jeu.personnage.heros.Heros;
import be.digitalcity.formation.jeu.personnage.heros.Humain;
import be.digitalcity.formation.jeu.personnage.heros.Nain;
import be.digitalcity.formation.jeu.utilitaire.Plateau;

import java.util.Scanner;

public class Jeu {
    Scanner scanner = new Scanner(System.in);
    static Plateau plateau = new Plateau();
    Heros heros;
    public void lancerJeu(){
        this.heros = creationPersonnage();
        plateau.creationPlateau();
        do {
//            La fonction du jeu
        } while(plateau.plateau.length != 0 && heros.getPv() != 0);

    }

    private Heros creationPersonnage() {
        Heros heros;
        System.out.println("Vous pouvez maintenant choisir votre personnage, vous avez le choix entre deux races : nains et humains\n");
        System.out.println("Pour choisir la création d'un humain tapez 1, pour la création d'un nain tapez 2\n");
        int choix = scanner.nextInt();
        if (choix == 1) {
            heros = new Nain();
            System.out.println("Vous avez choisi de créer un Nain");
            System.out.printf("Vos statistiques sont: %d points de vies\n", heros.getPv());
            System.out.printf("Vos statistiques sont: %d points d'endurances\n", heros.getEndurance());
            System.out.printf("Vos statistiques sont: %d points de force\n", heros.getForce());
        } else {
            heros = new Humain();
            System.out.println("Vous avez choisi de créer un Humain");
            System.out.printf("Vos statistiques sont: %d points de vies\n", heros.getPv());
            System.out.printf("Vos statistiques sont: %d points d'endurances\n", heros.getEndurance());
            System.out.printf("Vos statistiques sont: %d points de force\n", heros.getForce());
        }
        return heros;
    }

    private void deplacement() {

    }

    public static void combat(Heros heros, Personnage monstre){
        do {
            heros.frappe(monstre);
            if (monstre.getPv() <= 0) {
                System.out.printf("Bravo vous avez battu un %s ! Vous récupérez ses biens et continuer votre chemin\n\n",monstre.getClass().getSimpleName());

                heros.ramasserLoot(monstre);
                heros.getContenuSacADos();

                heros.rest();
            } else {
                monstre.frappe(heros);
            }
        } while(monstre.getPv() > 0 && heros.getPv() > 0);
        if (monstre.getPv() <= 0) {
            plateau.enleverMonstre(monstre.getX(), monstre.getY());
        }
        if (heros.getPv() <= 0){
            System.out.print("Ton héro est mort tu peux recommencer une partie !\n\n");
        }
    }
}
