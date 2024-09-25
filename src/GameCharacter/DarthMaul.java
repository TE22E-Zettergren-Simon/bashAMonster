package GameCharacter;

import java.util.ArrayList;

// DarthMaul, gör endast skada varannan tur
public class DarthMaul extends ComputerCharacter {
    private boolean doDamageThisTurn;

    public DarthMaul() {
        super("Darth Maul", 20, 50);
        doDamageThisTurn = false;
    }

    @Override
    public void doTurn(Hero player, ArrayList<ComputerCharacter> enemies) {
        if (doDamageThisTurn) {
            this.doDamageTo(player);
        } else {
            System.out.println(name +  " laddar upp sin attack");
        }

        doDamageThisTurn = !doDamageThisTurn;
    }
}
