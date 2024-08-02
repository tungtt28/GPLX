    package com.example.project.Models;

    public class ExamCode {
        private Integer image;
        private String code;

        public ExamCode(Integer image, String code) {
            this.image = image;
            this.code = code;
        }
        public Integer getImage() {
            return image;
        }
        public void setImage(Integer image) {
            this.image = image;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }
