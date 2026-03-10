package strategy;

public class AlgorithmContext {

    private Algorithm algorithm;

    public AlgorithmContext(Algorithm alg) {
        this.algorithm = alg;
    }

    public void setAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public void sortArray(int[] arr){
        System.out.println("Sorting using " + algorithm.getName() + " !");
        double result = algorithm.measureSort(arr);
        System.out.println("It took " + result + " ms to sort this array with the " + algorithm.getName() + " method!" + "\n");
    }
}
