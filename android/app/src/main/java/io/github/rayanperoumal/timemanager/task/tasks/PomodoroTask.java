package io.github.rayanperoumal.timemanager.task.tasks;

import java.util.ArrayList;

import io.github.rayanperoumal.timemanager.task.time.Timer;
import io.github.rayanperoumal.timemanager.task.TaskAction;
import io.github.rayanperoumal.timemanager.task.actions.ExecuteAction;
import io.github.rayanperoumal.timemanager.task.actions.FinishAction;
import io.github.rayanperoumal.timemanager.task.actions.PrepareAction;

/**
 * Created by r.peroumal on 22/11/2017.
 */

public class PomodoroTask extends SimpleTask {

    private TaskAction prepareAction;
    private TaskAction finishAction;

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

    public PomodoroTask(Timer timer){
        super(timer);
        prepareAction = new PrepareAction();
        executeAction = new ExecuteAction();
        finishAction = new FinishAction();
        actions = new ArrayList<TaskAction>(){
            {
                add(prepareAction);
                add(executeAction);
                add(finishAction);
            }
        };
    }



}
