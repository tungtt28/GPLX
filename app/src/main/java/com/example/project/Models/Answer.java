    package com.example.project.Models;

    import androidx.room.Entity;
    import androidx.room.PrimaryKey;

    @Entity(tableName = "answers")
    public class Answer {
        @PrimaryKey(autoGenerate = true)
        private int id;
        public int questionId;
        private String content;
        private boolean isCorrect;

        public Answer(int questionId, String content, boolean isCorrect) {
            this.questionId = questionId;
            this.content = content;
            this.isCorrect = isCorrect;
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

        public int getQuestionId() {
            return questionId;
        }

        public void setQuestionId(int questionId) {
            this.questionId = questionId;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public boolean isCorrect() {
            return isCorrect;
        }

        public void setCorrect(boolean correct) {
            isCorrect = correct;
        }
    }
