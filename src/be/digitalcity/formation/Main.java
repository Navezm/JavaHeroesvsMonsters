package be.digitalcity.formation;

import be.digitalcity.formation.jeu.Jeu;

public class Main {

    public static void main(String[] args) {
        Jeu jeu = new Jeu();
        jeu.lancerJeu();
    }
}


// TO DO :
//      Afficher les mobs seulement quand on proche d'eux
//      Fixer la création de mobs pour être à plus de deux cases les uns des autres
//      Rajouter des objets (potions, épée, etc)
//      Créer un shop ou on peut acheter des choses
//          Rajouter de l'argent
//      Fixer les problèmes d'user input
