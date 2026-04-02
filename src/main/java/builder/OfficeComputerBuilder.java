package builder;

public class OfficeComputerBuilder implements ComputerBuilder {

    private Computer computer;

    public OfficeComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildProcessor() {
        computer.addPart(new PCPart("CPU", "Intel Core i5-13500"));
    }

    @Override
    public void buildRam() {
        computer.addPart(new PCPart("RAM", "16GB DDR4"));
    }

    @Override
    public void buildHardDrive() {
        computer.addPart(new PCPart("Storage", "512GB SSD"));
    }

    @Override
    public void buildGraphicsCard() {
        computer.addPart(new PCPart("GPU", "Intel UHD Graphics 770 (integrated)"));
    }

    @Override
    public void buildOperatingSystem() {
        computer.addPart(new PCPart("OS", "Windows 11"));
    }

    public Computer getComputer() {
        return computer;
    }
}