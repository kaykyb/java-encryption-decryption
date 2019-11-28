package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import encryptdecrypt.encoders.Encoder;
import encryptdecrypt.encoders.EncoderFactory;

class Program {
    private String mode, data, in, out, algorithm;
    private int key;

    private DefaultArgParser argParser;

    void execute(String[] args) throws IOException {
        argParser = new DefaultArgParser(args);

        this.assignParams();
        this.doOperation();
    }

    private void doOperation() throws IOException {
        // create encoder
        Encoder encoder = EncoderFactory.getEncoder(algorithm, key);
        
        // result string
        String res = "";

        // encrypt or decrypt
        if (mode.equals("enc")) {
            if (data == null) {
                res = encoder.encodeFromFile(in);
            } else {
                res = encoder.encode(data);
            }
        } else {
            if (data == null) {
                res = encoder.decodeFromFile(in);
            } else {
                res = encoder.decode(data);
            }
        }

        if (out == null) {
            System.out.println(res);
        } else {
            File file = new File(out);
            FileWriter writer = new FileWriter(file);

            writer.write(res);

            writer.close();
        }
    }

    private void assignParams() {
        this.assignMode();
        this.assignInput();
        this.assignOutput();
        this.assignKey();
        this.assignAlgorithm();
    }

    private void assignMode() {
        try {
            mode = argParser.getMode();
        } catch (NoSuchElementException e) {
            mode = "enc";
        }
    }

    private void assignInput() {
        try {
            data = argParser.getData();
        } catch (NoSuchElementException e) {
            try {
                in = argParser.getIn();
            } catch (NoSuchElementException e2) {
                data = "";
            }
        }
    }

    private void assignOutput() {
        try {
            out = argParser.getOut();
        } catch (NoSuchElementException e) {
            out = null;
        }
    }

    private void assignKey() {
        try {
            key = argParser.getKey();
        } catch (NoSuchElementException e) {
            key = 0;
        }
    }

    private void assignAlgorithm () {
        try {
            algorithm = argParser.getAlgorithm();
        } catch (NoSuchElementException e) {
            algorithm = "shift";
        }
    }
}

