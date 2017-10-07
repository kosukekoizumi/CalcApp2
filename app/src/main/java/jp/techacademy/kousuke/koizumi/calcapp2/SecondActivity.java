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
        double value1 = intent.getDoubleExtra("VALUE1", 0);
        double value2 = intent.getDoubleExtra("VALUE2", 0);
        int value3 = intent.getIntExtra("VALUE3", 0);
        // ↑↑取得したボタンのIDをvalue3に代入しています。

        TextView textView = (TextView) findViewById(R.id.textView);
        if (value3 == 2131427426) {
            textView.setText(String.valueOf(value1 + value2));
        } else if (value3 == 2131427427) {
            textView.setText(String.valueOf(value1 - value2));
        } else if (value3 == 2131427428) {
            textView.setText(String.valueOf(value1 * value2));
        } else if (value3 == 2131427429 && value2 != 0) {
            textView.setText(String.valueOf(value1 / value2));
        } else {
            textView.setText("０で割ることは出来ません！");
            // ↑↑「0では割る」計算をしてしまった場合についての処理です
            // ↑↑ 数字でない文字を入力した場合の処理については力不足で未対応です

        }
    }

}