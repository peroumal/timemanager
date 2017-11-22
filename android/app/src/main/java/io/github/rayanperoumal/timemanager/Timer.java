package io.github.rayanperoumal.timemanager;

import android.util.Log;

/**
 * Created by r.peroumal on 15/11/2017.
 */

public class Timer{
    private long startTime=0 , endTime=0, minute, second;
    TimeListener timeListener = null;
    ElapsingTask task;

    public Timer(){
        task = new ElapsingTask((task)->{
            if(second>0)second--;
            else{
                second=59;
                minute--;
            }
            long time = this.second+60*this.minute;
            Log.i("SecondElapsedListener","time="+time);
            timeListener.onTimeChange(second,minute);
            if(time==0) task.runnable = false;
            return true;
        });
    }

    public void stop(){
        task.setRunnable(false);
    }

    public void setOnTimeListener(TimeListener listener){
        timeListener = listener;
    }

    public void elapse(long m, long s){
        this.second = s;
        this.minute = m;

        task.start();

    }


    public interface TimeListener{
        public void onTimeChange(long minute, long second);
    }

}
