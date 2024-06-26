//package com.example.accelify.models;
//
//public class Result {
//    private String studentId;
//    private String subject;
//    private int score;
//    private String date;
//
//    // Default constructor required for calls to DataSnapshot.getValue(Result.class)
//    public Result() {
//    }
//
//    public Result(String studentId, String subject, int score, String date) {
//        this.studentId = studentId;
//        this.subject = subject;
//        this.score = score;
//        this.date = date;
//    }
//
//    // Getters and Setters
//    public String getStudentId() {
//        return studentId;
//    }
//
//    public void setStudentId(String studentId) {
//        this.studentId = studentId;
//    }
//
//    public String getSubject() {
//        return subject;
//    }
//
//    public void setSubject(String subject) {
//        this.subject = subject;
//    }
//
//    public int getScore() {
//        return score;
//    }
//
//    public void setScore(int score) {
//        this.score = score;
//    }
//
//    public String getDate() {
//        return date;
//    }
//
//    public void setDate(String date) {
//        this.date = date;
//    }
//}


package com.example.accelify.models;

public class Result {
    private String subject;
    private int score;

    public Result(String subject, int score) {
        this.subject = subject;
        this.score = score;
    }

    public String getSubject() {
        return subject;
    }

    public int getScore() {
        return score;
    }
}
