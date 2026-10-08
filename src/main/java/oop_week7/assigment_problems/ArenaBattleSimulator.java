package main.java.oop_week7.assigment_problems;

interface Attackable {
    String attack();
    String attack(String weaponName);
}

interface Defendable {
    String defend();
}

abstract class GameCharacter {
    private static int counter = 1;
    private final String characterId;
    
    public GameCharacter() {
        this.characterId = "CHAR-" + (counter++);
    }
    
    public abstract String getSpecialMove();
    public String getCharacterId() { return characterId; }
}

class Warrior extends GameCharacter implements Attackable, Defendable {
    private String name;
    public Warrior(String name) { this.name = name; }
    
    @Override
    public String attack() { return name + " strikes with a blade"; }
    
    @Override
    public String attack(String weaponName) { return name + " strikes with an " + weaponName; }
    
    @Override
    public String defend() { return name + " raises a shield"; }
    
    @Override
    public String getSpecialMove() { return name + " unleashes Whirlwind Slash"; }
}

class Trap implements Defendable {
    private String trapType;
    public Trap(String trapType) { this.trapType = trapType; }
    
    @Override
    public String defend() { return trapType + " triggers automatically"; }
}

public class ArenaBattleSimulator {
    public static void resolveDefense(Defendable[] combatants) {
        for (Defendable d : combatants) {
            if (d != null) System.out.println(d.defend());
        }
    }
}