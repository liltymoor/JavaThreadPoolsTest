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
    }

}
