import tasks.FibonacciTask;

public class Main {
    public static void main(String [] args) {
        TaskTester tester = new TaskTester();

        tester.setTaskExecutionDifficulty(200);
        tester.setUsePrecompiledExecutors(true);

        int fibNumber = 40;

        tester.taskVirtualTest(new FibonacciTask(fibNumber));
        tester.taskCachedTest(new FibonacciTask(fibNumber));
        tester.taskFixedTest(new FibonacciTask(fibNumber));
        tester.taskSingleThreadTest(new FibonacciTask(fibNumber));
    }
}
