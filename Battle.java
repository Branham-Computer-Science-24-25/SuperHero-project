import java.util.Random;
import java.util.Scanner;

/**
 * The Battle class simulates a superhero battle game where the user selects a hero and an opponent.
 * The game is a best of 3 format, where the first hero to win 2 rounds wins the game.
 */

public class Battle {
    public static void main(String[] args) {
//Creating superhero objects for heroes
        SuperHero superman = new SuperHero("Superman", 90, 0);
        SuperHero ironman = new SuperHero("Ironman", 50, 0);
        SuperHero spiderman = new SuperHero("Spiderman", 70, 30);
        SuperHero batman = new SuperHero("Batman", 50, 0);
        SuperHero thor = new SuperHero("Thor", 80, 40);
        SuperHero captainamerica = new SuperHero("Captain America", 60, 20);
// Scanner object for input
        Scanner input = new Scanner(System.in);
        // declaring variables to hold the user and opponent's heroes
        SuperHero userHero = null;
        SuperHero opponentHero = null;
        String userChoice;
        String opponentChoice;
        //prompts user to select hero
        while (userHero == null) {
            System.out.println("Pick a hero: ");
            System.out.println("Superman\nIronman\nSpiderman\nBatman\nThor\nCaptain America");
            System.out.println("\nYour choice: ");
            userChoice = input.nextLine();
//checks and assigns chosen hero to userHero
            if (userChoice.equals("Superman")) {
                userHero = superman;
            } else if (userChoice.equals("Ironman")) {
                userHero = ironman;
            } else if (userChoice.equals("Spiderman")) {
                userHero = spiderman;
            }
            else if (userChoice.equals("Batman")) {
                userHero = batman;
            }
            else if (userChoice.equals("Thor")) {
                userHero = thor;
            }
            else if (userChoice.equals("Captain America")) {
                userHero = captainamerica;
            }
            else {
                System.out.println("Invalid choice. Try again.");
            }
        }
        //tells user to pick opponent different from hero
        while (opponentHero == null) {
            System.out.println("Pick an opponent (differerent from your hero: ");
            System.out.println("Superman\nIronman\nSpiderman\nBatman\nThor\nCaptain America");
            System.out.println("\nYour opponent: ");
            opponentChoice = input.nextLine();
//checks and assigns the chosen opponent hero to opponentHero
            if (opponentChoice.equals("Superman") && userHero != superman) {
                opponentHero = superman;
            } else if (opponentChoice.equals("Ironman") && userHero != ironman) {
                opponentHero = ironman;
            }
            else if (opponentChoice.equals("Spiderman") && userHero != spiderman) {
                opponentHero = spiderman;
            }
            else if (opponentChoice.equals("Batman") && userHero != batman) {
                opponentHero = batman;
            }
            else if (opponentChoice.equals("Thor") && userHero != thor) {
                opponentHero = thor;
            }
            else if (opponentChoice.equals("Captain America")) {
                opponentHero = captainamerica;
            }
            else {
                System.out.println("Invalid choice. Opponent must be different from your superhero");
            }
        }
//variables to track wins
        int userWins = 0;
        int opponentWins = 0;
//loop for best of three
        for (int i = 1; i <= 3; i++) {
            System.out.println("\nRound" + i);
            String winner = userHero.fight(opponentHero);
//increments win counts based on result
            if (winner.equals(userHero.getName())) {
                userWins++;
            } else if (winner.equals(opponentHero.getName())) {
                opponentWins++;
            }
//if either hero wins 2 rounds the loop breaks
            if (userWins == 2 || opponentWins == 2) {
                break;
            }
        }
        //displays the winner
        if (userWins == 2) {
            System.out.println("\n" + userHero.getName() + " wins the best of 3!");
        } else if (opponentWins == 2) {
            System.out.println("\n" + opponentHero.getName() + " wins the best of 3!");
        }
    }
}