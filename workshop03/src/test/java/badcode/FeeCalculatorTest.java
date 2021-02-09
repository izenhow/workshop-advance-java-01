package badcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FeeCalculatorTest {
    @ParameterizedTest
    @CsvSource({
        "0, 500",
        "1, 500",
        "2, 250",
        "3, 250",
        "4, 100",
        "5, 100",
        "6, 50",
        "7, 50",
        "8, 50",
        "9, 50",
        "10, 0",
        "11, 0",
        "50, 0",
        "200, 0",
        "9999, 0",
    })
    public void fee_calculate(int exp, int fee) {
        Speaker newSpeaker = new Speaker();
        newSpeaker.setExp(exp);

        FeeCalculator.calculateFee(newSpeaker);

        assertEquals(fee, newSpeaker.getRegistrationFee());
    }
}
