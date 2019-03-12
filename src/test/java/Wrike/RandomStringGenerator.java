package Wrike;

import java.util.Random;

public class RandomStringGenerator {
    static Random random;

    public static String getRandomString() {
        final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        random = new Random();
        int n = random.nextInt(6) + 4;
        StringBuilder builder = new StringBuilder(n);

        for (int i = 0; i < n; i++){
            builder.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
        }
        return builder.toString();
    }
}
