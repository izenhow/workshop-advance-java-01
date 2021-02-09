package badcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class EmailValidatorTest {
    @ParameterizedTest
    @CsvSource({
        "abc@gmail.com, true",
        "dcb@live.com, true",
        "@live.com, true",
        "xxx@tunanota.com, false",
        ", false",
    })
    public void fee_calculate(String email, boolean isPass) {
        assertEquals(isPass, EmailValidator.validateEmailDomain(email));
    }
}
