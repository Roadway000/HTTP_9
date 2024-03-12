package org.example.http;

import java.util.Scanner;

import static org.example.Main.log;
import static org.example.http.Messages.INIT_CODE;

public class HttpImageStatusCli {
    public void askStatus() {
        try (Scanner scanner = new Scanner(System.in)) {
            HttpStatusImageDownloader statusCode = new HttpStatusImageDownloader();
            String inputValue;
            int code = INIT_CODE;
            while (code > 0) {
                log.info("Enter HTTP status code greater than 99 or 0 to exit: ");
                if (scanner.hasNextLine()) {
                    inputValue = scanner.nextLine();
                    code = Integer.parseInt(inputValue);
                    if (code < 0 || code > 999) {
                        log.info("Please enter valid number greater 99 and less than 600!");
                        code = INIT_CODE;
                    } else {
                        log.info("You enter valid code {}. Check it", inputValue);
                        try {
                            statusCode.downloadStatusImage(code);
                        } catch (Exception e) {
                            log.info("There is not image for HTTP status {}", code);
                        }
                    }
                } else {
                    log.info("Please enter valid number!");
                }
            }
        } catch (NumberFormatException e) {
            log.error(e.getMessage());
        }
    }

}
