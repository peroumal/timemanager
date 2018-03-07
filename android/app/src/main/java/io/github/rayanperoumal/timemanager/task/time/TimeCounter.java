package io.github.rayanperoumal.timemanager.task.time;


/**
 * Created by r.peroumal on 15/11/2017.
 */

public class TimeCounter extends Thread {
    SecondElapsedListener secondElapsedListener;

    public boolean isRunnable() {
        return runnable;
    }

    public void setRunnable(boolean runnable) {
        this.runnable = runnable;
    }

    boolean runnable=false;

    public interface SecondElapsedListener{
        public boolean onSecondElapsed(TimeCounter task);
    }

    public TimeCounter(SecondElapsedListener listener){
        this.secondElapsedListener = listener;
        this.runnable=true;
    }


    @Override
    public void run() {
        long currentTime = System.currentTimeMillis();
        long i=0;
        try {
            while(runnable) {
                long t = ++i*1000 + currentTime;
                Thread.sleep(t - System.currentTimeMillis());
                new Thread((Runnable) () -> secondElapsedListener.onSecondElapsed(TimeCounter.this)).start();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
