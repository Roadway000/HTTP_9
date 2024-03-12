package org.example.http;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.example.http.Messages.MASK_HOST_URL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HttpStatusCheckerTest {
    @Test
    public void getStatusImageGoodTest() throws Exception {
        HttpStatusChecker statusChecker = new HttpStatusChecker();
        int code = 200;
        String result = statusChecker.getStatusImage(code);
        assertEquals(String.format(MASK_HOST_URL, code), result);
    }
    @Test
    public void getStatusImageFatalTest() throws Exception {
        HttpStatusChecker statusChecker = new HttpStatusChecker();
        assertThrows(FileNotFoundException.class, () -> statusChecker.getStatusImage(1000));
    }

}
