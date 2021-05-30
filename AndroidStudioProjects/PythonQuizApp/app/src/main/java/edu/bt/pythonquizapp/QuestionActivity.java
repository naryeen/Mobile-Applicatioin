package edu.bt.pythonquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.graphics.Color.RED;
import static java.lang.String.*;

public class QuestionActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView question, qCount;
    private TextView timer;
    private Button option1, option2, option3, option4;
    private List<Question> questionList;
    private int quesNum;
    private int score;

    private CountDownTimer countDown;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        question = findViewById(R.id.question);
        qCount = findViewById(R.id.qCount);
        timer = findViewById(R.id.timerQues);

        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);

        option1.setOnClickListener(this);
        option2.setOnClickListener(this);
        option3.setOnClickListener(this);
        option4.setOnClickListener(this);

        getQuestionsList();

        score = 0;
    }


    public void getQuestionsList() {
        questionList = new ArrayList<>();
        questionList.add(new Question("Question 1", "A", "B", "C", "D", 2));
        questionList.add(new Question("Question 2", "A", "B", "C", "D", 1));
        questionList.add(new Question("Question 3", "B", "A", "C", "D", 1));
        questionList.add(new Question("Question 4", "A", "B", "C", "D", 1));
        questionList.add(new Question("Question 5", "A", "B", "C", "D", 1));
        questionList.add(new Question("Question 6", "A", "B", "C", "D", 1));


        setQuestion();
    }

    public void setQuestion() {
        timer.setText(String.valueOf(6));
        question.setText(questionList.get(0).getQuestion());
        option1.setText(questionList.get(0).getOptionA());
        option2.setText(questionList.get(0).getOptionB());
        option3.setText(questionList.get(0).getOptionC());
        option4.setText(questionList.get(0).getOptionD());

        qCount.setText(String.valueOf(1) + "/" + String.valueOf(questionList.size()));
        startTimer();
        quesNum = 0;
    }

    //this part is for timer..
    private void startTimer() {
        countDown = new CountDownTimer(12000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (millisUntilFinished < 10000) {
                    timer.setText(valueOf(millisUntilFinished / 1000));
                }
            }

            @Override
            public void onFinish() {
                //when timer reached to zero
                changeQuestion();
            }
        };
        countDown.start();
    }

    @Override
    public void onClick(View v) {
        int selectedOption = 0;
        switch (v.getId()) {
            case R.id.option1:
                selectedOption = 1;
                break;
            case R.id.option2:
                selectedOption = 2;
                break;
            case R.id.option3:
                selectedOption = 3;
                break;
            case R.id.option4:
                selectedOption = 4;
                break;
            default:
        }
        countDown.cancel();
        checkAnswer(selectedOption, v);
    }

    private void checkAnswer(int selectedOption, View view) {
        if (selectedOption == questionList.get(quesNum).getCorrectAns()) {
            //right answer
            System.out.println("This is right answer");
//            ((Button) view).setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
            ((Button) view).setBackground(new ColorDrawable(Color.GREEN));
            score++;
        } else {
            //wrong
            ((Button) view).setBackgroundTintList(ColorStateList.valueOf(RED));
            System.out.println("This is wrong  answer");

            switch (questionList.get(quesNum).getCorrectAns()) {
                case 1:
                    option1.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    break;
                case 2:
                    option2.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    break;
                case 3:
                    option3.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    break;
                case 4:
                    option4.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    break;
            }
        }
        //It will wait for 2 second and then it will change to another questions.
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                changeQuestion();
            }
        }, 2000);


    }

    private void changeQuestion() {
        if (quesNum < questionList.size() - 1) {
            quesNum++;
            //create animation to change the question
            playAnim(question, 0, 0);
            playAnim(option1, 0, 1);
            playAnim(option2, 0, 2);
            playAnim(option3, 0, 3);
            playAnim(option4, 0, 4);

            //update questions
            qCount.setText(String.valueOf(quesNum + 1) + "/" + String.valueOf(questionList.size()));
            timer.setText(String.valueOf(10));
            startTimer();
        } else {

            //go to score activity
            Intent intent = new Intent(QuestionActivity.this, ScoreActivity.class);
            intent.putExtra("SCORE", String.valueOf(score) + "/" + String.valueOf(questionList.size()));
            //pasing the flag intent to clear all the previous activity
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            //QuestionActivity.this.finish();
        }
    }

    //button shrink to 0 and again it expand back
    private void playAnim(View view, final int value, int viewNum) {
        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500)
                .setStartDelay(100).setInterpolator(new DecelerateInterpolator())
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        //
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        if (value == 0) {
                            //change the value,
                            switch (viewNum) {
                                case 0:
                                    ((TextView) view).setText(questionList.get(quesNum).getQuestion());
                                    break;
                                case 1:
                                    ((Button) view).setText(questionList.get(quesNum).getOptionA());
                                    break;
                                case 2:
                                    ((Button) view).setText(questionList.get(quesNum).getOptionB());
                                    break;
                                case 3:
                                    ((Button) view).setText(questionList.get(quesNum).getOptionC());
                                    break;
                                case 4:
                                    ((Button) view).setText(questionList.get(quesNum).getOptionD());
                                    break;

                            }
                            //changing colors of the buttons
                            if (viewNum != 0) {
                                view.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#D81B60")));
                            }

                            playAnim(view, 1, viewNum);
                        }
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
    }
//time is stil running in background so need to cancel the time , even after finishing the activity
    //this happens when user click back button, time get cancelled.
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        countDown.cancel();
    }
}