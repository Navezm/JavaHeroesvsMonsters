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
    public void lancerJeu() {
        this.heros = creationPersonnage();
        plateau.creationPlateau();
        do {
            deplacement();
            collisionMonstre();
        } while(plateau.plateau.length != 0 && heros.getPv() > 0);
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
        System.out.println("Dans quel sens souhaitez vous vous déplacer ?");
        System.out.println("Haut : H, Bas : B, Gauche : G, Droite : D\n");
        String direction = scanner.next();
        switch (direction) {
            case "D" :
                if (heros.getX() == 14) {
                    System.out.println("Vous ne pouvez plus aller à droite");
                } else {
                    heros.setX(heros.getX() + 1);
                }
                break;
            case "G" :
                if (heros.getX() == 0) {
                    System.out.println("Vous ne pouvez plus aller à gauche");
                } else {
                    heros.setX(heros.getX() - 1);
                }
                break;
            case "H" :
                if (heros.getY() == 0) {
                    System.out.println("Vous ne pouvez plus aller en haut");
                } else {
                    heros.setY(heros.getY() - 1);
                }
                break;
            case "B" :
                if (heros.getY() == 14) {
                    System.out.println("Vous ne pouvez plus aller en bas");
                } else {
                    heros.setY(heros.getY() + 1);
                }
                break;
            default :
                System.out.println("Veuillez entrer une direction correcte");
        }
        System.out.printf("Vous êtes maintenant en X : %d Y : %d\n\n", heros.getX(), heros.getY());
    }

    private void collisionMonstre() {
        int X = heros.getX();
        int Y = heros.getY();
        if (X > 0) {
            if (plateau.plateau[X-1][Y] != null) {
                System.out.println("Un monstre apparait ! Vous devez vous battre");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                combat(this.heros, plateau.plateau[X-1][Y]);
            }
        }
        if (X < 14) {
            if (plateau.plateau[X+1][Y] != null) {
                System.out.println("Un monstre apparait ! Vous devez vous battre");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                combat(this.heros, plateau.plateau[X+1][Y]);
            }
        }
        if (Y > 0) {
            if (plateau.plateau[X][Y-1] != null) {
                System.out.println("Un monstre apparait ! Vous devez vous battre");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                combat(this.heros, plateau.plateau[X][Y-1]);
            }
        }
        if (Y < 14) {
            if (plateau.plateau[X][Y+1] != null) {
                System.out.println("Un monstre apparait ! Vous devez vous battre");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                combat(this.heros, plateau.plateau[X][Y+1]);
            }
        }
    }

    public static void combat(Heros heros, Personnage monstre) {
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
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (monstre.getPv() <= 0) {
            plateau.enleverMonstre(monstre.getX(), monstre.getY());
        }
        if (heros.getPv() <= 0){
            System.out.print("Votre héro est mort vous pouvez recommencer une partie !\n\n");
        }
    }
}
