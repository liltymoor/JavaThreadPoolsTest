import tasks.Task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class TaskTester {
    // Использовать заранее инициализированные экзекуторы для тестирования (false).
    // Или инициализировать экзекуторы прямо во время теста (true).
    private boolean usePrecompiledExecutors = true;
    public void setUsePrecompiledExecutors(boolean flag) {usePrecompiledExecutors = flag;}

    private final ExecutorService cachedPool = Executors.newCachedThreadPool();
    private final ExecutorService fixedPool = Executors.newFixedThreadPool(20);
    private final ExecutorService virtualPool = Executors.newVirtualThreadPerTaskExecutor();

    private ExecutorService getCachedPool() {
        if (usePrecompiledExecutors) return this.cachedPool;
        return Executors.newCachedThreadPool();
    }
    private ExecutorService getFixedPool() {
        if (usePrecompiledExecutors) return this.fixedPool;
        return Executors.newFixedThreadPool(20);
    }
    private ExecutorService getVirtualPool() {
        if (usePrecompiledExecutors) return this.virtualPool;
        return Executors.newVirtualThreadPerTaskExecutor();
    }

    // Кол-во раз которое задача будет подана пулу на исполнение.
    private int count = 50;
    void setTaskExecutionDifficulty(int count) {
        this.count = count;
    }

    public TaskTester() {

    }

    public void taskSingleThreadTest(Task toTest) {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            toTest.runTask();
        }

        long endTime = System.currentTimeMillis();

        Logger.getLogger("Test").info("Fixed pool finished task %s for %s ms%n"
                .formatted(toTest.taskName, endTime - startTime));
    }

    public void taskFixedTest(Task toTest) {
        long startTime = System.currentTimeMillis();

        ExecutorService pool = getFixedPool();
        for (int i = 0; i < count; i++)
            pool.submit(toTest::runTask);

        long endTime = System.currentTimeMillis();

        Logger.getLogger("Test").info("Fixed pool finished task %s for %s ms%n"
                .formatted(toTest.taskName, endTime - startTime));
    }

    public void taskCachedTest(Task toTest) {
        long startTime = System.currentTimeMillis();

        ExecutorService pool = getCachedPool();
        for (int i = 0; i < count; i++)
            pool.submit(toTest::runTask);

        long endTime = System.currentTimeMillis();

        Logger.getLogger("Test").info("Cached pool finished task %s for %s ms%n"
                .formatted(toTest.taskName, endTime - startTime));
    }

    public void taskVirtualTest(Task toTest) {
        long startTime = System.currentTimeMillis();

        ExecutorService pool = getVirtualPool();
        for (int i = 0; i < count; i++)
            pool.submit(toTest::runTask);

        long endTime = System.currentTimeMillis();

        Logger.getLogger("Test").info("Virtual pool finished task %s for %s ms%n"
                .formatted(toTest.taskName, endTime - startTime));
    }
}
