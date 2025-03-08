package org.nngu.vkr.zabbix.api.exception;

public class ZabbixApiException extends RuntimeException {
    public ZabbixApiException(String message, Throwable cause) {
        super(message, cause);
    }
}
