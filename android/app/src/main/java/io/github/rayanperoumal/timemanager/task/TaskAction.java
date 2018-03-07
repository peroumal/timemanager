package io.github.rayanperoumal.timemanager.task;

import io.github.rayanperoumal.timemanager.task.time.Time;

/**
 * Created by r.peroumal on 22/11/2017.
 */

public interface TaskAction {
    String getTitle();
    Time getDuration();
    String getDescription();
    long getPrerequisites();
}
