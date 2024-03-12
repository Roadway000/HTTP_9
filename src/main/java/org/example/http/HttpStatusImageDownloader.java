package org.example.http;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.example.Main.log;
import static org.example.http.Messages.*;
public class HttpStatusImageDownloader {
    public void downloadStatusImage(int code) throws Exception {
        HttpStatusChecker statusChecker = new HttpStatusChecker();
        String url = statusChecker.getStatusImage(code);
        try (InputStream is = new URL(url).openStream()) {
            String path = new File(".").getCanonicalPath();
            File directory = new File(path, DIRECTORY_FOR_SAVE);
            if (!directory.exists()) {
                directory.mkdir();
            }
            String filePath = String.format(SAVED_FILE, code);
            if (!new File(filePath).exists()) {
                Files.copy(is, Paths.get(filePath));
            } else {
                log.error(String.format(FILE_ALREADY_EXIST_TEXT, code));
            }
        } catch(Exception e) {
            throw new FileNotFoundException(String.format(FILE_NOT_FOUND_EXCEPTION_TEXT, code, e.toString()));
        }
    }
}
