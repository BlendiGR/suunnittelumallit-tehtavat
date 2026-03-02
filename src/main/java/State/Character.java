package State;

import java.util.Scanner;

public class Character {
    private final String name;
    private int level = 1;
    private double experiencePoints = 0;
    private double healthPoints = 5;
    private boolean isGameRunning;

    private static Scanner scanner = new Scanner(System.in);
    private State state;

    public Character(String name){
        this.name = name;
        state = new NoviceState(this);
    }

    public int readUserChoice(String[] options) {
        System.out.println("\nSelect next action:");
        for (int i = 1; i <= options.length; i++) {
            System.out.println(options[i-1]);
        }
        return scanner.nextInt();
    }

    public void play() {
        System.out.println("Welcome " + this.name + "!");
        isGameRunning = true;
        while (isGameRunning) {
            if (state == null) {
                System.out.println("Game ERROR!");
                return;
            }
            state.action();
        }
    }

    public void setGameRunning(boolean running){
        this.isGameRunning = running;
    }

    public void setHealthPoints(double health){
        this.healthPoints += health;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setExperiencePoints(double points){
        this.experiencePoints += points;
    }

    public double getExperiencePoints() {
        return experiencePoints;
    }

    public double getHealthPoints() {
        return healthPoints;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }
}
