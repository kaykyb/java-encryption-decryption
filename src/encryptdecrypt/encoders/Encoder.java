package encryptdecrypt.encoders;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public abstract class Encoder {
    protected int key;

    Encoder(int key) {
        this.key = key;
    }

    public String encodeFromFile(String filePath) throws IOException {
        String text = new String(Files.readAllBytes(Paths.get(filePath)));
        return encode(text);
    }

    public String decodeFromFile(String filePath) throws IOException {
        String text = new String(Files.readAllBytes(Paths.get(filePath)));
        return decode(text);
    }

    public abstract String encode(String data);
    public abstract String decode(String data);
}
