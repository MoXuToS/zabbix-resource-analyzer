package org.nngu.vkr.shared.zabbix.integration.exception;

public class ZabbixApiException extends RuntimeException {
    public ZabbixApiException(String message, Throwable cause) {
        super(message, cause);
    }
}
