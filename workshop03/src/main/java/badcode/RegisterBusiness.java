package badcode;


import java.util.Arrays;

public class RegisterBusiness {

    public Integer register(SpeakerRepository repository, Speaker speaker) {
        Integer speakerId = 0;

        SpeakerValidationResult validationResult = SpeakerValidator.validateSpeaker(speaker);
        if (validationResult.isPass()) {
            if (validateEmailDomain(speaker.getEmail())) {
                FeeCalculator.calculateFee(speaker);
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

}
