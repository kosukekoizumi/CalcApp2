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
    }

    @Override
    public void onClick(View v) {
        double firstNumber = Double.parseDouble(((EditText) findViewById(R.id.editText1)).getText().toString());
        double secondNumber = Double.parseDouble(((EditText) findViewById(R.id.editText2)).getText().toString());
        int buttonId = v.getId();    //★四則演算のどのキーが押されたかの判断（キーのID取得）
        double result1 = 0;    //★計算結果
        boolean flag1 = true;    //★０で割ろうとしていないかのチェック

        if (buttonId == R.id.button1) {
            result1 = (firstNumber + secondNumber);
        } else if (buttonId == R.id.button2) {
            result1 = firstNumber - secondNumber;
        } else if (buttonId == R.id.button3) {
            result1 = firstNumber * secondNumber;
        } else if (buttonId == R.id.button4 && secondNumber != 0) {
            result1 = firstNumber / secondNumber;
        } else {
            flag1 = false;
        }

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("VALUE1",result1);
        intent.putExtra("VALUE2",flag1);

        startActivity(intent);
    }

}
