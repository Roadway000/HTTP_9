package org.example.http;

import java.io.FileNotFoundException;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.example.Main.log;
import static org.example.http.Messages.*;

public class HttpStatusChecker {
    public String getStatusImage(int code) throws Exception {
//        String url = new StringBuilder(HOST_URL).append(code).append(EXTENSION).toString();
        String url = String.format(MASK_HOST_URL, code);
        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        log.info("Url: {} Code: {} Response code: {}", url, code, responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) {
            return url;
        } else {
            throw new FileNotFoundException(String.format(FILE_NOT_FOUND_EXCEPTION_TEXT,responseCode));
        }
    }
}
