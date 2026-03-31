package visitor;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystemElement {
    private List<FileSystemElement> list;
    private String name;

    public Directory(String name) {
        this.name = name;
        this.list = new ArrayList<>();
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }

    public String getName() {
        return name;
    }

    public void addElementToDir(FileSystemElement element){
        this.list.add(element);
    }

    public List<FileSystemElement> getList() {
        return list;
    }
}
