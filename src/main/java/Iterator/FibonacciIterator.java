package Iterator;

public class FibonacciIterator implements Iterator {
    private int fib; // number of sequences
    private int index = 1; // index at which fib we are right now
    private int prev = 1;
    private int prevTwo = 0;

    public FibonacciIterator(int fib){
        this.fib = fib;
    }

    @Override
    public boolean hasNext() {
        return fib > index;
    }

    @Override
    public int next() {
        int result = prev + prevTwo;
        prevTwo = prev;
        prev = result;
        index++;

        return result;
    }
}
