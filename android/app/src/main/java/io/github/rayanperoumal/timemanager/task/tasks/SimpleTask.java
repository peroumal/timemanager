package io.github.rayanperoumal.timemanager.task.tasks;

import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import io.github.rayanperoumal.timemanager.task.time.Time;
import io.github.rayanperoumal.timemanager.task.time.Timer;
import io.github.rayanperoumal.timemanager.task.OnTaskChangeListener;
import io.github.rayanperoumal.timemanager.task.Task;
import io.github.rayanperoumal.timemanager.task.TaskAction;

/**
 * @author Rayan Peroumal
 */

public class SimpleTask implements Task, Serializable{
    private int position=-1;
    protected Timer timer;
    protected List<TaskAction> actions;
    private OnTaskChangeListener taskChangeListener;


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
        TaskAction action = null;
        long t = (position>-1) ? this.timer.getTime().getTime() : 0;

        Log.i("SimpleTask","t:{"+t+"}");

        if((actions.size()-1)>position){
            action = actions.get(++position);
            if(taskChangeListener!=null)taskChangeListener.onTaskChange(OnTaskChangeListener.TaskChange.nextActionCalled);
            timer.setTime(new Time(t+getAction().getDuration().getTime()));
        }

        else
            if(taskChangeListener!=null)taskChangeListener.onTaskChange(OnTaskChangeListener.TaskChange.noActionAvailable);

        return action;
    }

    public void setOnTaskChangeListener(OnTaskChangeListener listener){
        this.taskChangeListener = listener;
    }
    @Override
    public void addAction(TaskAction taskAction) {
        actions.add(taskAction);
    }
}
