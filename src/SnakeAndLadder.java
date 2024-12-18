import java.util.Random;

public class SnakeAndLadder {
    public static void main(String[] args) {
        // UC 1: Snake and Ladder game played with a single player at start position 0
        System.out.println("Welcome to the Snake and Ladder Game!");
        System.out.println("Single Player at Start Position 0");

        final int WINNING_POSITION = 100;
        int[] playerPositions = {0, 0}; // Positions for 2 players
        int[] diceRollCounts = {0, 0}; // Dice roll counts for 2 players
        boolean gameOver = false;

        Random random = new Random();
        int currentPlayer = 0; // 0 for Player 1, 1 for Player 2

        while (!gameOver) {
            System.out.println("Player " + (currentPlayer + 1) + "'s turn");

            // UC 2: The Player rolls the die to get a number between 1 and 6
            int diceRoll = random.nextInt(6) + 1; // Roll dice (1-6)
            diceRollCounts[currentPlayer]++;
            System.out.println("Dice rolled: " + diceRoll);
        }
    }
}
