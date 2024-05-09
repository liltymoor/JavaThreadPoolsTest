package tasks;

public class FibonacciTask extends Task{
    private final int number;
    public FibonacciTask(int difficulty) {
        super("fibonacci " + difficulty);
        this.number = difficulty;
    }

    private static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    @Override
    protected void compute() {
        fibonacci(number);
    }
}
