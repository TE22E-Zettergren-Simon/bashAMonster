package GameCharacter;

public abstract class GameCharacter {
    public String name;
    public int hp;
    public int dmg;

    public GameCharacter(String name, int hp, int dmg) {
        this.name = name;
        this.hp = hp;
        this.dmg = dmg;
    }

    public void doDamage(GameCharacter other) {
        System.out.println(this.name + " attackerar " + other.name + " för " + this.dmg + " skada!");
        other.hp -= this.dmg;
    }

    @Override
    public String toString() {
        return name + " har " + hp + " hp";
    }
}
