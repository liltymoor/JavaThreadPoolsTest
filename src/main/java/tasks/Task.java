package tasks;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.logging.Logger;

public abstract class Task {
    public final String taskName;
    public Task(String name) {
        taskName = name;
    }
    protected abstract void compute();
    public void runTask() {
        compute();
//        Logger logger = Logger.getLogger("Test");
//        long startTime = System.currentTimeMillis();
//
//        System.out.println("=================\n");
//        logger.info("Task %s is running".formatted(taskName));
//
//        compute();
//
//        long endTime = System.currentTimeMillis();
//
//        logger.info("Task %s is ended | Efficiency: %s".formatted(taskName, endTime - startTime));
//        System.out.println("\n=================");
    };

}
