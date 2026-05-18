package ro.ulbs.proiectaresoftware.lab7.util;

import java.util.Random;

public class PasswordMaker {
    private static final int MAGIC_NUMBER = 10;
    private static final String MAGIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    private static PasswordMaker instance;
    private final Random random = new Random();

    private PasswordMaker() {
    }

    public static PasswordMaker getInstance() {
        if (instance == null) {
            instance = new PasswordMaker();
        }

        return instance;
    }

    public String getPassword(String name) {
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < MAGIC_NUMBER; i++) {
            int index = random.nextInt(MAGIC_STRING.length());
            password.append(MAGIC_STRING.charAt(index));
        }

        password.append(name.length());

        return password.toString();
    }
}