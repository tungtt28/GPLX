package com.example.project.Database;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.project.Models.Answer;
import com.example.project.Models.Question;

import java.util.List;

public class QuestionAndAnswers {
    @Embedded
    public Question question;
    @Relation(
            parentColumn = "id",
            entityColumn = "questionId"
    )
    public List<Answer> answers;
}
