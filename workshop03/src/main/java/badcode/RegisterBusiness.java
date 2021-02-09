package badcode;

public class RegisterBusiness {

    public Integer register(SpeakerRepository repository, Speaker speaker) {
        validateBusiness(speaker);
        FeeCalculator.calculateFee(speaker);
        Integer speakerId = null;
        try {
            speakerId = repository.saveSpeaker(speaker);
        }catch (Exception exception) {
            throw new SaveSpeakerException("Can't save a speaker.");
        }
        return speakerId;
    }

    private void validateBusiness(Speaker speaker) {
        SpeakerValidationResult validationResult = SpeakerValidator.validateSpeaker(speaker);
        if (validationResult.isPass()) {
            if (EmailValidator.validateEmailDomain(speaker.getEmail())) {
                // ...
            } else {
                throw new SpeakerDoesntMeetRequirementsException("Speaker doesn't meet our standard rules.");
            }
        } else {
            throw new ArgumentNullException(validationResult.getMessage());
        }
    }

}
