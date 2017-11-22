package io.github.rayanperoumal.timemanager;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import io.github.rayanperoumal.timemanager.task.tasks.PomodoroTask;
import io.github.rayanperoumal.timemanager.task.action.TaskAction;

public class MainActivity extends AppCompatActivity {
    TextView minute, second,actionName;
    Button actionNext;
    TaskAction currentAction;
    PomodoroTask task;
    static Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        minute = (TextView) findViewById(R.id.minute);
        second = (TextView) findViewById(R.id.second);
        actionNext = (Button)findViewById(R.id.next_action);
        actionName = (TextView)findViewById(R.id.action_name);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        timer = new Timer(new Time(500));
        timer.setOnTimeListener((min, sec) -> {
            runOnUiThread(()-> updateTime(min, sec));
        });

        task = new PomodoroTask(timer);
        task.start();

        nextAction();

    }

    public void nextAction(){
        this.currentAction = task.next();
        actionName.setText(this.currentAction.getTitle());
    }

    @Override
    protected void onResume() {
        super.onResume();
        actionNext.setOnClickListener((v)-> nextAction());
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    private void updateTime(long m, long s){
        String secs = Long.toString(s);
        String mins = Long.toString(m);
        secs = (secs.length()<=1)?"0".concat(secs):secs;
        mins = (mins.length()<=1)?"0".concat(mins):mins;
        second.setText(secs);
        minute.setText(mins);
    }
}
