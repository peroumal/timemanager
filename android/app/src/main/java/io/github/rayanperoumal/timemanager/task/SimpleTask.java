package io.github.rayanperoumal.timemanager.task;

import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import io.github.rayanperoumal.timemanager.Time;
import io.github.rayanperoumal.timemanager.Timer;
import io.github.rayanperoumal.timemanager.task.actions.FinishAction;

/**
 * @author Rayan Peroumal
 */

public class SimpleTask implements Task, Serializable{
    private int position=-1;
    protected Timer timer;
    protected List<TaskAction> actions;


    public SimpleTask(Timer timer){
        this.timer = timer;
        actions = new ArrayList<TaskAction>();
    }

    public void start(){
        timer.elapse();
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
        long t = 0;
        if (position>-1 && getAction()!=null){
            t = this.timer.getTime().getTime();
            Log.i("SimpleTask","t:{"+t+"}");
        }
        if((actions.size()-1)>position)action = actions.get(++position);
        timer.setTime(new Time(t+getAction().getDuration().getTime()));
        return action;
    }

    @Override
    public void addAction(TaskAction taskAction) {
        actions.add(taskAction);
    }
}
