package org.nngu.vkr.zabbix.api.client.feign;
import org.nngu.vkr.zabbix.api.config.ZabbixApiFeignConfig;
import org.nngu.vkr.zabbix.api.dto.ZabbixApiRequestDTO;
import org.nngu.vkr.zabbix.api.dto.ZabbixApiResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "zabbixClient",
        configuration = ZabbixApiFeignConfig.class)
public interface ZabbixApiClient {
    @PostMapping(value = "/api_jsonrpc.php")
    ZabbixApiResponseDTO sendRequest(@RequestBody ZabbixApiRequestDTO request);
}
