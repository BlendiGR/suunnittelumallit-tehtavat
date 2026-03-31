package visitor;

public class File implements FileSystemElement {
    private String name;
    private double size;

    public File(String name, double size) {
        this.name = name;
        this.size = size;
    }


    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }

    public double getSize() {
        return size;
    }

    public String getName() {
        return name;
    }
}
