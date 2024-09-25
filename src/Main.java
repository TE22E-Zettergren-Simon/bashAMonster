import GameCharacter.GameCharacter;
import GameCharacter.Hero;
import GameCharacter.Monster;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final Scanner inScanner = new Scanner(System.in);

    private static boolean wonLatestFight;

    public static void main(String[] args) {
        // Skapa den spelbara hjälten
        System.out.print("Vad heter din hjälte? > ");
        var heroName = inScanner.nextLine();
        var hero = new Hero(heroName, 100, 10, 25);

        // Skapa datorstyrda monster
        var monster1 = new Monster("Fatty", 100, 10);
        var monster2 = new Monster("Slimmy", 20, 25);

        var enemies = new ArrayList<GameCharacter>();
        enemies.add(monster1);
        enemies.add(monster2);

        // Starta fighten
        fight(hero, enemies);

        // Skriv ut fightens resultat
        System.out.println("\n\n --- Resultat ---\n");
        if (wonLatestFight) {
            System.out.println(hero.getName() + " dog!");
            System.out.println("Du förlorade!");
        } else {
            System.out.println("Alla monster är döda");
            System.out.println("Du vann!");
        }
    }

    // En fight mellan en spelbar karaktär och en datorstyrd karaktär
    // Ändrar 'wonLatestFight' beroende av hur fighten gick
    private static void fight(Hero player, ArrayList<GameCharacter> enemies) {
        var turnNumber = 1;

        while (true) {
            // Skriv ut information
            System.out.println("\n\n ---  Tur: " + turnNumber + "  ---\n");
            System.out.println(player);
            for (var enemy : enemies) {
                System.out.println(enemy);
            }

            // Läs in användarens val
            System.out.println("\nVad vill du göra?");
            var userChoice = chooseFromMenu(new String[]{ "Attackera", "Hela", "Vänta" });

            // Utför användarens val
            System.out.println();
            switch (userChoice) {
                case 1: // Attackera
                    var enemyIndex = 0;

                    // Låt spelaren välja vilken fiende som attackeras om det finns flera
                    if (enemies.size() > 1) {
                        // Skapa en lista med alla fiender
                        var enemyNames = new String[enemies.size()];
                        for (int i = 0; i < enemyNames.length; i++) {
                            enemyNames[i] = enemies.get(i).getName();
                        }

                        // Välj vem som attackeras
                        System.out.println("Vem vill du attackera");
                        enemyIndex = chooseFromMenu(enemyNames) - 1;
                        System.out.println();
                    }

                    // Gör skada
                    player.doDamageTo(enemies.get(enemyIndex));

                    // Ta bort fienden om den dog
                    if (enemies.get(enemyIndex).getHealth() <= 0) {
                        System.out.println("Du dödade " + enemies.get(enemyIndex).getName() + "!");
                        enemies.remove(enemyIndex);
                    }

                    break;
                case 2: // Hela
                    player.heal();
                    break;
                case 3: // Vänta
                    System.out.println(player.getName() + " väntar!");
                    break;
            }

            // Datorns tur
            for (var enemy : enemies) {
                enemy.doDamageTo(player);
            }

            // Kolla om spelaren är vid liv
            if (player.getHealth() <= 0) {
                break;
            }

            // Kolla om alla monster är döda
            var everyMonsterDead = true;
            for (var enemy : enemies) {
                if (enemy.getHealth() > 0) {
                    everyMonsterDead = false;
                    break;
                }
            }
            if (everyMonsterDead) {
                break;
            }

            turnNumber++;
        }

        wonLatestFight = player.getHealth() <= 0;
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
