public class Player {
    private int id;
    private String name;
    private int Strength;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return Strength;
    }

    public Player(int id, String name, int strength) {
        this.id = id;
        this.name = name;
        Strength = strength;
    }
}
