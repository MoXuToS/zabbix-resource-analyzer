package org.nngu.vkr.metric.provider.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.nngu.vkr.metric.provider.dto.MetricDTO;
import org.nngu.vkr.metric.provider.entity.MetricEntity;


@Mapper(componentModel = "spring")
public interface MetricMapper {
    @Mapping(target = "id", ignore = true)
    MetricEntity toEntityWithoutId(MetricDTO dto);

    default MetricEntity toEntity(MetricDTO dto) {
        return toEntityWithoutId(dto);
    }
}