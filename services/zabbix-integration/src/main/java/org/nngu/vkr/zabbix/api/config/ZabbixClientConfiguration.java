package org.nngu.vkr.zabbix.api.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class ZabbixClientConfiguration {
    @Value("${zabbix.server.ip}")
    private String zabbixServerIP;

    @Value("${zabbix.server.port}")
    private int zabbixServerPort;

    @Value("${zabbix.api.key}")
    private String apiKey;

    public String getServerApiUrl() {
        return "http://" + zabbixServerIP + ":" + zabbixServerPort + "/api_jsonrpc.php";
    }
}
