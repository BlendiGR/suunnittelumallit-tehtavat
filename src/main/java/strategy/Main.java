package strategy;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] smallData = new Random().ints(30, 1, 100000).toArray();
        int[] largeData = new Random().ints(100000, 1, 100000).toArray();

        System.out.println("Select Sorting Algorithm:");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Quick Sort");
        System.out.println("3. Selection Sort");
        System.out.print("Choice: ");
        int choice = scanner.nextInt();

        AlgorithmContext context = new AlgorithmContext(null);

        switch (choice) {
            case 1:
                context.setAlgorithm(new BubbleSort());
                break;
            case 2:
                context.setAlgorithm(new QuickSort());
                break;
            case 3:
                context.setAlgorithm(new SelectionSort());
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        System.out.println("\n--- Testing Small Array (30 elements) ---");
        context.sortArray(smallData.clone());

        System.out.println("--- Testing Large Array (100,000 elements) ---");
        context.sortArray(largeData.clone());

        scanner.close();
    }
}