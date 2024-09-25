package GameCharacter;

import java.util.ArrayList;
import java.util.Random;

// Fientlig karaktär som försöker hela sin lagmedlemmar
public class Mercy extends ComputerCharacter {
    private final int healPower;
    private final Random rand;

    public Mercy(String name) {
        super(name, 30, 0);
        healPower = 5;
        rand = new Random();
    }

    // Försök hela varje lagmedlem
    @Override
    public void doTurn(Hero player, ArrayList<ComputerCharacter> enemies) {
        for (var enemy : enemies) {
            // Kan inte hela sig själv, men kan hela andra Mercy karaktärer
            if (enemy == this) {
                continue;
            }

            // 33% chans att hela lagmedlemmen
            if (rand.nextInt(3) == 0) {
                enemy.health += healPower;
                System.out.println(name + " helar " + enemy.name + " för " + healPower + " hälsa!");
            } else {
                System.out.println(name + " försöker hela " + enemy.name + ", men misslyckas!");
            }
        }
    }
}
