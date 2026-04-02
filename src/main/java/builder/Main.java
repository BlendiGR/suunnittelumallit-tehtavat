package builder;

public class Main {
    public static void main(String[] args) {
        GamingComputerBuilder gamingBuilder = new GamingComputerBuilder();
        ComputerDirector director = new ComputerDirector(gamingBuilder);
        director.constructComputer();
        System.out.println("=== Gaming PC ===");
        System.out.println(gamingBuilder.getComputer());

        OfficeComputerBuilder officeBuilder = new OfficeComputerBuilder();
        director = new ComputerDirector(officeBuilder);
        director.constructComputer();
        System.out.println("=== Office PC ===");
        System.out.println(officeBuilder.getComputer());
    }
}