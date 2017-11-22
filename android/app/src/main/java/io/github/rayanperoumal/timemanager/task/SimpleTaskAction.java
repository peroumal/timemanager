package io.github.rayanperoumal.timemanager.task;

import java.io.Serializable;

import io.github.rayanperoumal.timemanager.Time;


/**
 * Created by r.peroumal on 22/11/2017.
 */

public class SimpleTaskAction implements TaskAction, Serializable{
    private String name;
    private Time time;


    public SimpleTaskAction(String name, Time time){
        this.name = name;
        this.time = time;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(Time time) {
        this.time = time;
    }


    @Override
    public String getTitle() {
        return name;
    }


    @Override
    public Time getDuration() {
        return time;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public long getPrerequisites() {
        return 0;
    }
}
