package org.nngu.vkr.metric.provider.service;

import lombok.RequiredArgsConstructor;
import org.nngu.vkr.metric.provider.dao.MetricRepository;
import org.nngu.vkr.metric.provider.dto.MetricDTO;
import org.nngu.vkr.metric.provider.entity.MetricEntity;
import org.nngu.vkr.metric.provider.mapper.MetricMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Сервис по получению и сохранению метрик в БД
 */
@Service
@RequiredArgsConstructor
public class MetricService {
    private static final Logger log = LoggerFactory.getLogger(MetricService.class);
    private final MetricMapper metricMapper;
    MetricRepository metricRepository;
    /**
     * Метод для сохранения полученных метрик в базу данных
     * @param metrics массив ДТО с метриками
     * @param virtualMachineHostname Наименование виртуальной машины
     */
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
