package io.github.rayanperoumal.timemanager;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView minute, second;
    static Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        minute = (TextView) findViewById(R.id.minute);
        second = (TextView) findViewById(R.id.second);
        startElapsing(25,0);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    public void startElapsing(int m, int s){
        timer.setOnTimeListener((min, sec) -> {
           runOnUiThread(()->{
                updateTime(sec, min);
            });
        });
        timer.elapse(m,s);
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
