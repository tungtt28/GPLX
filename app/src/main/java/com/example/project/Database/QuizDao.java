package com.example.project.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.project.Models.Answer;
import com.example.project.Models.Question;

import java.util.List;
@Dao
public interface QuizDao {
    @Insert
    long insertQuestion(Question question);

    @Insert
    void insertAnswers(List<Answer> answers);

    @Query("SELECT * FROM questions")
    List<Question> getAllQuestions();

    @Query("SELECT * FROM answers WHERE questionId = :questionId")
    List<Answer> getAnswersForQuestion(int questionId);
    // Xóa tất cả các câu trả lời (answers)
    @Query("DELETE FROM answers")
    void deleteAllAnswers();

    // Xóa tất cả các câu hỏi (questions)
    @Query("DELETE FROM questions")
    void deleteAllQuestions();

    // Xóa tất cả dữ liệu trong cơ sở dữ liệu
    @Transaction
    default void deleteAllData() {
        deleteAllAnswers();
        deleteAllQuestions();
    }
    @Query("SELECT * FROM questions WHERE examCode = :examCode")
    List<Question> getQuestionsByExamCode(String examCode);
}

