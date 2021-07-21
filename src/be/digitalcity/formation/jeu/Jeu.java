package be.digitalcity.formation.jeu;

import be.digitalcity.formation.jeu.personnage.Personnage;
import be.digitalcity.formation.jeu.personnage.heros.Heros;
import be.digitalcity.formation.jeu.personnage.heros.Humain;
import be.digitalcity.formation.jeu.personnage.heros.Nain;
import be.digitalcity.formation.jeu.utilitaire.Plateau;

import java.util.Scanner;

public class Jeu {
    private boolean termine;
    private Heros joueur;
    private Plateau plateau;

    Jeu (){
        this.termine = false;
        this.joueur = creationPerso();
        this.plateau = creationPlateau();
    }

    public void lancerJeu(){

        do {
            if (this.joueur.seDeplacer()) {
                Jeu.detectionMonstre(this.joueur, plateau.plateau);
            }
        } while (plateau.getMonstre() != null || this.joueur.getPv() != 0);
//        do {
//            La fonction du jeu
//        } while(monstre != 0 && Heros.getPv() != 0);


    }

    public Heros creationPerso(){
        Scanner scan = new Scanner(System.in);
        boolean creationOk = true;
        String creationPerso;
        do {
            System.out.println("Quel personnage veux-tu créer ? (Nain / Humain)");
            creationPerso = scan.nextLine();
            if (creationPerso.equals("Nain") || creationPerso.equals("Humain")) {
                creationOk = false;
            } else {
                System.out.println("Cette race n'existe pas");
            }
        } while (creationOk);

        return creationPerso.equals("Nain") ? new Nain() : new Humain();
    }

    public Plateau creationPlateau(){
        Plateau plateau = new Plateau();
        plateau.monstre.add(0,this.joueur);
        plateau.plateau[0][0] = this.joueur;
        plateau.creationPlateau();
        plateau.getMonstre().forEach(System.out::println);
        return plateau;
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
            // TO DO ajouter la possibilité de la fuite et demander à chaque tour s'il veut encore frapper
        } while(monstre.getPv() > 0 && heros.getPv() > 0);
        if (heros.getPv() <= 0){
            System.out.printf("Ton héro est mort tu peux recommencer une partie !\n\n");
        }
    }

    // Detecte si un monstre se trouve a proximité du héros
    public static boolean detectionMonstre(Personnage personnage, Personnage[][] plateau){
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
