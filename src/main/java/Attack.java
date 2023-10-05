package main.java;

public class Attack {

    private final int id;
    private final String name;
    private final String effect;
    private final String type;
    private final String kind;
    private final int power;
    private final String accuracy;
    private final int pp;


    public Attack(int id, String name, String effect, String type, String kind, int power, String accuracy, int pp) {
        this.id = id;
        this.name = name;
        this.effect = effect;
        this.type = type;
        this.kind = kind;
        this.power = power;
        this.accuracy = accuracy;
        this.pp = pp;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEffect() {
        return effect;
    }

    public String getType() {
        return type;
    }

    public String getKind() {
        return kind;
    }

    public int getPower() {
        return power;
    }

    public String getAccuracy() {
        return accuracy;
    }

    public int getPp() {
        return pp;
    }
}
