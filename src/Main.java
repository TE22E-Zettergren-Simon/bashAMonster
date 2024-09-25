import GameCharacter.Hero;
import GameCharacter.Monster;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final Scanner inScanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Skapa den spelbara hjälten
        System.out.print("Vad heter din hjälte? > ");
        var heroName = inScanner.nextLine();
        var hero = new Hero(heroName, 100, 10, 25);

        // Skapa datorstyrt monster
        var monster1 = new Monster("Fatty", 50, 15);

        // Själva spel loopen
        var turnNumber = 1;
        while (hero.getHealth() > 0 && monster1.getHealth() > 0) {
            // Skriv ut information
            System.out.println("\n\n ---  Turn: " + turnNumber + "  ---\n");
            System.out.println(hero);
            System.out.println(monster1);

            // Läs in användarens val
            System.out.println("\nVad vill du göra?");
            var userChoice = chooseFromMenu(new String[]{ "Attackera", "Hela", "Vänta" });

            // Utför användarens val
            System.out.println();
            switch (userChoice) {
                case 1:
                    hero.doDamageTo(monster1);
                    break;
                case 2:
                    hero.heal();
                    break;
                case 3:
                    System.out.println(hero.getName() + " väntar!");
                    break;
            }

            // Datorns tur
            monster1.doDamageTo(hero);

            turnNumber++;
        }

        // Skriv ut fightens resultat
        if (hero.getHealth() <= 0) {
            System.out.println("\n\n" + hero.getName() + " dog!");
            System.out.println("Du förlorade!");
        } else {
            System.out.println("\n\n" + monster1.getName() + " dog!");
            System.out.println("Du vann!");
        }
    }

    // Tar in en lista med möjliga val och returnerar den som användaren valde
    private static int chooseFromMenu(String[] choices) {
        // Skriv ut valen
        for (int i = 0; i < choices.length; i++) {
            System.out.println(i+1 + ". " + choices[i]);
        }
        System.out.print("Välj > ");

        // Läs in användarens val
        // Valet måste vara en siffra som inte är mindre än 1 eller större än antal möjliga val
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
