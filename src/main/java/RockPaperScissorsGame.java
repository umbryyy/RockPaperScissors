import java.util.Random;
import java.util.Scanner;
import Elements.*;
public class RockPaperScissorsGame {
        private static final int NUMBER_OF_OPTIONS = 3; // Player's choice among the 3 options (Rock, Paper, Scissors)

        public static void main(String[] args) {
            welcome();
            Choice[] gameSetup = setGame(playerChoice()); // Player decision and random opponent choice
            playGame(gameSetup);
        }

        private static void welcome() {
            System.out.println("*****************************");
            System.out.println("*   Rock Paper Scissors    *");
            System.out.println("*****************************");
            // Choices
            System.out.println("Press one of these numbers (0, 1, 2) for your choice:");
            System.out.println("| 0. Rock                 |");
            System.out.println("| 1. Paper                |");
            System.out.println("| 2. Scissors             |");
        }

        private static int playerChoice() {
            // Allows the player to choose a number between 0 and 2,
            // determining the choice between rock, paper, and scissors.

            Scanner scanner = new Scanner(System.in);
            int choice;
            do {
                System.out.println("Choose a number between 0 and 2:");
                choice = scanner.nextInt();
            } while (choice < 0 || choice >= NUMBER_OF_OPTIONS);
            scanner.close();
            return choice;
        }

        private static Choice[] setGame(int playerChoice) {
            // Returns an array of two elements, position 0: player's choice
            // position 1: opponent's choice

            Random random = new Random();
            Rock rock = new Rock();
            Paper paper = new Paper();
            Scissors scissors = new Scissors();
            Choice[] elements = { rock, paper, scissors }; // elements that can be chosen
            int randomDecision = random.nextInt(NUMBER_OF_OPTIONS); // 3 values
            Choice[] gameSetup = { elements[playerChoice], elements[randomDecision] };
            System.out.println("You chose: " + gameSetup[0].getName());
            System.out.println("The opponent chose: " + gameSetup[1].getName());
            return gameSetup;
        }

        private static void playGame(Choice[] choices) {
            // Game algorithm that "returns" the outcome of the game

            String player = choices[0].getName();
            String opponent = choices[1].getName();
            if (player.equals(opponent)) {
                // When the player's choice is equal to the opponent's choice (the array will have two duplicate values)
                System.out.println("It's a tie!");
            } else {
                if (player.equals("Rock") && opponent.equals("Paper") ||
                        player.equals("Paper") && opponent.equals("Scissors") ||
                        player.equals("Scissors") && opponent.equals("Rock")) {
                    // Case where the player loses
                    choices[1].beats(choices[0]);
                    System.out.println("You lost!");
                } else {
                    // Case where the player wins
                    choices[0].beats(choices[1]);
                    System.out.println("You won!");
                }
            }
        }
}
