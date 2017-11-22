package io.github.rayanperoumal.timemanager;

import android.util.Log;

/**
 * Created by r.peroumal on 15/11/2017.
 */

public class Timer{
    private TimeListener timeListener = null;
    private ElapsingTask task;

    public Time getTime() {
        return time;
    }

    private Time time;

    public Timer(Time time){
        this.time = time;
        task = new ElapsingTask((task)->{
            setTime(new Time(this.time.getTime()-1)); // Define new Time
            if(time.getTime()<=0) task.runnable = false; // Stop Changing time
            return true;
        });
    }


    public synchronized void setTime(Time time){
        this.time = time;
        Log.i("SecondElapsedListener","time="+time.getTime());
        timeListener.onTimeChange(time.getMinutes(),time.getSeconds());
    }


    public void stop(){
        task.setRunnable(false);
    }

    public void setOnTimeListener(TimeListener listener){
        timeListener = listener;
    }

    public void elapse(){
        task.start();
    }


    public interface TimeListener{
        public void onTimeChange(long minute, long second);
    }

}
