package io.github.rayanperoumal.timemanager.task;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import io.github.rayanperoumal.timemanager.Time;
import io.github.rayanperoumal.timemanager.task.actions.FinishAction;
import io.github.rayanperoumal.timemanager.task.actions.PrepareAction;

/**
 * @author Rayan Peroumal
 */

public class SimpleTask implements Task, Serializable{
    private int position=-1;
    protected List<TaskAction> actions;


    public SimpleTask(){
        actions = new ArrayList<TaskAction>();
    }

    public TaskAction getAction() {
        return actions.get(position);
    }

    public void setActions(List<TaskAction> actions) {
        position=0;
        this.actions = actions;
    }

    @Override
    public TaskAction next() {
        TaskAction action = new FinishAction();
        Time addMoreTime = new Time(0);
        if (position>-1 && getAction()!=null) addMoreTime = getAction().getDuration();
        if((actions.size()-1)>position)action = actions.get(++position);
        action.getDuration().addTime(addMoreTime);
        return action;
    }

    @Override
    public void addAction(TaskAction taskAction) {
        actions.add(taskAction);
    }
}
