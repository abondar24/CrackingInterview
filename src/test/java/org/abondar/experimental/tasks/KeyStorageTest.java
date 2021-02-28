package org.abondar.experimental.tasks;

import org.abondar.experimental.tasks.other.KeyStorage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class KeyStorageTest {
    private KeyStorage keyStorage = new KeyStorage();

    @Test
    public void storeSecretTest(){
        var key = "mY-cUsTom-kEy";
        var secret = "My secret no one should know!";

        var res = keyStorage.storeSecret(secret,key);

        assertEquals(key,res);

    }

    @Test
    public void storeSecretLongKeyTest(){
        var key = "mY-cUsTom-kEyfgjdflgfdjglkfdjgfdlkgjfdlkgjfdlkgfd";
        var secret = "My secret no one should know!";

        var res = keyStorage.storeSecret(secret,key);



    }

    @Test
    public void storeSecretNullKeyTest(){
        var secret = "My secret no one should know!";

        var res = keyStorage.storeSecret(secret,null);

        assertEquals(KeyStorage.NULL_ERROR_MSG,res);

    }

    @Test
    public void retrieveSecretTest(){
        var key = "mY-cUsTom-kEy";
        var secret = "My secret no one should know!";

        key = keyStorage.storeSecret(secret,key);

        var res = keyStorage.retrieveSecret(key);

        assertTrue(res.isPresent());
        assertEquals(secret,res.get());

    }

    @Test
    public void retrieveSecretNotFoundTest(){
        var key = "mY-cUsTom-kEy";
        var res = keyStorage.retrieveSecret(key);

        assertTrue(res.isEmpty());

    }


    @Test
    public void retrieveKeyNullTest(){
        var res = keyStorage.retrieveSecret(null);

        assertTrue(res.isPresent());
        assertEquals(KeyStorage.NULL_ERROR_MSG,res.get());

    }

    @Test
    public void storeIntTest(){
        var key = 1;
        var secret = "My secret no one should know!";

        var res = keyStorage.storeSecret(secret,key);

        assertEquals(key,res);
    }

    @Test
    public void retrieveIntTest(){
        var key = 1;
        var secret = "My secret no one should know!";

        key = keyStorage.storeSecret(secret,key);
        var res = keyStorage.retrieveSecret(key);

        assertTrue(res.isPresent());
        assertEquals(secret,res.get());

    }

    @Test
    public void storeSecretRandomKeyTest(){
        var secret = "My secret no one should know!";

        var res = keyStorage.storeSecret(secret);
        System.out.println(res);

        assertEquals(20,res.length());

    }

}
