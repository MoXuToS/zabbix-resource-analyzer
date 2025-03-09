package org.nngu.vkr.metric.provider.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.sql.Date;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class MetricDTO {
    private final Date metricTime;
    private final String metricName;
    private final double metricValue;
}
