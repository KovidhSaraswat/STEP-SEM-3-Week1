import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }
        
        if (playerMove.equalsIgnoreCase("Rock")) {
            return computerMove.equalsIgnoreCase("Scissors") ? "Player Wins" : "Computer Wins";
        } else if (playerMove.equalsIgnoreCase("Paper")) {
            return computerMove.equalsIgnoreCase("Rock") ? "Player Wins" : "Computer Wins";
        } else if (playerMove.equalsIgnoreCase("Scissors")) {
            return computerMove.equalsIgnoreCase("Paper") ? "Player Wins" : "Computer Wins";
        }
        
        return "Invalid Move";
    }

    public static void main(String[] args) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int totalRounds = 5;
        String[] playerMoves = new String[totalRounds];
        String[] computerMoves = new String[totalRounds];
        String[] results = new String[totalRounds];

        int wins = 0, losses = 0, draws = 0;

        System.out.println("--- Starting Rock-Paper-Scissors (5 Rounds) ---");

        for (int i = 0; i < totalRounds; i++) {
            System.out.print("Round " + (i + 1) + " - Enter your move (Rock, Paper, Scissors): ");
            String playerMove = scanner.nextLine().trim();

            // Fallback for invalid input
            while (!playerMove.equalsIgnoreCase("Rock") && 
                   !playerMove.equalsIgnoreCase("Paper") && 
                   !playerMove.equalsIgnoreCase("Scissors")) {
                System.out.print("Invalid choice. Please enter Rock, Paper, or Scissors: ");
                playerMove = scanner.nextLine().trim();
            }

            String computerMove = moves[random.nextInt(3)];
            String result = playRound(playerMove, computerMove);

            playerMoves[i] = playerMove;
            computerMoves[i] = computerMove;
            results[i] = result;

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            System.out.println("Player: " + playerMove + ", Computer: " + computerMove + " | " + result + "\n");
        }

        // Output Table
        System.out.println("==================================================================");
        System.out.printf("%-10s | %-15s | %-15s | %-15s\n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("------------------------------------------------------------------");
        for (int i = 0; i < totalRounds; i++) {
            System.out.printf("%-10s | %-15s | %-15s | %-15s\n", 
                              "Round " + (i + 1), playerMoves[i], computerMoves[i], results[i]);
        }
        System.out.println("==================================================================");

        double winPercentage = ((double) wins / totalRounds) * 100;
        System.out.printf("Final Summary: Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%\n", 
                          wins, losses, draws, winPercentage);

        scanner.close();
    }
}