package ru.croc.task10.test;

import org.testng.annotations.Test;
import ru.croc.task10.password.FindPassword;
import ru.croc.task10.password.Hash;
import ru.croc.task10.password.Solution;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotSame;


public class PasswordHashTest {




    private static final String INITIAL_HASH = "40682260CC011947FC2D0B1A927138C5";


    @Test
    private void positiveMainCaseTest() {
        int threadsNumber = 4;

        String password = Solution.calculatePassword(threadsNumber, INITIAL_HASH);
        System.out.println(password);
        String hash = Hash.hashPassword(password);
       System.out.println(hash);
        assertEquals(hash, INITIAL_HASH);
    }


    @Test
    private void negativeMainCaseTest() {
        int threadsNumber = 4;

        String someStrForTest = "smsmbls";
        String someStringHash = Hash.hashPassword(someStrForTest);
        String password =Solution.calculatePassword(threadsNumber, someStringHash);
        String recalculatedHash = Hash.hashPassword(password);

        assertNotSame(recalculatedHash, INITIAL_HASH);
    }



}