package io.github.rayanperoumal.timemanager.task;

import java.util.ArrayList;

import io.github.rayanperoumal.timemanager.task.actions.ExecuteAction;
import io.github.rayanperoumal.timemanager.task.actions.PrepareAction;

/**
 * Created by r.peroumal on 22/11/2017.
 */

public class PomodoroTask extends SimpleTask {


    private TaskAction prepareAction;

    public TaskAction getExecuteAction() {
        return executeAction;
    }

    public void setExecuteAction(TaskAction executeAction) {
        this.executeAction = executeAction;
    }

    private TaskAction executeAction;
    public TaskAction getPrepareAction() {
        return prepareAction;
    }

    public void setPrepareAction(TaskAction prepareAction) {
        this.prepareAction = prepareAction;
    }

    public PomodoroTask(){
        prepareAction = new PrepareAction();
        executeAction = new ExecuteAction();
        actions = new ArrayList<TaskAction>(){
            {
                add(prepareAction);
                add(executeAction);
            }
        };
    }

}
