package com.surajsahijwani.pdflibrary.exception;

public class FileNotFoundException extends RuntimeException {

    public FileNotFoundException(String detailMessage) {
        super(detailMessage);
    }

    public FileNotFoundException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }
}
