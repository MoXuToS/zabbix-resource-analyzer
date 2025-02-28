package org.nngu.vkr.zabbix.api.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.nngu.vkr.zabbix.api.dao.MetricRepository;
import org.nngu.vkr.zabbix.api.dto.MetricDTO;
import org.nngu.vkr.zabbix.api.entity.MetricEntity;
import org.nngu.vkr.zabbix.api.mapper.MetricMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MetricService {
    private static final Logger log = LoggerFactory.getLogger(MetricService.class);
    private final MetricMapper metricMapper;
    MetricRepository metricRepository;


    @Transactional
    public void saveMetrics(List<MetricDTO> metrics, String virtualMachineHostname) {
        for (MetricDTO metric : metrics) {
            try {
                MetricEntity entity = metricMapper.toEntityWithoutId(metric);
                metricRepository.saveToVmScheme(virtualMachineHostname, entity);
            } catch (Exception e) {
                log.error("Ошибка сохранения метрики: {}. Продолжаем...", metric, e);
            }
        }
    }
}
