package org.example;

import org.example.http.HttpImageStatusCli;
import org.example.http.HttpStatusChecker;
import org.example.http.HttpStatusImageDownloader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static final Logger log = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) throws Exception {
        log.info("JAVA DEVELOPER 2.0 MODULE 9 (HTTP)");
        log.info("Завдання №1 отримай посилання");
        HttpStatusChecker statusChecker = new HttpStatusChecker();
        statusChecker.getStatusImage(200);
        statusChecker.getStatusImage(100);
        statusChecker.getStatusImage(0);

        log.info("Завдання №2 скачай картинку");
        HttpStatusImageDownloader statusCode = new HttpStatusImageDownloader();
        statusCode.downloadStatusImage(200);

        log.info("Завдання №2 створи CLI");
        new HttpImageStatusCli().askStatus();
    }
}
