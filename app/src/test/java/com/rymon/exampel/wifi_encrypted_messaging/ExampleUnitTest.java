package com.rymon.exampel.wifi_encrypted_messaging;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void subString() throws Exception {
        String str = "123456789#SHA-256->123456789";
        String privateMsg = str.substring(0,str.indexOf("#SHA-256->"));

        assertEquals("123456789", privateMsg);
    }
}