package com.project.shops.aop;

/**
 * @author qinpan
 * @create 2020-03-26 21:44
 */
public class FileStorageException  extends RuntimeException {
    public FileStorageException(String message) {
        super(message);
    }

    public FileStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
