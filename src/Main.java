public class Main {
    public static void main(String[] args) {
        Hero hero = new Hero("Zutten", 100, 10);
        Monster monster1 = new Monster("Fatty", 50, 15);

        System.out.println("HJÄLTE: " + hero);
        System.out.println("MONSTER: " + monster1);

        System.out.println();
        System.out.println(hero.name + " attackerar för " + hero.dmg + " skada!");
        monster1.hp -= hero.dmg;

        System.out.println();
        System.out.println("HJÄLTE: " + hero);
        System.out.println("MONSTER: " + monster1);
    }
}