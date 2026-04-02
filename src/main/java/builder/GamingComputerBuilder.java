package builder;

public class GamingComputerBuilder implements ComputerBuilder {

    private Computer computer;

    public GamingComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildProcessor() {
        computer.addPart(new PCPart("CPU", "Intel Core i9-14900K"));
    }

    @Override
    public void buildRam() {
        computer.addPart(new PCPart("RAM", "32GB DDR5"));
    }

    @Override
    public void buildHardDrive() {
        computer.addPart(new PCPart("Storage", "2TB NVMe SSD"));
    }

    @Override
    public void buildGraphicsCard() {
        computer.addPart(new PCPart("GPU", "NVIDIA RTX 4090"));
    }

    @Override
    public void buildOperatingSystem() {
        computer.addPart(new PCPart("OS", "Windows 11"));
    }

    public Computer getComputer() {
        return computer;
    }
}
