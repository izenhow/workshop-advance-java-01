package badcode;


import java.util.Arrays;

public class RegisterBusiness {

    public Integer register(SpeakerRepository repository, Speaker speaker) {
        Integer speakerId = 0;

        SpeakerValidationResult validationResult = validateSpeaker(speaker);
        if (validationResult.isPass()) {
            if (validateEmailDomain(speaker.getEmail())) {
                calculateFee(speaker);
                try {
                    speakerId = repository.saveSpeaker(speaker);
                }catch (Exception exception) {
                    throw new SaveSpeakerException("Can't save a speaker.");
                }
            } else {
                throw new SpeakerDoesntMeetRequirementsException("Speaker doesn't meet our standard rules.");
            }
        } else {
            throw new ArgumentNullException(validationResult.getMessage());
        }

        return speakerId;
    }

    private void calculateFee(Speaker speaker) {
        int exp = speaker.getExp();
        int fee = 0;
        if (exp <= 1) {
            fee = 500;
        } else if (exp <= 3) {
            fee = 250;
        } else if (exp <= 5) {
            fee = 100;
        } else if (exp <= 9) {
            fee = 50;
        }
        speaker.setRegistrationFee(fee);
    }

    private boolean validateEmailDomain(String email) {
        String[] acceptableDomains = {"gmail.com", "live.com"};
        String[] emailParts = email.split("@");

        // Input doesn't contain @, invalid email format.
        if (emailParts.length < 2) {
            return false;
        }

        String emailDomain = emailParts[1];
        return Arrays.stream(acceptableDomains).filter(it -> it.equals(emailDomain)).count() > 0;
    }

    private SpeakerValidationResult validateSpeaker(Speaker speaker) {
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
