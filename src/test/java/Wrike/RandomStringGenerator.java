package Wrike;

import java.util.Random;

/**
 * Created by Osychenko Yuriy on 12.03.2019
 * Class to generate random String with length:6-10 chars using ALPHABET String
 */

public class RandomStringGenerator {
    private static Random random;

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static String getRandomString() {
        random = new Random();
        int n = random.nextInt(6) + 4;
        StringBuilder builder = new StringBuilder(n);

        for (int i = 0; i < n; i++){
            builder.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
        }
        return builder.toString();
    }
}
