package io.github.rayanperoumal.timemanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView minute, second;

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

    public void startElapsing(int m, int s){
        Timer timer = new Timer();
        timer.setOnTimeListener((min, sec) -> {
           /* runOnUiThread(()->{
                updateTime(sec, min);
            });*/
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
