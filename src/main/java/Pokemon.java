package main.java;

public class Pokemon {
    private final int id;
    private final String name;
    private final String type1;
    private final String type2;
    private final int total;
    private int hp;
    private final int attack;
    private final int defense;
    private final int spAtk;
    private final int spDef;
    private final int speed;

    private Attack attackPrimary;
    private Attack attackSecondary;


    public Pokemon(int id, String name, String type1, String type2, int total, int hp, int attack, int defense, int spAtk, int spDef, int speed) {
        this.id = id;
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.total = total;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.spAtk = spAtk;
        this.spDef = spDef;
        this.speed = speed;
    }

    public Attack getAttackPrimary() {
        return attackPrimary;
    }

    public Attack getAttackSecondary() {
        return attackSecondary;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType1() {
        return type1;
    }

    public String getType2() {
        return type2;
    }

    public int getTotal() {
        return total;
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setAttackPrimary(Attack attackPrimary) {
        this.attackPrimary = attackPrimary;
    }

    public void setAttackSecondary(Attack attackSecondary) {
        this.attackSecondary = attackSecondary;
    }

    public int getSpAtk() {
        return spAtk;
    }

    public int getSpDef() {
        return spDef;
    }

    public int getSpeed() {
        return speed;
    }


    public void setHp(int hp) {
        this.hp=hp;
    }
}