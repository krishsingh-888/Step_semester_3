package main.java.oop_week1.class_problems;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        int wins = 0, losses = 0, draws = 0;
        int rounds = 5;

        for (int i = 1; i <= rounds; i++) {
            System.out.print("Round " + i + " - Player move (Rock/Paper/Scissors): ");
            String playerMove = sc.next();
            String compMove = moves[rand.nextInt(3)];
            
            System.out.print("Computer: " + compMove + " | ");
            if (playerMove.equalsIgnoreCase(compMove)) {
                System.out.println("Result: Draw");
                draws++;
            } else if ((playerMove.equalsIgnoreCase("Rock") && compMove.equals("Scissors")) ||
                       (playerMove.equalsIgnoreCase("Paper") && compMove.equals("Rock")) ||
                       (playerMove.equalsIgnoreCase("Scissors") && compMove.equals("Paper"))) {
                System.out.println("Result: Player Wins");
                wins++;
            } else {
                System.out.println("Result: Computer Wins");
                losses++;
            }
        }
        double winPercent = ((double) wins / rounds) * 100;
        System.out.printf("Final Summary: Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%\n", wins, losses, draws, winPercent);
    }
}