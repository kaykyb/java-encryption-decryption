package encryptdecrypt.encoders;

public class ShiftEncoder extends Encoder {
    private final String LOWERCASE_ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private final String UPPERCASE_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    ShiftEncoder(int key) {
        super(key);
    }

    public String encode(String str) {
        StringBuilder res = new StringBuilder();

        for (char ch: str.toCharArray()) {
            int indexOnLowercaseAlphabet = LOWERCASE_ALPHABET.indexOf(ch);
            int indexOnUppercaseAlphabet = UPPERCASE_ALPHABET.indexOf(ch);

            if (indexOnLowercaseAlphabet > -1) {
                char replacement = LOWERCASE_ALPHABET.charAt((indexOnLowercaseAlphabet + key) % LOWERCASE_ALPHABET.length());
                res.append(replacement);
            } else if (indexOnUppercaseAlphabet > -1) {
                char replacement = UPPERCASE_ALPHABET.charAt((indexOnUppercaseAlphabet + key) % UPPERCASE_ALPHABET.length());
                res.append(replacement);
            } else {
                res.append(ch);
            }
        }

        return res.toString();
    }

    public String decode(String str) {
        StringBuilder res = new StringBuilder();

        for (char ch: str.toCharArray()) {
            int indexOnLowercaseAlphabet = LOWERCASE_ALPHABET.indexOf(ch);
            int indexOnUppercaseAlphabet = UPPERCASE_ALPHABET.indexOf(ch);

            if (indexOnLowercaseAlphabet > -1) {
                int replacementKey = (indexOnLowercaseAlphabet - key) % LOWERCASE_ALPHABET.length();

                if (replacementKey < 0) {
                    replacementKey = LOWERCASE_ALPHABET.length() + replacementKey;
                } else if (replacementKey > LOWERCASE_ALPHABET.length()) {
                    replacementKey = replacementKey - LOWERCASE_ALPHABET.length();
                }

                char replacement = LOWERCASE_ALPHABET.charAt((replacementKey) % LOWERCASE_ALPHABET.length());
                res.append(replacement);
            } else if (indexOnUppercaseAlphabet > -1) {
                int replacementKey = (indexOnUppercaseAlphabet - key) % UPPERCASE_ALPHABET.length();

                if (replacementKey < 0) {
                    replacementKey = UPPERCASE_ALPHABET.length() + replacementKey;
                } else if (replacementKey > UPPERCASE_ALPHABET.length()) {
                    replacementKey = replacementKey - UPPERCASE_ALPHABET.length();
                }

                char replacement = UPPERCASE_ALPHABET.charAt((replacementKey) % UPPERCASE_ALPHABET.length());
                res.append(replacement);
            } else {
                res.append(ch);
            }
        }

        return res.toString();
    }
}
