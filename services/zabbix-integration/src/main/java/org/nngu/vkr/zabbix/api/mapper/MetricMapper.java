package org.nngu.vkr.zabbix.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.nngu.vkr.zabbix.api.dto.MetricDTO;
import org.nngu.vkr.zabbix.api.entity.MetricEntity;

@Mapper(componentModel = "spring")
public interface MetricMapper {
    @Mapping(target = "id", ignore = true)
    MetricEntity toEntityWithoutId(MetricDTO dto);

    default MetricEntity toEntity(MetricDTO dto) {
        return toEntityWithoutId(dto);
    }
}