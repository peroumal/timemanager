package io.github.rayanperoumal.timemanager.task;

/**
 * Created by r.peroumal on 22/11/2017.
 */

public interface Task {
    TaskAction next();
    void addAction(TaskAction taskAction);
}
