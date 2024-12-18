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

            // UC 3: Check for options - No Play, Ladder, Snake
            int option = random.nextInt(3); // 0: No Play, 1: Ladder, 2: Snake
            switch (option) {
                case 0: // No Play
                    System.out.println("No Play: Player stays at position " + playerPositions[currentPlayer]);
                    break;
                case 1: // Ladder
                    System.out.println("Ladder! Moving ahead by " + diceRoll + " steps.");
                    playerPositions[currentPlayer] += diceRoll;
                    break;
                case 2: // Snake
                    System.out.println("Snake! Moving back by " + diceRoll + " steps.");
                    playerPositions[currentPlayer] -= diceRoll;
                    break;
            }
            // UC 4: Ensure player position doesn't go below 0
            if (playerPositions[currentPlayer] < 0) {
                playerPositions[currentPlayer] = 0;
            }
            // UC 5: Ensure exact winning position 100
            if (playerPositions[currentPlayer] > WINNING_POSITION) {
                playerPositions[currentPlayer] -= diceRoll;
            }

            System.out.println("Player " + (currentPlayer + 1) + "'s position: " + playerPositions[currentPlayer]);
            // Check for winner
            if (playerPositions[currentPlayer] == WINNING_POSITION) {
                // UC 6: Report the number of dice rolls and positions after every roll
                System.out.println("Player " + (currentPlayer + 1) + " wins the game!");
                System.out.println("Player 1 dice rolls: " + diceRollCounts[0]);
                System.out.println("Player 2 dice rolls: " + diceRollCounts[1]);
                gameOver = true;
            }
        }
    }
}
