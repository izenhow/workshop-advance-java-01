package badcode;

public class RegisterBusiness {

    public Integer register(SpeakerRepository repository, Speaker speaker) {
        Integer speakerId = 0;

        SpeakerValidationResult validationResult = SpeakerValidator.validateSpeaker(speaker);
        if (validationResult.isPass()) {
            if (EmailValidator.validateEmailDomain(speaker.getEmail())) {
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

}
