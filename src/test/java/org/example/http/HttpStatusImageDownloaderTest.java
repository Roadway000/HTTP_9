package org.example.http;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.example.http.Messages.DIRECTORY_FOR_SAVE;
import static org.example.http.Messages.SAVED_FILE;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HttpStatusImageDownloaderTest {
    @Test
    public void HttpStatusImageDownloaderTest() throws Exception {
        HttpStatusImageDownloader statusCode = new HttpStatusImageDownloader();
        statusCode.downloadStatusImage(0);
        File imageFile = new File(String.format(SAVED_FILE, 0));
        assertTrue(imageFile.exists());
    }
}
