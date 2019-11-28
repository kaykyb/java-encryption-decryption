package encryptdecrypt.encoders;

public class UnicodeEncoder extends Encoder {
    UnicodeEncoder(int key) {
        super(key);
    }

    public String encode(String str) {
        StringBuilder res = new StringBuilder();

        for (char ch: str.toCharArray()) {
            res.append((char) (ch + key));
        }

        return res.toString();
    }

    public String decode(String str) {
        StringBuilder res = new StringBuilder();

        for (char ch: str.toCharArray()) {
            res.append((char) (ch - key));
        }

        return res.toString();
    }
}
