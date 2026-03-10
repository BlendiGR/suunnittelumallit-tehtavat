package strategy;

public class SelectionSort implements Algorithm {

    //This was taken from GeeksForGEeks https://www.geeksforgeeks.org/dsa/selection-sort-algorithm-2/
    @Override
    public double measureSort(int[] arr) {
        int n = arr.length;
        long start = System.nanoTime();

        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }

        long end = System.nanoTime();
        return (end - start) / 1_000_000.0;
    }

    @Override
    public String getName() {
        return "SelectionSort";
    }
}