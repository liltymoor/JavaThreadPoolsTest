import tasks.FibonacciTask;

public class Main {
    public static void main(String [] args) {
        TaskTester tester = new TaskTester();

        tester.setTaskExecutionDifficulty(200);
        tester.setUsePrecompiledExecutors(true);

        int fibDifficulty = 100;

        tester.taskVirtualTest(new FibonacciTask(fibDifficulty));
        tester.taskCachedTest(new FibonacciTask(fibDifficulty));
        tester.taskFixedTest(new FibonacciTask(fibDifficulty));
    }
}
