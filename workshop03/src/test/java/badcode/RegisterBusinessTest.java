package badcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RegisterBusinessTest {

    //=============== Failure cases
    @Test
    public void register_with_empty_firstname_should_throw_ArgumentNullException() {
        // Arrange
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker newSpeaker = new Speaker();
        newSpeaker.setFirstName("");

        // Act
        Exception exception = assertThrows(ArgumentNullException.class, () -> {
            registerBusiness.register(null, newSpeaker);
        });

        // Assert
        assertEquals("First name is required.", exception.getMessage());
    }

    @Test
    public void register_with_empty_lastname_should_throw_ArgumentNullException() {
        // Arrange
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker newSpeaker = new Speaker();
        newSpeaker.setFirstName("Demo");
        newSpeaker.setLastName("");

        // Act
        Exception exception = assertThrows(ArgumentNullException.class, () -> {
            registerBusiness.register(null, newSpeaker);
        });

        // Assert
        assertEquals("Last name is required.", exception.getMessage());
    }

    @Test
    public void register_with_empty_email_should_throw_ArgumentNullException() {
        // Arrange
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker newSpeaker = new Speaker();
        newSpeaker.setFirstName("Demo");
        newSpeaker.setLastName("Demo last");
        newSpeaker.setEmail("");

        // Act
        Exception exception = assertThrows(ArgumentNullException.class, () -> {
            registerBusiness.register(null, newSpeaker);
        });

        // Assert
        assertEquals("Email is required.", exception.getMessage());
    }

    @Test
    public void register_with_invalid_domain_of_email_should_throw_SpeakerDoesntMeetRequirementsException() {
        // Arrange
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker newSpeaker = new Speaker();
        newSpeaker.setFirstName("Demo");
        newSpeaker.setLastName("Demo last");
        newSpeaker.setEmail("demo@invalid.com");

        // Act
        Exception exception = assertThrows(SpeakerDoesntMeetRequirementsException.class, () -> {
            registerBusiness.register(null, newSpeaker);
        });

        // Assert
        assertEquals("Speaker doesn't meet our standard rules.", exception.getMessage());
    }

    @Test
    public void register_with_incomplete_email_should_throw_SpeakerDoesntMeetRequirementsException() {
        // Arrange
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker newSpeaker = new Speaker();
        newSpeaker.setFirstName("Demo");
        newSpeaker.setLastName("Demo last");
        newSpeaker.setEmail("testmail");

        // Act
        Exception exception = assertThrows(SpeakerDoesntMeetRequirementsException.class, () -> {
            registerBusiness.register(null, newSpeaker);
        });

        // Assert
        assertEquals("Speaker doesn't meet our standard rules.", exception.getMessage());
    }

    @Test
    public void can_not_save_speaker_throw_SaveSpeakerException() {
        // Arrange
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker newSpeaker = new Speaker();
        newSpeaker.setFirstName("Demo");
        newSpeaker.setLastName("Demo last");
        newSpeaker.setEmail("demo@gmail.com");

        // Act
        Exception exception = assertThrows(SaveSpeakerException.class, () -> {
            registerBusiness.register(null, newSpeaker);
        });

        // Assert
        assertEquals("Can't save a speaker.", exception.getMessage());
    }

    //=============== Success cases

    @Test
    public void register_success() {
        // Arrange
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker newSpeaker = new Speaker();
        newSpeaker.setFirstName("Demo");
        newSpeaker.setLastName("Demo last");
        newSpeaker.setEmail("demo@gmail.com");

        // Stub dependency
        SpeakerRepository stub = prepareStub();

        // Act
        Integer speakerId = registerBusiness.register(stub, newSpeaker);

        // Assert
        assertNotNull(speakerId);
        assertEquals(100, speakerId);
    }

    @Test
    public void register_exp_lq_a_year() {
        // Arrange
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker newSpeaker = new Speaker();
        newSpeaker.setFirstName("Demo");
        newSpeaker.setLastName("Demo last");
        newSpeaker.setEmail("demo@gmail.com");
        newSpeaker.setExp(1);

        // Stub dependency
        SpeakerRepository stub = prepareStub();

        // Act
        registerBusiness.register(stub, newSpeaker);

        int expectedFee = 500;

        // Assert
        assertEquals(expectedFee, newSpeaker.getRegistrationFee());
    }

    @Test
    public void register_exp_2_3_years() {
        // Arrange
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker newSpeaker = new Speaker();
        newSpeaker.setFirstName("Demo");
        newSpeaker.setLastName("Demo last");
        newSpeaker.setEmail("demo@gmail.com");
        newSpeaker.setExp(3);

        // Stub dependency
        SpeakerRepository stub = prepareStub();

        // Act
        registerBusiness.register(stub, newSpeaker);

        int expectedFee = 250;

        // Assert
        assertEquals(expectedFee, newSpeaker.getRegistrationFee());
    }

    @Test
    public void register_exp_4_5_years() {
        // Arrange
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker newSpeaker = new Speaker();
        newSpeaker.setFirstName("Demo");
        newSpeaker.setLastName("Demo last");
        newSpeaker.setEmail("demo@gmail.com");
        newSpeaker.setExp(4);

        // Stub dependency
        SpeakerRepository stub = prepareStub();

        // Act
        registerBusiness.register(stub, newSpeaker);

        int expectedFee = 100;

        // Assert
        assertEquals(expectedFee, newSpeaker.getRegistrationFee());
    }

    @Test
    public void register_exp_6_9_years() {
        // Arrange
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker newSpeaker = new Speaker();
        newSpeaker.setFirstName("Demo");
        newSpeaker.setLastName("Demo last");
        newSpeaker.setEmail("demo@gmail.com");
        newSpeaker.setExp(9);

        // Stub dependency
        SpeakerRepository stub = prepareStub();

        // Act
        registerBusiness.register(stub, newSpeaker);

        int expectedFee = 50;

        // Assert
        assertEquals(expectedFee, newSpeaker.getRegistrationFee());
    }

    @Test
    public void register_exp_gt_9_years() {
        // Arrange
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker newSpeaker = new Speaker();
        newSpeaker.setFirstName("Demo");
        newSpeaker.setLastName("Demo last");
        newSpeaker.setEmail("demo@gmail.com");
        newSpeaker.setExp(10);

        // Stub dependency
        SpeakerRepository stub = prepareStub();

        // Act
        registerBusiness.register(stub, newSpeaker);

        int expectedFee = 0;

        // Assert
        assertEquals(expectedFee, newSpeaker.getRegistrationFee());
    }

    private SpeakerRepository prepareStub() {
        int mockId = 100;
        // Stub dependency
        return new SpeakerRepository() {
            @Override
            public Integer saveSpeaker(Speaker speaker) {
                return mockId;
            }
        };
    }

}