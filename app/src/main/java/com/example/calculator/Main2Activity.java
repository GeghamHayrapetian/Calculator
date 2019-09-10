package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private TextView first;
    private TextView second;
    private Button add;
    private Button sub;
    private Integer numberFirst;
    private Integer numberSecond;
   private Intent intentSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        first = findViewById(R.id.tv_first);
        second = findViewById(R.id.tv_second);
        add = findViewById(R.id.b_add);
        sub = findViewById(R.id.b_sub);
        intentSecond = getIntent();
        numberFirst = getIntent().getIntExtra("first", 0);
        numberSecond = getIntent().getIntExtra("second", 0);

        first.setText("First number :" + numberFirst);
        second.setText("Second number :" + numberSecond);
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.b_add:
                       intentSecond.putExtra("ANSWER", (numberFirst + numberSecond));
                        break;
                    case R.id.b_sub:
                        intentSecond.putExtra("ANSWER", (numberFirst - numberSecond));
                        break;
                        default:
                            break;
                }
                setResult(RESULT_OK,intentSecond);
                finish();


            }
        };
        add.setOnClickListener(clickListener);
        sub.setOnClickListener(clickListener);

    }
}
