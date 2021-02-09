package badcode;

public class FeeCalculator {
    public static void calculateFee(Speaker speaker) {
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
}
