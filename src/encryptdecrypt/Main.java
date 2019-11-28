package encryptdecrypt;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Program program = new Program();

        try {
            program.execute(args);
        } catch (Exception e) {
            printError(e.getMessage());
        }
    }

    private static void printError(String error) {
        System.out.println("Errors: " + error);
    }
}

