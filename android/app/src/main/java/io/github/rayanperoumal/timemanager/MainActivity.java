package io.github.rayanperoumal.timemanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView minute, second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        minute = (TextView) findViewById(R.id.minute);
        second = (TextView) findViewById(R.id.second);
        Timer timer = new Timer(40);
        timer.start();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }


}
