package com.example.restDemo.rest;

public class StudentErrorResponse {
    private int status;
    private String message;
    private long timestamp;

    public  StudentErrorResponse()
    {

    }

    public StudentErrorResponse(String message, int status, long timestamp) {
        this.message = message;
        this.status = status;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
