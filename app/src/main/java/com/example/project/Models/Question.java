package com.example.project.Models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "questions")
public class Question {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String content;
    private int number;
    private String examCode;

    public Question(String content, int number, String examCode) {
        this.content = content;
        this.number = number;
        this.examCode = examCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    public String getExamCode() {
        return examCode;
    }
    public void setExamCode(String examCode) {
        this.examCode = examCode;
    }

}
