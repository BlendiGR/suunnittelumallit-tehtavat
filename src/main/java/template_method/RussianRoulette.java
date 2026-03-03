package template_method;
import java.util.*;

public class RussianRoulette extends Game {
    private final Random rand = new Random();
    private int bulletChamber;
    private int currentChamber;
    private int loser = -1;
    private boolean isBang = false;

    @Override
    public void initializeGame(int numberOfPlayers) {
        bulletChamber = rand.nextInt(6);
        currentChamber = 0;
        System.out.println("The cylinder is spun. " + numberOfPlayers + " players at the table.");
    }

    @Override
    public void playSingleTurn(int player) {
        System.out.print("Player " + player + " pulls the trigger... ");

        if (currentChamber == bulletChamber) {
            System.out.println("BANG!");
            isBang = true;
            loser = player;
        } else {
            System.out.println("*click*");
            currentChamber++;
        }
    }

    @Override
    public boolean endOfGame() {
        return isBang;
    }

    @Override
    public void displayWinner() {
        System.out.println("--- Game ended ---");
        System.out.println("Player " + loser + " is eliminated.");
    }
}