package badcode;

public class SpeakerValidationResult {
    private boolean status;
    private String message;

    public SpeakerValidationResult(boolean status) {
        this.status = status;
    }

    public SpeakerValidationResult(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public boolean isPass() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
