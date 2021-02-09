package badcode;

import java.util.Arrays;

public class EmailValidator {
    public static boolean validateEmailDomain(String email) {
        if (email == null || email.isBlank()) {
            return false;
        }

        String[] acceptableDomains = { "gmail.com", "live.com" };
        String[] emailParts = email.split("@");

        // Input doesn't contain @, invalid email format.
        if (emailParts.length < 2) {
            return false;
        }

        String emailDomain = emailParts[1];
        return Arrays.stream(acceptableDomains).filter(it -> it.equals(emailDomain)).count() > 0;
    }
}
