package io.github.rayanperoumal.timemanager.task.actions;

import io.github.rayanperoumal.timemanager.task.time.Time;

/**
 * Created by r.peroumal on 22/11/2017.
 */

public class PrepareAction extends SimpleTaskAction {
    public PrepareAction(){
        super("Preparez-vous",new Time(5,0));
    }
}
