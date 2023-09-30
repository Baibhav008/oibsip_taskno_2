package com.example.gkquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    int score = 0;
    int questionIndex = 0;
    int optionIndex = 0;
    int answerIndex = 0;




    TextView question,opA,opB,opC,opD,scoreText,timerText,ansStatus,finishScreen;

    Button PlayAgain;
    List<String> questions = new ArrayList<>();
    List<String> answers = new ArrayList<>();

    List<String> options = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        question=findViewById(R.id.question);
        opA=findViewById(R.id.optionA);
        opB=findViewById(R.id.optionB);
        opC=findViewById(R.id.optionC);
        opD = findViewById(R.id.optionD);
        timerText=findViewById(R.id.timertextView);
        scoreText=findViewById(R.id.scoretextView);
        PlayAgain=findViewById(R.id.playAgain);
        ansStatus=findViewById(R.id.answer);
        finishScreen=findViewById(R.id.finishScreen);

        PlayAgain.setVisibility(View.INVISIBLE);
        finishScreen.setVisibility(View.INVISIBLE);












        questions.add("Which is the biggest state of India ?");
        options.add("Maharashtra");
        options.add("Rajasthan");
        options.add("Gujarat");
        options.add("Uttrakhand");
                 answers.add("B. Rajasthan");


        questions.add("Which planet is nearest to Earth ?");
        options.add("Mercury");
        options.add("Venus");
        options.add("Mars");
        options.add("Jupiter");             answers.add("A. Mercury");



        questions.add("What is the national animal of India?");
        options.add("Wolf");
        options.add("Lion");
        options.add("Cheetah");
        options.add("Tiger");               answers.add("D. Tiger");



        questions.add("Which is the longest river in India?");
        options.add("Ganga");
        options.add("Yamuna");
        options.add("Godavari");
        options.add("Kaveri");              answers.add("A. Ganga");





        questions.add("Which mountain range is the highest in India?");
        options.add("Karakoram");
        options.add("Himalyan");
        options.add("Purvanchal");
        options.add("Aravalli");            answers.add("B. Himalyan");


        questions.add("What is the only food that doesn’t spoil?");
        options.add("Honey");
        options.add("Butter");
        options.add("Milk");
        options.add("Rice");                answers.add("A. Honey");



        questions.add("Who invented the electric chair?");
        options.add("Alfred Porter");
        options.add("Thomas Edison");
        options.add("Newton");
        options.add("Elon Musk");           answers.add("A. Alfred Porter");



        questions.add("Which planet is not named after a god?");
        options.add("Mercury");
        options.add("Neptune");
        options.add("Mars");
        options.add("Earth");               answers.add("D. Earth");



        questions.add("Which continent is corn not grown on?");
        options.add("Europe");
        options.add("Asia");
        options.add("Antarctica");
        options.add("Australia");           answers.add("C. Antarctica");


        questions.add("Hitler party which came into power in 1933 is known as?");
        options.add("Labour Party");
        options.add("Nazi Party");
        options.add("Ku-Klux-Klan");
        options.add("Hydra");               answers.add("B. Nazi Party");















        new CountDownTimer(30100,1000)
        {

            @Override
            public void onTick(long millisUntilFinished) {

                timerText.setText(String.valueOf(millisUntilFinished/1000)+"s");



            }

            @Override
            public void onFinish() {

                endTest();





            }
        }.start();

        question.setText(questions.get(0));
        opA.setText("A. Maharashtra");
        opB.setText("B. Rajasthan");
        opC.setText("C. Gujarat");
        opD.setText("D. Uttrakhand");


    }


    // int score = 0;
    // int questionIndex = 0;
    // int optionIndex = 0;
    public void onClick(View view)
    {

        if(questionIndex<=8)
        {
            TextView b = (TextView)view;
            String buttonText = b.getText().toString();
            if(buttonText.equals(answers.get(answerIndex)))
            {
                //Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
                score++;
                scoreText.setText(score+"/10");
                ansStatus.setText("Correct Answer !!!!");

            }
            else {

                ansStatus.setText("Wrong Answer !!!!");
                //Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
            }

            questionIndex++;
            answerIndex++;
            optionIndex=optionIndex+4;

            question.setText(questions.get(questionIndex));
            opA.setText("A. "+options.get(optionIndex));
            opB.setText("B. "+options.get(optionIndex+1));
            opC.setText("C. "+options.get(optionIndex+2));
            opD.setText("D. "+options.get(optionIndex+3));

        }

        else
        {
            TextView b = (TextView)view;
            String buttonText = b.getText().toString();
            if(buttonText.equals(answers.get(answerIndex)))
            {
                //Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
                score++;
                scoreText.setText(score+"/10");
                ansStatus.setText("Correct Answer !!!!");
            }
            else {
                //Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
                ansStatus.setText("Wrong Answer !!!!");

            }

            endTest();

        }



    }

    public void endTest()
    {
        opA.setVisibility(View.INVISIBLE);
        opB.setVisibility(View.INVISIBLE);
        opC.setVisibility(View.INVISIBLE);
        opD.setVisibility(View.INVISIBLE);
        question.setVisibility(View.INVISIBLE);

        finishScreen.setVisibility(View.VISIBLE);

        finishScreen.setText("Game Over !!\nYour Score is :\n"+score+"/10");
        ansStatus.setVisibility(View.INVISIBLE);


        PlayAgain.setVisibility(View.VISIBLE);
        PlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,EntryActivity.class);
                startActivity(i);
                finish();
            }
        });

    }

}