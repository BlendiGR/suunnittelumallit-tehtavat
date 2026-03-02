package State;

public class ExpertState implements State {

    private Character character;


    public ExpertState(Character character) {
        this.character = character;
    }

    @Override
    public void train() {
        character.setExperiencePoints(1.5);
        System.out.println("Training....");
        System.out.println("Increasing XP");
        System.out.println("Points left for level up: " + character.getExperiencePoints() + " / " + "10");
    }

    @Override
    public void meditate() {
        character.setHealthPoints(5);
        System.out.println("Meditating....");
        System.out.println("Increasing Health");
    }

    @Override
    public void fight() {
        if (character.getHealthPoints() > 6){
            character.setExperiencePoints(5);
            character.setHealthPoints(-5);
            System.out.println("Fighting.....");
            System.out.println("Points left for level up: " + character.getExperiencePoints() + " / " + "30");
        } else {
            System.out.println("You don't have enough health to fight, please gain more health by meditating.");
        }

    }

    @Override
    public void action() {
        String[] options = {"[1] Train", "[2] Meditate", "[3] Fight"};
        while (character.getExperiencePoints() < 30) {
            System.out.println("\nLevel: " + character.getLevel() + "  XP: " + character.getExperiencePoints() + "  Health: " + character.getHealthPoints() + "!");
            switch (character.readUserChoice(options)){
                case 1:
                    train();
                    break;
                case 2:
                    meditate();
                    break;
                case 3:
                    fight();
                    break;
            }
        }
        System.out.println("You have reached the maximum level! Game ending....");
        character.setGameRunning(false);
    }
}
