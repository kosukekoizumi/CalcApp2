package jp.techacademy.kousuke.koizumi.calcapp2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);
        // ↑↑ 似たような構文が4つ並びますがよりスマートな処理の仕方はありますでしょうか？
    }

    @Override
    public void onClick(View v) {
        double firstNumber = Double.parseDouble(((EditText) findViewById(R.id.editText1)).getText().toString());
        double secondNumber = Double.parseDouble(((EditText) findViewById(R.id.editText2)).getText().toString());
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("VALUE1", firstNumber);
        intent.putExtra("VALUE2", secondNumber);

        int buttonId = v.getId();
        intent.putExtra("VALUE3", buttonId);//★
        // ↑↑ 「＋－×÷」のどのボタンを押したをどう判定すれば良いのか悩みました。
        // ↑↑ とりあえずボタンのIDを取得するという方法で切り抜けましたが…。

        startActivity(intent);
    }

}
