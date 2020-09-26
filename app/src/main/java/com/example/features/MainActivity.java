package com.example.features;

import androidx.appcompat.app.AppCompatActivity;
import com.example.features.Questions;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView scoreT,qq;
    Button btn1,btn2,btn3,btn4;
    Button confirm,hint;
    String answer,qanswer;
    Questions currentQ;
    Questions[] qArray=Questions.questions;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoreT = (TextView) findViewById(R.id.score);
        qq = (TextView) findViewById(R.id.question_id);
        btn1 = (Button) findViewById(R.id.answ1);
        btn2 = (Button) findViewById(R.id.answ2);
        btn3 = (Button) findViewById(R.id.answ3);
        btn4 = (Button) findViewById(R.id.answ4);
        confirm = (Button) findViewById(R.id.confirm);
        hint = (Button) findViewById(R.id.hint);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        confirm.setOnClickListener(this);
        qanswer = "";

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.answ1:
                qanswer+="1";
                break;
            case R.id.answ2:
                qanswer+="2";
                break;
            case R.id.answ3:
                qanswer+="3";
                break;
            case R.id.answ4:
                qanswer+="4";
                break;
            case R.id.confirm:
                checkAnswer(qanswer);
                qanswer="";
                break;
            case R.id.hint:
                showQuestion();
                break;
        }
    }

    private void checkAnswer(String answer1) {
        this.qanswer = answer1;
        if (Integer.parseInt(answer1) == currentQ.getAnswer())
            Toast.makeText(getApplicationContext(), "Hooray", Toast.LENGTH_SHORT).show();
    }

    private void showQuestion(){
        currentQ = qArray[i];
        i++;
        qq.setText(currentQ.getQuestion());
        btn1.setText(currentQ.getO1());
        btn2.setText(currentQ.getO2());
        btn3.setText(currentQ.getO3());
        btn4.setText(currentQ.getO4());

    }
}