package encryptdecrypt;

import encryptdecrypt.helpers.ArgParser;

import java.util.NoSuchElementException;

class DefaultArgParser extends ArgParser {
    private String[] args;

    DefaultArgParser(String[] args) {
        this.args = args;
    }

    String getMode(){
        String arg = getArg("mode");

        if (!(arg.equals("enc") || arg.equals("dec"))) {
            throw new IllegalArgumentException("Argument \"mode\" is invalid. (" + arg + ")");
        }

        return arg;
    }

    String getData(){
        return getArg("data");
    }

    String getIn(){
        return getArg("in");
    }

    String getOut(){
        return getArg("out");
    }

    String getAlgorithm() { return getArg("alg"); }

    int getKey() {
        String arg = getArg("key");

        try {
            return Integer.parseInt(arg);
        } catch (Exception e) {
            throw new IllegalArgumentException("Argument \"key\" is invalid.");
        }
    }

    private String getArg(String arg) {
        int index = getArgIndex("-" + arg, args);

        if (index > args.length - 1) {
            throw new IllegalArgumentException("Argument \"" + arg + "\" is invalid.");
        }

        if (index == -1) {
            throw new NoSuchElementException("Argument \"" + arg + "\" was not found.");
        }

        return args[index];
    }
}
