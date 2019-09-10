package com.example.calculator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button jump;
    private EditText firstNumber;
    private EditText secondNumber;
    private TextView result;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

                Integer res=data.getIntExtra("ANSWER",0);
                result.setText(res.toString());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jump = findViewById(R.id.b_jump);
        firstNumber = findViewById(R.id.et_first);
        secondNumber = findViewById(R.id.et_second);
        result = findViewById(R.id.tv_result);
        View.OnClickListener clickListener1 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("first", Integer.valueOf(firstNumber.getText().toString()));
                intent.putExtra("second", Integer.valueOf(secondNumber.getText().toString()));
                startActivityForResult(intent, 1);

            }
        };


        jump.setOnClickListener(clickListener1);
    }
}
