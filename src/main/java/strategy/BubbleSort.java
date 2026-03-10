package strategy;

public class BubbleSort implements Algorithm {

    // This was taken from GeeksForGeeks https://www.geeksforgeeks.org/dsa/bubble-sort-algorithm/
    @Override
    public double measureSort(int[] arr) {
        int n = arr.length;
        long start = System.nanoTime();

        // Core Algorithm
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }

        long end = System.nanoTime();
        return (end - start) / 1_000_000.0;
    }

    @Override
    public String getName() {
        String name = "Bubblesort";
        return name;
    }
}
