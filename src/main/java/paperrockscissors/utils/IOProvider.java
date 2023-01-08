package paperrockscissors.utils;

import paperrockscissors.controller.GameResult;
import paperrockscissors.enums.PlayAgain;
import paperrockscissors.enums.RoundResult;
import paperrockscissors.player.Player;

import java.util.Scanner;

public class IOProvider {
    private final Scanner scanner;

    public IOProvider() {
        this.scanner = new Scanner(System.in);
    }

    public String getInput() {
        return scanner.nextLine();
    }

    private void printWithNewLine(String printable) {
        System.out.println(printable);
        System.out.flush();
    }

    public void displayIntro() {
        printWithNewLine("Let's play PaperRockScissors! ");
    }

    public void displayChoiceIntro() {
        printWithNewLine("Enter your choice: P - Paper, R - Rock, S - Scissors");
    }

    public void displayValidChoiceWarning() {
        printWithNewLine("Please enter a valid choice!");
    }

    public void displayRoundResult(final RoundResult roundResult) {
        printWithNewLine("RESULT: " + roundResult);
    }

    public void displayPlayersChoice(final Player player) {
        printWithNewLine(player.getName() + " chose " + player.getChoice().getName());
    }

    public void displaySummary(final GameResult gameResult) {
        printWithNewLine("----------------------------");
        printWithNewLine("SUMMARY:");
        printWithNewLine("Number of  games WON: " + gameResult.getWins());
        printWithNewLine("Number of  games LOST: " + gameResult.getLosses());
        printWithNewLine("Number of  games TIED: " + gameResult.getTies());
        printWithNewLine("----------------------------");
    }

    public PlayAgain playAgain() {
        try {
            printWithNewLine("Would you like to continue playing?" + " (Y/N)");
            final String input = getInput().toUpperCase();
            return PlayAgain.valueOf(input);
        } catch (IllegalArgumentException ex) {
            displayValidChoiceWarning();
            return playAgain();
        }
    }
}
