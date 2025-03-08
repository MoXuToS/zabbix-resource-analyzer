package org.nngu.vkr.zabbix.api;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "org.nngu.vkr.zabbix.api.client.feign")
public class ZabbixIntegration {
    public static void main(String[] args) {
        SpringApplication.run(ZabbixIntegration.class, args);
    }
}
