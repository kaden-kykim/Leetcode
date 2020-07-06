import java.util.Arrays;

public class PlusOne_66 {

    public int[] plusOne(int[] digits) {
        boolean carrier = false;
        if (++digits[digits.length - 1] == 10) {
            digits[digits.length - 1] = 0;
            carrier = true;
        }
        for (int i = digits.length - 2; i >= 0; --i) {
            if (carrier && ++digits[i] == 10) digits[i] = 0;
            else { carrier = false; break; }
        }
        if (carrier) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            return newDigits;
        } else {
            return digits;
        }
    }

}
