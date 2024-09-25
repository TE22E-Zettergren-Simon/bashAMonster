package GameCharacter;

// Abstrakt klass som representerar en karaktär i spelet, både spelar styrd och dator styrd
// Alla karaktärer har ett namn och enkla stats
// Karaktärer kan göra skada mot varandra och omvandlas till en enkel String
public abstract class GameCharacter {
    protected String name;
    protected int health;
    protected int damage;

    public GameCharacter(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    // Getters

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    // Metoder

    public void doDamageTo(GameCharacter other) {
        System.out.println(this.name + " attackerar " + other.name + " för " + this.damage + " skada!");
        other.health -= this.damage;
    }

    @Override
    public String toString() {
        return name + " har " + health + " hälsa";
    }
}
