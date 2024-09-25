package GameCharacter;

// En spelbar hjälte
// Har förmågan att hela sig
public class Hero extends GameCharacter {
    private final int healPower;

    public Hero(String name, int health, int damage, int healPower) {
        super(name, health, damage);
        this.healPower = healPower;
    }

    public void heal() {
        System.out.println(name + " helar sig för " + healPower + " hälsa!");
        health += healPower;
    }
}
