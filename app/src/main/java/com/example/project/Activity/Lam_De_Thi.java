package com.example.project.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.project.Database.QuizDao;
import com.example.project.Database.QuizDatabase;
import com.example.project.Models.Answer;
import com.example.project.Models.Question;
import com.example.project.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Lam_De_Thi extends AppCompatActivity {

    private TextView questionText;
    private TextView timerText;
    private RadioGroup answerGroup;
    private RadioButton answer1;
    private RadioButton answer2;
    private RadioButton answer3;
    private RadioButton answer4;
    private Button previousButton;
    private Button nextButton;
    private TextView examCodeText;

    private List<Question> listQuestionEntities = new ArrayList<>();
    private List<Answer> currentAnswers = new ArrayList<>();
    private int currentQuestion = 0;
    private int score = 0;
    private int incorrectAnswers = 0;
    private Map<Integer, Integer> selectedAnswers = new HashMap<>();

    private QuizDao quizDao;

    private CountDownTimer countDownTimer;
    private long timeElapsedMillis = 0;
    private static final long TOTAL_TIME = 20 * 60 * 1000; // 20 minutes in milliseconds

    private void bindingView() {
        questionText = findViewById(R.id.question_text);
        timerText = findViewById(R.id.timer_text);
        examCodeText = findViewById(R.id.examCodeText);
        answerGroup = findViewById(R.id.answer_group);
        previousButton = findViewById(R.id.previous_button);
        nextButton = findViewById(R.id.next_button);
        answer1 = findViewById(R.id.answer_1);
        answer2 = findViewById(R.id.answer_2);
        answer3 = findViewById(R.id.answer_3);
        answer4 = findViewById(R.id.answer_4);
    }

    private void bindingAction() {
        previousButton.setOnClickListener(this::onPreviousButtonClick);
        nextButton.setOnClickListener(this::onNextButtonClick);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lam_de_thi);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        QuizDatabase db = QuizDatabase.getInstance(getApplicationContext());
        quizDao = db.quizDao();
        Intent intent = getIntent();
        String examCode = intent.getStringExtra("examCode");
//            if (examCode != null) {
//                // Use the examCode as needed
//                Log.d("Khanhdn", "Received examCode: " + examCode);
//            } else {
//                Log.d("Khanhdn", "examCode is null");
//            }


        // Thêm dữ liệu vào cơ sở dữ liệu
//        QuizDatabase.populateInitialData(db);
//
        //Xóa tất cả các dữ liệu trong cơ sở dữ liệu
//        db.clearAllTables();

        bindingView();
        bindingAction();
        loadQuestionsFromDatabase(examCode);
        examCodeText.setText(examCode);
        startTimer();
    }

    private void startTimer() {
        countDownTimer = new CountDownTimer(TOTAL_TIME,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeElapsedMillis = TOTAL_TIME - millisUntilFinished;
                String timeFormatted = String.format("%02d:%02d",
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));
                timerText.setText(timeFormatted);
            }

            @Override
            public void onFinish() {
                timeElapsedMillis = TOTAL_TIME;
                onSubmitButtonClick(null);
            }
        }.start();
    }


    //    private void loadQuestionsFromDatabase() {
//        List<Question> questions = quizDao.getAllQuestions();
//        listQuestionEntities.clear();
//        listQuestionEntities.addAll(questions);
//        if (!listQuestionEntities.isEmpty()) {
//            loadAnswersForCurrentQuestion();
//        }
//    }
    private void loadQuestionsFromDatabase(String examCode) {
        switch (examCode) {
            case "Đề 1":
                // Load questions for exam code 1 from database
                listQuestionEntities.clear();
                listQuestionEntities.addAll(quizDao.getQuestionsByExamCode("Đề 1"));
                break;
            case "Đề 2":
                // Load questions for exam code 2 from database
                listQuestionEntities.clear();
                listQuestionEntities.addAll(quizDao.getQuestionsByExamCode("Đề 2"));
                break;
            default:
                break;
        }

        // Display the first question
        currentQuestion = 0;
        loadAnswersForCurrentQuestion();
    }


    private void loadAnswersForCurrentQuestion() {
        if (listQuestionEntities.isEmpty() || currentQuestion >= listQuestionEntities.size()) return;

        Question currentQuestionEntity = listQuestionEntities.get(currentQuestion);
        List<Answer> answerEntities = quizDao.getAnswersForQuestion(currentQuestionEntity.getId());
        currentAnswers.clear();
        currentAnswers.addAll(answerEntities);
        setDataForCurrentQuestion();
    }

    private void setDataForCurrentQuestion() {
        if (listQuestionEntities.isEmpty()) return;

        Question currentQuestionEntity = listQuestionEntities.get(currentQuestion);
        questionText.setText("Câu " + currentQuestionEntity.getNumber() + ": " + currentQuestionEntity.getContent());

        if (currentAnswers.size() >= 4) {
            answer1.setText(currentAnswers.get(0).getContent());
            answer2.setText(currentAnswers.get(1).getContent());
            answer3.setText(currentAnswers.get(2).getContent());
            answer4.setText(currentAnswers.get(3).getContent());

            if (selectedAnswers.containsKey(currentQuestion)) {
                int selectedAnswerIndex = selectedAnswers.get(currentQuestion);
                switch (selectedAnswerIndex) {
                    case 0:
                        answer1.setChecked(true);
                        break;
                    case 1:
                        answer2.setChecked(true);
                        break;
                    case 2:
                        answer3.setChecked(true);
                        break;
                    case 3:
                        answer4.setChecked(true);
                        break;
                }
            } else {
                answerGroup.clearCheck();
            }
        }
    }

    private void saveSelectedAnswer() {
        int selectedAnswerId = answerGroup.getCheckedRadioButtonId();
        if (selectedAnswerId == -1) return;

        int selectedAnswerIndex = -1;
        if (selectedAnswerId == R.id.answer_1) {
            selectedAnswerIndex = 0;
        } else if (selectedAnswerId == R.id.answer_2) {
            selectedAnswerIndex = 1;
        } else if (selectedAnswerId == R.id.answer_3) {
            selectedAnswerIndex = 2;
        } else if (selectedAnswerId == R.id.answer_4) {
            selectedAnswerIndex = 3;
        }
        if (selectedAnswerIndex != -1) {
            selectedAnswers.put(currentQuestion, selectedAnswerIndex);
        }
    }

    private void calculateScore() {
        score = 0;
        incorrectAnswers = 0;
        for (int i = 0; i < 19; i++) {
            Question question = listQuestionEntities.get(i);
            if (selectedAnswers.containsKey(i)) {
                int selectedAnswerIndex = selectedAnswers.get(i);

                // Lấy danh sách câu trả lời cho câu hỏi hiện tại từ cơ sở dữ liệu
                List<Answer> answers = quizDao.getAnswersForQuestion(question.getId());

                // Kiểm tra xem selectedAnswerIndex có hợp lệ không
                if (selectedAnswerIndex >= 0 && selectedAnswerIndex < answers.size()) {
                    Answer selectedAnswer = answers.get(selectedAnswerIndex);
                    if (selectedAnswer.isCorrect()) {
                        score++;
                    } else {
                        incorrectAnswers++;
                    }
                }
            }
        }
    }

    public void onSubmitButtonClick(View view) {
        // Tạo dialog thông báo
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông báo")
                .setMessage("Bạn có muốn kết thúc bài thi không?")
                .setCancelable(false)
                .setPositiveButton("Kết Thúc", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Xử lý khi người dùng đồng ý kết thúc bài thi
                        saveSelectedAnswer();
                        calculateScore();
                        Intent intent = new Intent(Lam_De_Thi.this, ResultActivity.class);
                        intent.putExtra("score", score);
                        intent.putExtra("incorrectAnswers", incorrectAnswers);
                        intent.putExtra("timeElapsed", timeElapsedMillis);
                        startActivity(intent);
                        finish();
                    }
                })
                .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Đóng dialog và không làm gì thêm
                        dialog.cancel();
                    }
                });
        // Tạo và hiển thị dialog
        AlertDialog alert = builder.create();
        alert.show();
    }


    private void onNextButtonClick(View view) {
        saveSelectedAnswer();
        if (currentQuestion < 19) {
            currentQuestion++;
            loadAnswersForCurrentQuestion();
        }
    }

    private void onPreviousButtonClick(View view) {
        saveSelectedAnswer();
        if (currentQuestion > 0) {
            currentQuestion--;
            loadAnswersForCurrentQuestion();
        }
    }

    @Override
    public void onBackPressed() {
        // Tạo dialog thông báo
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông báo")
                .setMessage("Bạn có muốn kết thúc bài thi không?")
                .setCancelable(false)
                .setPositiveButton("Kết Thúc", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Xử lý khi người dùng đồng ý kết thúc bài thi
                        saveSelectedAnswer();
                        calculateScore();
                        Intent intent = new Intent(Lam_De_Thi.this, ResultActivity.class);
                        intent.putExtra("score", score);
                        intent.putExtra("incorrectAnswers", incorrectAnswers);
                        intent.putExtra("timeElapsed", timeElapsedMillis);
                        startActivity(intent);
                        finish();
                    }
                })
                .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Đóng dialog và không làm gì thêm
                        dialog.cancel();
                    }
                });
        // Tạo và hiển thị dialog
        AlertDialog alert = builder.create();
        alert.show();
    }
}