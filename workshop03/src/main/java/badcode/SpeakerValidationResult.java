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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((message == null) ? 0 : message.hashCode());
        result = prime * result + (status ? 1231 : 1237);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SpeakerValidationResult other = (SpeakerValidationResult) obj;
        if (message == null) {
            if (other.message != null)
                return false;
        } else if (!message.equals(other.message))
            return false;
        if (status != other.status)
            return false;
        return true;
    }
}
