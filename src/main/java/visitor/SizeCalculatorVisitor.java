package visitor;

import java.util.List;

public class SizeCalculatorVisitor implements FileSystemVisitor {
    private double totalSize = 0;

    @Override
    public void visit(File file) {
        totalSize += file.getSize();
    }

    @Override
    public void visit(Directory directory) {
        List<FileSystemElement> list = directory.getList();

        for (FileSystemElement e : list){
            e.accept(this);
        }
    }

    public double getTotalSize() {
        return totalSize;
    }
}
