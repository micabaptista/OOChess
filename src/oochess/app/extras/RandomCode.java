package oochess.app.extras;

import java.util.Locale;
import java.util.Random;

public class RandomCode {
    private static RandomCode instance = null;

    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = UPPER.toLowerCase(Locale.ROOT);
    private static final String DIGITS = "0123456789";
    private static final String ALPHANUM = UPPER + LOWER + DIGITS;
    private static final int CODE_SIZE = 9;
    
    private Random random;
    private char[] symbols;
    private char[] buf;
    
    private RandomCode() {
        if (CODE_SIZE < 1) throw new IllegalArgumentException();
        if (ALPHANUM.length() < 2) throw new IllegalArgumentException();
        this.random = new Random();
        this.symbols = ALPHANUM.toCharArray();
        this.buf = new char[CODE_SIZE];
    }

    public static RandomCode getInstance() {
        if (instance == null) {
            instance = new RandomCode();
        }
        return instance;
    }

    public String createCode() {
        for (int idx = 0; idx < buf.length; ++idx) {
            buf[idx] = symbols[random.nextInt(symbols.length)];
        }
        return new String(buf);
    }

}
