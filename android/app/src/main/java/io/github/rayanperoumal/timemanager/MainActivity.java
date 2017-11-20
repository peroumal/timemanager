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


    }

    @Override
    protected void onResume() {
        super.onResume();
        Timer timer = new Timer();
        timer.setOnTimeListener((minute, second) -> {
            Log.i("Main:onTimeChange","second:{"+second+"}");
        });

        Log.i("Main:resume","start");
        timer.elapse(20);
        Log.i("Main:resume","end");
    }


}
