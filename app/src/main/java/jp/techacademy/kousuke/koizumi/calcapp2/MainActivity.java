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
        int buttonId = v.getId();    //☆四則演算のどのキーが押されたかの判断（キーのID取得）
        boolean flagNull1 = true;    //★入力がされているかのチェック用フラグ
        boolean flagZero1 = true;    //☆０で割ろうとしているかのチェック用フラグ
        double firstNumber = 0;
        double secondNumber = 0;
        double result1 = 0;    //☆計算結果

        if (((EditText) findViewById(R.id.editText1)).getText().toString().length() == 0
                || ((EditText) findViewById(R.id.editText2)).getText().toString().length() == 0 ) {
            flagNull1 = false;  //★↑↑firstとsecondを同時に処理しようとしたら条件文が2行に…（別々にした方がいいですか？）
        } else {
            firstNumber = Double.parseDouble(((EditText) findViewById(R.id.editText1)).getText().toString());
            secondNumber = Double.parseDouble(((EditText) findViewById(R.id.editText2)).getText().toString());
        }

        if (buttonId == R.id.button1) {
            result1 = (firstNumber + secondNumber);
        } else if (buttonId == R.id.button2) {
            result1 = firstNumber - secondNumber;
        } else if (buttonId == R.id.button3) {
            result1 = firstNumber * secondNumber;
        } else if (buttonId == R.id.button4 && secondNumber != 0) {
            result1 = firstNumber / secondNumber;
        } else {
            flagZero1 = false;
        }

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("VALUE1",result1);
        intent.putExtra("VALUE2",flagNull1);
        intent.putExtra("VALUE3",flagZero1);

        startActivity(intent);
    }

}
