package com.memorymagic.backend.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"success", "message", "status"})
public class HealthResponse {

    private boolean success;
    private String message;
    private String status;

    public HealthResponse() {
    }

    public HealthResponse(boolean success, String message, String status) {
        this.success = success;
        this.message = message;
        this.status = status;
    }

    public static HealthResponse up(String message) {
        return new HealthResponse(true, message, "UP");
    }

    public static HealthResponse down(String message) {
        return new HealthResponse(false, message, "DOWN");
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
