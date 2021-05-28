package edu.bt.pythonquizapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.*;

public class QuestionActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView question, qCount, timer;
    private Button option1, option2, option3, option4;
    private List<Question> questionList;
    private int quesNum;
    private CountDownTimer countDownTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        question = findViewById(R.id.question);
        qCount = findViewById(R.id.quest_num);

        timer = findViewById(R.id.timer);

        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);

        option1.setOnClickListener(this);
        option2.setOnClickListener(this);
        option3.setOnClickListener(this);
        option4.setOnClickListener(this);
        getQuestionsList();
    }

    private void getQuestionsList() {
        questionList = new ArrayList<>();
        questionList.add(new Question("Question 1", "A", "B", "C", "D", 2));
        questionList.add(new Question("Question 2", "A", "B", "C", "D", 2));
        questionList.add(new Question("Question 3", "A", "B", "C", "D", 2));
        questionList.add(new Question("Question 4", "A", "B", "C", "D", 2));
        questionList.add(new Question("Question 5", "A", "B", "C", "D", 2));
        questionList.add(new Question("Question 6", "A", "B", "C", "D", 2));
        setQuestion();
    }

    public void setQuestion() {
        timer.setText(valueOf(6));
        question.setText(questionList.get(0).getQuestion());
        option1.setText(questionList.get(0).getOptionA());
        option2.setText(questionList.get(0).getOptionB());
        option3.setText(questionList.get(0).getOptionC());
        option4.setText(questionList.get(0).getOptionD());
        qCount.setText(String.format("1/%d", questionList.size()));
        startTimer();
        quesNum = 0;
    }

    private void startTimer() {
        countDownTimer = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timer.setText(valueOf(millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                changeQuestion();
            }
        };
        countDownTimer.start();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {
        int selected_option = 0;
        switch (v.getId()) {
            case R.id.option1:
                selected_option = 1;
                break;
            case R.id.option2:
                selected_option = 2;
                break;
            case R.id.option3:
                selected_option = 3;
                break;
            case R.id.option4:
                selected_option = 4;
                break;
            default:
        }
        countDownTimer.cancel();
        checkAnswer(selected_option, v);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void checkAnswer(int selected_option, View view) {
        if (selected_option == questionList.get(quesNum).correctAns) {
            //right answer
            ((Button) view).setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
        } else {
            //wrong
            ((Button) view).setBackgroundTintList(ColorStateList.valueOf(Color.RED));
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
        changeQuestion();
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

            qCount.setText(new StringBuilder().append((quesNum + 1)).append("/").append(questionList.size()).toString());
            timer.setText(valueOf(6));
            startTimer();
        } else {
            //go to score activity
            Intent intent = new Intent(QuestionActivity.this, ScoreActivity.class);
            startActivity(intent);
            QuestionActivity.this.finish();
        }
    }

    private void playAnim(View view, final int value, int viewNum) {
        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500)
                .setStartDelay(100).setInterpolator(new DecelerateInterpolator())
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        if (value == 0) {
                            //change the value
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
}