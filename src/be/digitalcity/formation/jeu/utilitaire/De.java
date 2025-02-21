package be.digitalcity.formation.jeu.utilitaire;

public final class De {
    public static int lancerDe(int face){
        return switch (face) {
            case 4 -> 1 + (int) (Math.random() * ((4 - 1) + 1));
            case 6 -> 1 + (int) (Math.random() * ((6 - 1) + 1));
            default -> 0;
        };
    }
}
