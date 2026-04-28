package Iterator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many Fibonacci numbers? ");
        int n = scanner.nextInt();

        FibonacciSequence fibIt = new FibonacciSequence(n);

        Iterator iterator = fibIt.createIterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }



    }


}
