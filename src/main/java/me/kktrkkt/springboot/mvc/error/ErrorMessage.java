package me.kktrkkt.springboot.mvc.error;

public class ErrorMessage {

    private String message;

    private String reason;

    public ErrorMessage() {
    }
    public ErrorMessage(String message, String reason) {
        this.message = message;
        this.reason = reason;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
