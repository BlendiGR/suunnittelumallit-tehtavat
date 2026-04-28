package Iterator;

public class FibonacciSequence implements IterableCollection {
    private int limit;

    public FibonacciSequence(int limit){
        this.limit = limit;
    }

    @Override
    public Iterator createIterator() {
        return new FibonacciIterator(limit);
    }
}
