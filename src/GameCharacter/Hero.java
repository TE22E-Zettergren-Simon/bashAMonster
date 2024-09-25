package GameCharacter;

// En hjälte
// Har förmågan att hela sig
public class Hero extends GameCharacter {
    private int healPower;

    public Hero(String name, int health, int damage, int healPower) {
        super(name, health, damage);
        this.healPower = healPower;
    }

    public void heal() {
        System.out.println(name + " helade för " + healPower + " hälsa!");
        health += healPower;
    }
}
