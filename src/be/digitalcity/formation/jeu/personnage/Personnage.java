package be.digitalcity.formation.jeu.personnage;

import be.digitalcity.formation.jeu.utilitaire.De;

import java.util.Arrays;

public abstract class Personnage {
    private final int force;
    private final int endurance;
    protected int pv;
    protected int X;
    protected int Y;

    // Déclaration stats de bases
    public Personnage(){
        int[] stats1 = new int[4];

        for (int i = 0; i < 4; i++) {
            stats1[i] = De.lancerDe(6);
        }
        Arrays.sort(stats1);
        this.force = stats1[3] + stats1[2] + stats1[1];

        int[] stats2 = new int[4];
        for (int i = 0; i < 4; i++) {
            stats2[i] = De.lancerDe(6);
        }
        Arrays.sort(stats2);
        this.endurance = stats2[3] + stats2[2] + stats2[1];

        this.pv = this.getEndurance() + modificateur(this.getEndurance());
    }

    public int getForce() {
        return force;
    }

    public int getEndurance() {
        return endurance;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv -= pv;
    }

    public void frappe(Personnage personnage){
        int dmg = De.lancerDe(4) + modificateur(this.getForce());
        personnage.setPv(dmg);
        System.out.printf("%s reçoit %d dommages\nIl lui reste %d PV\n", personnage.getClass().getSimpleName(), dmg, personnage.getPv());
    }

    // Modificateur basé sur un stat
    public int modificateur(int stat){
        int modificateur = 0;
        if (stat < 5){
            modificateur -= 1;
        } else if (stat > 10 && stat < 15) {
            modificateur += 1;
        } else if (stat > 15){
            modificateur += 2;
        }
        return modificateur;
    }


}
