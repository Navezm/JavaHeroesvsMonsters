package be.digitalcity.formation;

import be.digitalcity.formation.jeu.Jeu;
import be.digitalcity.formation.jeu.personnage.heros.Nain;
import be.digitalcity.formation.jeu.personnage.monstres.Dragonnet;
import be.digitalcity.formation.jeu.personnage.monstres.Loup;
import be.digitalcity.formation.jeu.personnage.monstres.Orque;
import be.digitalcity.formation.jeu.utilitaire.Plateau;

public class Main {

    public static void main(String[] args) {
//        Nain nain = new Nain();
//        Dragonnet dragonnet = new Dragonnet(4,5);
//        Loup loup = new Loup(4,3);
//        Orque orque = new Orque(8,1);
//
//        System.out.println("Nain pv :"+nain.getPv() + " endurance : "+nain.getEndurance());
//        System.out.println("Dragonnet "+dragonnet.getPv());
//
//
//        System.out.println("Or : "+dragonnet.getOr()+" Cuir :"+dragonnet.getCuir());
//        Jeu.combat(nain, dragonnet);
//        System.out.println(nain.getPv());
//
//        nain.rest();
//
//        Jeu.combat(nain, loup);
//        System.out.println(nain.getPv());
//
//        nain.rest();
//
//        Jeu.combat(nain, orque);
//        System.out.println(nain.getPv());
//
////        System.out.println(dragonnet.getOr()+ " " + dragonnet.getCuir());
//
//        System.out.println(nain.getSacADos());

        Plateau plateau = new Plateau();
        plateau.creationPlateau();
    }
}
