package ru.croc.task10.password;

import ru.croc.task10.Task10;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FindPassword implements Runnable {

    private long start;// конец части паролей обрабатываемых определённым потоком
    private long end; // конец блока паролей обрабатываемых определённым потоком
    private final int number; //номер выделенной части для потока
    private final int count; //количество частей
    private final int symbols; //количество символов пароля
    private final long countSymbols; // всего может быть паролей
    private static volatile boolean findPassword = false;//флаг, нашли ли мы пароль



    private static final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();

    /**
     * Перевод в хэш MD5
     */
    private static String toHexString(byte[] bytes) {
        StringBuilder hex = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            hex.append(HEX_DIGITS[(b & 0xff) >> 4]);
            hex.append(HEX_DIGITS[b & 0x0f]);
        }
        return hex.toString();
    }

    /**
     * Получение хэша пароля
     *
     * @param password - пароль
     * @return - хэш
     */
    private static String hashPassword(String password) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        digest.update(password.getBytes());
        byte[] bytes = digest.digest();
        return toHexString(bytes);
    }


    /**
     * Отработка потока, перебор всех возможных паролей в заданной части хэшей
     */
    @Override
    public void run() {
        for (long i = start; i <= end && !findPassword; ++i) {
            String password = makeCombination(i).toString();
            if (hashPassword(password).equals(Task10.hash)) {
                Task10.password = password;
                findPassword = true;
            }
        }
    }

    /**
     * Создает строку в зависимости от хэша со всеми перестановками
     *
     * @param hex -хэш
     * @return - пароль
     */
    private StringBuilder makeCombination(long hex) {
        int[] password = new int[symbols];
        for (int i = 1; i <= symbols; ++i) {
            password[i - 1] = (int) (hex % 26);
            hex /= 26;
        }
        StringBuilder pass = new StringBuilder("");
        for (int i = 0; i < symbols; ++i) {
            pass.append((char) ('a' + password[i]));
        }
        return pass;
    }

    public FindPassword(int number, int count, int symbols) {
        this.number = number;
        this.count = count;
        this.symbols = symbols;
        countSymbols = (long) (Math.pow(26, symbols));
        start = (countSymbols * (number - 1)) / count;
        end = (countSymbols * number) / count - 1;
    }


}
