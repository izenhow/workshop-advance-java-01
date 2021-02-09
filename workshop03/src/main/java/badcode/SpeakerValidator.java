package badcode;

public class SpeakerValidator {
    public static SpeakerValidationResult validateSpeaker(Speaker speaker) {
        String message = null;
        if (speaker.getFirstName() == null || speaker.getFirstName().isBlank()) {
            message = "First name is required.";
        } else if (speaker.getLastName() == null || speaker.getLastName().isBlank()) {
            message = "Last name is required.";
        } else if (speaker.getEmail() == null || speaker.getEmail().isBlank()) {
            message = "Email is required.";
        } else {
            return new SpeakerValidationResult(true);
        }
        return new SpeakerValidationResult(false, message);
    }
}
