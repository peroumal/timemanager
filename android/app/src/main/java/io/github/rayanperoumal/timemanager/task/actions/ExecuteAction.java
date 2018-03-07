package io.github.rayanperoumal.timemanager.task.actions;

import io.github.rayanperoumal.timemanager.task.time.Time;

/**
 * Created by r.peroumal on 22/11/2017.
 */

public class ExecuteAction extends SimpleTaskAction {
    public ExecuteAction() {
        super("Foncez !",new Time(15,0));
    }
}
