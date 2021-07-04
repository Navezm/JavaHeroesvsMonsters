package be.digitalcity.formation.jeu.personnage.heros;

import be.digitalcity.formation.jeu.personnage.Personnage;
import be.digitalcity.formation.jeu.personnage.monstres.Dragonnet;
import be.digitalcity.formation.jeu.personnage.monstres.Loup;
import be.digitalcity.formation.jeu.personnage.monstres.Orque;
import be.digitalcity.formation.jeu.utilitaire.Cuir;
import be.digitalcity.formation.jeu.utilitaire.Loots;
import be.digitalcity.formation.jeu.utilitaire.Or;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Heros extends Personnage implements Loots {

    private List<Loots> sacADos = new ArrayList<>();

    public Heros() {
    }

    public List<Loots> getSacADos() {
//        switch (loot) {
//            case "Cuir":
//                sacADos.stream()
//                        .reduce(Cuir)
//        }
        return sacADos;
    }

    public void rest() {
        this.pv = this.getEndurance() + modificateur(this.getEndurance());
        System.out.printf("Ton héro s'est reposé il est maintenant full PV !\n");
    }

    public void ramasserLoot(Personnage monstre){
        if (monstre instanceof Loup){
            sacADos.add(((Cuir)monstre));
            System.out.println("Bravo tu as récupéré " + ((Cuir)monstre).getCuir() + " cuir !");
        } else if (monstre instanceof Orque){
            sacADos.add((Or)monstre);
            System.out.println("Bravo tu as récupéré " + ((Or)monstre).getOr() + " or !");
        } else {
            sacADos.add(((Or)monstre));
            sacADos.add(((Cuir)monstre));
            System.out.println("Bravo tu as récupéré " + ((Or)monstre).getOr() + " or !");
            System.out.println("Bravo tu as récupéré " + ((Cuir)monstre).getCuir() + " cuir !");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Heros heros = (Heros) o;
        return Objects.equals(sacADos, heros.sacADos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sacADos);
    }

    @Override
    public String toString() {
        return "Heros{" +
                "pv=" + pv +
                ", X=" + X +
                ", Y=" + Y +
                ", sacADos=" + sacADos +
                '}';
    }
}
