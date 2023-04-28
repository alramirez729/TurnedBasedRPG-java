public enum Difficulty {
    Easy(1), Medium(1.2), Hard(1.5);

    private final double multiplier;

    Difficulty(double multiplier) {
        this.multiplier = multiplier;
    }

    public static Difficulty get(String difficulty) {
        return switch (difficulty.toLowerCase()) {
            case "easy" -> Easy;
            case "medium" -> Medium;
            case "hard" -> Hard;
            default -> null;
        };
    }

    public double getMultiplier() {
        return multiplier;
    }
}
