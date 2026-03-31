package visitor;

import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {
    private String searchCriteria;
    private List<File> results = new ArrayList<>();

    public SearchVisitor(String searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    @Override
    public void visit(File file) {
        if (file.getName().endsWith(searchCriteria)) {
            results.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        for (FileSystemElement e : directory.getList()) {
            e.accept(this);
        }
    }

    public List<File> getResults() {
        return results;
    }
}
