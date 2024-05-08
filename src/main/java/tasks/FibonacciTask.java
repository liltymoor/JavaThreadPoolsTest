package tasks;

public class FibonacciTask extends Task{
    private int difficulty = 10000;
    public FibonacciTask(int difficulty) {
        super("fibonacci " + difficulty);
        this.difficulty = difficulty;
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
        fibonacci(difficulty);
    }
}
