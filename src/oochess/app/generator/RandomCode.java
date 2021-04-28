package oochess.app.generator;

import java.util.Locale;
import java.util.Random;

public class RandomCode {
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = UPPER.toLowerCase(Locale.ROOT);
    private static final String DIGITS = "0123456789";
    private static final String ALPHANUM = UPPER + LOWER + DIGITS;
    private static final int CODE_SIZE = 9;

    private static RandomCode instance = null;
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

    /**
     * Create a new code different from others already created.
     *
     * @return new code
     */
    public String createNewCode() {
        for (int idx = 0; idx < buf.length; ++idx) {
            buf[idx] = symbols[random.nextInt(symbols.length)];
        }
        return new String(buf);
    }

}
