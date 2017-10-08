package jp.techacademy.kousuke.koizumi.calcapp2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import static jp.techacademy.kousuke.koizumi.calcapp2.R.id.button1;
import static jp.techacademy.kousuke.koizumi.calcapp2.R.id.button2;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        double result2 = intent.getDoubleExtra("VALUE1", 0);
        boolean flag2 = intent.getBooleanExtra("VALUE2", true);

        TextView textView = (TextView) findViewById(R.id.textView);
        if (flag2 == false) {
            textView.setText("０で割ることは出来ません！");
        } else {
            textView.setText(String.valueOf(result2));
        }
    }

}