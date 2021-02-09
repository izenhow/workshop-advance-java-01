package badcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SpeakerValidatorTest {
    @ParameterizedTest
    @CsvSource({
        "first, last, email, true, null",
        ", last, email, false, First name is required.",
        ", , email, false, First name is required.",
        "first, , email, false, Last name is required.",
        "first, , , false, Last name is required.",
        "first, last, , false, Email is required.",
    })
    public void valdiate_speaker(String firstName, String lastName, String email, String isPass, String errMessage) {
        Speaker speaker = setupSpeaker(firstName, lastName, email);
        SpeakerValidationResult expected = setupValidationResult(isPass, errMessage);

        assertEquals(expected, SpeakerValidator.validateSpeaker(speaker));
    }

    private Speaker setupSpeaker(String firstName, String lastName, String email) {
        Speaker speaker = new Speaker();
        speaker.setFirstName(firstName);
        speaker.setLastName(lastName);
        speaker.setEmail(email);
        return speaker;
    }

    private SpeakerValidationResult setupValidationResult(String isPassString, String errMessage) {
        boolean isPass = Boolean.valueOf(isPassString);
        String message = "null".equalsIgnoreCase(errMessage) ? null : errMessage;
        return new SpeakerValidationResult(isPass, message);
    }
}
