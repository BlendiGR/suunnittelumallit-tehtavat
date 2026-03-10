package strategy;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] data = new Random().ints(size, 1, 100000).toArray();

        System.out.println("\nSelect Sorting Algorithm:");
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
                System.out.println("Invalid choice. Defaulting to QuickSort.");
                context.setAlgorithm(new QuickSort());
                break;
        }

        context.sortArray(data);

        scanner.close();
    }
}