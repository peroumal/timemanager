package io.github.rayanperoumal.timemanager;


/**
 * Created by r.peroumal on 15/11/2017.
 */

public class ElapsingTask extends Thread {
    SecondElapsedListener secondElapsedListener;

    public boolean isRunnable() {
        return runnable;
    }

    public void setRunnable(boolean runnable) {
        this.runnable = runnable;
    }

    boolean runnable=false;

    public interface SecondElapsedListener{
        public boolean onSecondElapsed(ElapsingTask task);
    }

    public ElapsingTask(SecondElapsedListener listener){
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
                new Thread((Runnable) () -> secondElapsedListener.onSecondElapsed(ElapsingTask.this)).start();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
