package be.digitalcity.formation.game.util;

public final class Die {

    private Die() {
    }

    public static int roll(int faces) {
        return switch (faces) {
            case 4 -> 1 + (int) (Math.random() * 4);
            case 6 -> 1 + (int) (Math.random() * 6);
            default -> throw new IllegalArgumentException("Unsupported number of faces: " + faces);
        };
    }
}