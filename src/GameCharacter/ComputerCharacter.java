package GameCharacter;

import java.util.ArrayList;

// En spel karaktär som styrs av datorn genom 'doTurn' metoden
public abstract class ComputerCharacter extends GameCharacter {
    public ComputerCharacter(String name, int health, int damage) {
        super(name, health, damage);
    }

    // Utför fiendens tur
    public void doTurn(Hero player, ArrayList<ComputerCharacter> enemies) {
        this.doDamageTo(player);
    }
}
