package GameCharacter;

public class Hero extends GameCharacter {
    public Hero(String name, int hp, int dmg) {
        super(name, hp, dmg);
    }

    public void heal() {
        System.out.println(name + " helade för 20 hälsa!");
        hp += 20;
    }
}
