package com.example.project.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.project.R;

import java.util.concurrent.TimeUnit;

public class ResultActivity extends AppCompatActivity {
    private TextView resultText;
    private TextView finalResult;
    private TextView incorrectAnswersText;
    private TextView unansweredQuestionsText;
    private TextView timeElapsedText;
    private Button btnBack;
    private long timeElapsed = 0;

    private int score;
    private int totalQuestions;
    private int incorrectAnswers;
    private int unansweredQuestions;

    private void bindingView(){
        finalResult = findViewById(R.id.final_result);
        resultText = findViewById(R.id.result_text);
        incorrectAnswersText = findViewById(R.id.incorrect_answers_text);
        unansweredQuestionsText = findViewById(R.id.unanswered_questions_text);
        timeElapsedText = findViewById(R.id.time_elapsed_text);
        btnBack = findViewById(R.id.btnBack);
    }
    private void bindingAction(){
        int passingScore = 15;
        resultText.setText("Điểm: " + score + "/" + 20);
        if (score >= passingScore) {
            finalResult.setText("Đạt");
            finalResult.setTextColor(Color.GREEN);
        } else {
            finalResult.setText("Không Đạt");
            finalResult.setTextColor(Color.RED);
        }
        incorrectAnswersText.setText("Số câu trả lời sai: " + incorrectAnswers);
        unansweredQuestionsText.setText("Số câu chưa trả lời: " + (20-score-incorrectAnswers));
        String formattedTime = formatTime(timeElapsed);
        timeElapsedText.setText("Thời gian đã dùng: " + formattedTime);

        btnBack.setOnClickListener(this::onBtnBackClick);
    }

    private void onBtnBackClick(View view) {
        Intent intent = new Intent(ResultActivity.this, SelectExamCodeActivity.class);
        startActivity(intent);
        finish();
    }

    private String formatTime(long millis) {
        return String.format("%02d:%02d",
                TimeUnit.MILLISECONDS.toMinutes(millis),
                TimeUnit.MILLISECONDS.toSeconds(millis) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        score = getIntent().getIntExtra("score", 0);
        totalQuestions = getIntent().getIntExtra("totalQuestions", 0);
        incorrectAnswers = getIntent().getIntExtra("incorrectAnswers", 0);
        unansweredQuestions = getIntent().getIntExtra("unansweredQuestions", 0);
        timeElapsed = getIntent().getLongExtra("timeElapsed",0);



        bindingView();
        bindingAction();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(ResultActivity.this, SelectExamCodeActivity.class);
        startActivity(intent);
        finish(); // Finish the current activity to prevent returning to it
    }
}