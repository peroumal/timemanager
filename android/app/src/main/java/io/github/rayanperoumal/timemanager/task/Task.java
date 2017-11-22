package io.github.rayanperoumal.timemanager.task;

import io.github.rayanperoumal.timemanager.task.action.TaskAction;

/**
 * Created by r.peroumal on 22/11/2017.
 */

public interface Task {
    TaskAction next();
    void addAction(TaskAction taskAction);
}
