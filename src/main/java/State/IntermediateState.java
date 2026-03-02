package State;

public class IntermediateState implements State {

    private Character character;


    public IntermediateState(Character character) {
        this.character = character;
    }

    @Override
    public void train() {
        character.setExperiencePoints(1.5);
        System.out.println("Training....");
        System.out.println("Increasing XP");
        System.out.println("Points left for level up: " + character.getExperiencePoints() + " / " + "20");
    }

    @Override
    public void meditate() {
        character.setHealthPoints(5);
        System.out.println("Meditating....");
        System.out.println("Increasing Health");
    }

    @Override
    public void fight() {
        System.out.println("Progress To Next Level to Unlock This Action!");
    }

    @Override
    public void action() {
        String[] options = {"[1] Train", "[2] Meditate"};
        while (character.getExperiencePoints() < 20) {
            System.out.println("\nLevel: " + character.getLevel() + "  XP: " + character.getExperiencePoints() + "  Health: " + character.getHealthPoints() + "!");
            switch (character.readUserChoice(options)){
                case 1:
                    train();
                    break;
                case 2:
                    meditate();
                    break;
            }
        }
        character.setLevel(3);
        character.setState(new ExpertState(character));
    }
}
