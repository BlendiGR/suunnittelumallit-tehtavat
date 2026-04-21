package prototype;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Recommendation sciFi1 = new Recommendation("Sci-Fi fans", new ArrayList<>());
        sciFi1.addBook(new Book("Frank Herbert", "Dune", Genres.SCIENCE_FICTION));
        sciFi1.addBook(new Book("Isaac Asimov", "Foundation", Genres.SCIENCE_FICTION));

        Recommendation sciFi2 = new Recommendation("Sci-Fi adventurers", new ArrayList<>());
        sciFi2.addBook(new Book("Andy Weir", "The Martian", Genres.SCIENCE_FICTION));
        sciFi2.addBook(new Book("Arthur C. Clarke", "2001: A Space Odyssey", Genres.SCIENCE_FICTION));

        List<Recommendation> recommendations = new ArrayList<>();
        recommendations.add(sciFi1);
        recommendations.add(sciFi2);

        System.out.println("Recommendations for you!");
        for (int i = 0; i < recommendations.size(); i++) {
            Recommendation rec = recommendations.get(i);
            System.out.println((i + 1) + ". " + rec.getTargetAudience() + ":");
            for (Book book : rec.getBooks()) {
                System.out.println("   - " + book.getTitle() + " by " + book.getAuthor());
            }
        }

        System.out.print("\nSelect a recommendation (1-" + recommendations.size() + "): ");
        int choice = Integer.parseInt(scanner.nextLine()) - 1;
        Recommendation selected = (Recommendation) recommendations.get(choice).clone();

        boolean running = true;
        while (running) {
            System.out.println("\nYour recommendation: " + selected.getTargetAudience());
            for (int i = 0; i < selected.getBooks().size(); i++) {
                Book b = selected.getBooks().get(i);
                System.out.println((i + 1) + ". " + b.getTitle() + " by " + b.getAuthor());
            }
            System.out.println("\n1. Add book");
            System.out.println("2. Remove book");
            System.out.println("3. Exit");
            System.out.print("Choice: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.print("Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Title: ");
                    String title = scanner.nextLine();
                    selected.addBook(new Book(author, title, Genres.SCIENCE_FICTION));
                    System.out.println("Book added!");
                    break;
                case "2":
                    System.out.print("Enter book number to remove: ");
                    int removeIndex = Integer.parseInt(scanner.nextLine()) - 1;
                    if (removeIndex >= 0 && removeIndex < selected.getBooks().size()) {
                        selected.removeBook(selected.getBooks().get(removeIndex));
                        System.out.println("Book removed!");
                    } else {
                        System.out.println("Invalid number.");
                    }
                    break;
                case "3":
                    System.out.print("Save this recommendation? (yes/no): ");
                    if (scanner.nextLine().equalsIgnoreCase("yes")) {
                        recommendations.add(selected);
                        System.out.println("Saved!");
                    }
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}
