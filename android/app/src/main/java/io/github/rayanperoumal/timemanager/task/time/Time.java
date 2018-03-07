package io.github.rayanperoumal.timemanager.task.time;

/**
 * Created by r.peroumal on 22/11/2017.
 */

public class Time {
    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public void addTime(long time){
        this.time += time;
    }

    public void addTime(Time time){
        this.time += time.getTime();
    }

    private long time;

    public Time(long time){
       this.time = time;
    }
    public Time(long minute, long second){
        this(second+minute*60);
    }

    public int getSeconds(){
        return (int) (time - ((int)(time/60)) *60);
    }
     public int getMinutes(){
         return (int)(time/60);
     }
}
