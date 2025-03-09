package org.nngu.vkr.shared.exception;

public class ZabbixApiException extends RuntimeException {
    public ZabbixApiException(String message, Throwable cause) {
        super(message, cause);
    }
}
