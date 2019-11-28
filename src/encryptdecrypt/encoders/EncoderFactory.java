package encryptdecrypt.encoders;

public class EncoderFactory {
    public static Encoder getEncoder(String algorithm, int key) {
        if (algorithm.equals("shift")) {
            return new ShiftEncoder(key);
        }

        return new UnicodeEncoder(key);
    }
}
