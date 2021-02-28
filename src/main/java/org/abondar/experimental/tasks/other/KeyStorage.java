package org.abondar.experimental.tasks.other;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

public class KeyStorage {


    public static final String LEN_ERROR_MSG = "Key is too long";
    public static final String NULL_ERROR_MSG = "Key or Secret is null";
    private static final int MAX_KEY_LEN = 20;

    private static final int ENC_RANGE_START = 48;

    private static final int ENC_RANGE_END = 122;
    private final Map<String, String> keyStorage;

    public KeyStorage() {
        this.keyStorage = new HashMap<>();
    }


    public String storeSecret(String secret) {

        if (secret == null) {
            return NULL_ERROR_MSG;
        }

        var rnd = new Random();
        char[] src = new char[20];
        for (int i = 0; i < src.length; i++) {
            var rndInt = rnd.ints(ENC_RANGE_START, ENC_RANGE_END)
                    .findFirst()
                    .getAsInt();

            src[i] = (char) rndInt;
        }

        var key = new String(src);
        storeSecret(secret, key);


        return key;
    }

    public int storeSecret(String secret, int key) {
        var strKey = String.valueOf(key);
        storeSecret(secret, strKey);

        return key;
    }


    public String storeSecret(String secret, String key) {

        if (key == null) {
            return NULL_ERROR_MSG;
        }

        if (key.length() > MAX_KEY_LEN) {
            return LEN_ERROR_MSG;
        }

        var storedKey = key.toLowerCase(Locale.ROOT);
        keyStorage.put(storedKey, secret);

        return key;
    }

    public Optional<String> retrieveSecret(int key) {
        var strKey = String.valueOf(key);
        return retrieveSecret(strKey);
    }

    public Optional<String> retrieveSecret(String key) {

        if (key == null) {
            return Optional.of(NULL_ERROR_MSG);
        }

        var storedKey = key.toLowerCase(Locale.ROOT);
        return Optional.ofNullable(keyStorage.get(storedKey));

    }

}
