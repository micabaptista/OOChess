package oochess.app.extras;

import java.util.Locale;
import java.util.Random;

public class RandomString {
	private static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String lower = upper.toLowerCase(Locale.ROOT);
    private static final String digits = "0123456789";
    private static final String alphanum = upper + lower + digits;
    private  Random random;
    private  char[] symbols;
    private  char[] buf;
    
  //com simbolos personalizados
    public RandomString(int length, String symbols) {
        if (length < 1) throw new IllegalArgumentException();
        if (symbols.length() < 2) throw new IllegalArgumentException();
        this.random = new Random();
        this.symbols = symbols.toCharArray();
        this.buf = new char[length];
    }
    
	public RandomString(int length) {
		this(length, alphanum);
	}

	public String nextString() {
		 for (int idx = 0; idx < buf.length; ++idx) {
			 buf[idx] = symbols[random.nextInt(symbols.length)];
		 }
		 return new String(buf);
	}

}
