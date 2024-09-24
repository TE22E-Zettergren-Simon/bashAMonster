import GameCharacter.Hero;
import GameCharacter.Monster;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner inScanner;

    public static void main(String[] args) {
        inScanner = new Scanner(System.in);

        System.out.print("Vad heter din hjälte? > ");
        var heroName = inScanner.nextLine();
        var hero = new Hero(heroName, 100, 10);

        var monster1 = new Monster("Fatty", 50, 15);

        var turnNumber = 0;
        while (hero.hp > 0 && monster1.hp > 0) {
            System.out.println("\n\n ---  Turn: " + turnNumber + "  ---\n");
            System.out.println(hero);
            System.out.println(monster1);

            System.out.println("\nVad vill du göra?");
            var userChoice = chooseFromMenu(new String[]{ "Attackera", "Hela", "Vänta" });

            System.out.println();
            switch (userChoice) {
                case 1:
                    hero.doDamage(monster1);
                    break;
                case 2:
                    hero.heal();
                    break;
                case 3:
                    System.out.println(hero.name + " väntar!");
                    break;
            }

            monster1.doDamage(hero);

            turnNumber++;
        }

        if (hero.hp <= 0) {
            System.out.println("\n" + hero.name + " dog!");
            System.out.println("Du förlorade!");
        } else {
            System.out.println("\n" + monster1.name + " dog!");
            System.out.println("Du vann!");
        }
    }

    private static int chooseFromMenu(String[] choices) {
        for (int i = 0; i < choices.length; i++) {
            System.out.println(i+1 + ". " + choices[i]);
        }
        System.out.print("Välj > ");

        while (true) {
            try {
                var userChoice = inScanner.nextInt();

                if (userChoice > choices.length || userChoice <= 0) {
                    System.out.print("Siffran måste vara mellan 1 och " + choices.length + " > ");
                    continue;
                }

                return userChoice;
            } catch (InputMismatchException e) {
                System.out.print("Det måste vara en siffra > ");
                inScanner.next();
            }
        }
    }
}