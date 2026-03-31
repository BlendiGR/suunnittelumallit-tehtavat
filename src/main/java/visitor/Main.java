package visitor;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Directory root = new Directory("root");
        Directory documents = new Directory("documents");
        Directory images = new Directory("images");

        documents.addElementToDir(new File("report.txt", 1.5));
        documents.addElementToDir(new File("notes.txt", 0.8));
        documents.addElementToDir(new File("presentation.pdf", 5.2));

        images.addElementToDir(new File("photo.jpg", 3.1));
        images.addElementToDir(new File("screenshot.png", 2.4));

        root.addElementToDir(documents);
        root.addElementToDir(images);
        root.addElementToDir(new File("readme.txt", 0.1));

        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        root.accept(sizeVisitor);
        System.out.println("Total size: " + sizeVisitor.getTotalSize() + " MB");

        SearchVisitor searchVisitor = new SearchVisitor(".txt");
        root.accept(searchVisitor);
        List<File> found = searchVisitor.getResults();
        System.out.println("\nFiles matching '.txt':");
        for (File f : found) {
            System.out.println("  " + f.getName() + " (" + f.getSize() + " MB)");
        }
    }
}
