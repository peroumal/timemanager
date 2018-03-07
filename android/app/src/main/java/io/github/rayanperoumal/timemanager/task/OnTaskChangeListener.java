package io.github.rayanperoumal.timemanager.task;

/**
 * Created by r.peroumal on 22/11/2017.
 */

public interface OnTaskChangeListener {

    enum TaskChange{
        noActionAvailable, nextActionCalled
    }

    void onTaskChange(TaskChange change);
}
