package org.nngu.vkr.zabbix.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude
public class ZabbixApiRequestDTO {
    @JsonProperty("jsonrpc")
    @Builder.Default
    private final String jsonrpc = "2.0";

    @JsonProperty("method")
    @NotNull(message = "Требуется установка названия метода")
    private String method;

    @JsonProperty("id")
    @Positive
    private long id;

    @JsonProperty("params")
    @NotBlank(message = "Требуется установка параметров")
    private Object params;
}
