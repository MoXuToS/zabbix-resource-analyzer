package org.nngu.vkr.metric.provider.dao;

import jakarta.transaction.Transactional;
import org.nngu.vkr.metric.provider.entity.MetricEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MetricRepository extends JpaRepository<MetricEntity, Long> {
    @Query(value =
            "INSERT INTO :schemeName.vmMetrics " +
                    "(metric_time, metric_name, metric_value) " +
                    "VALUES (:#{#entity.metricTime}, :#{#entity.metricName}, :#{#entity.metricValue})",
            nativeQuery = true)
    @Transactional
    @Modifying
    void saveToVmScheme(
            @Param("schemeName") String schemeName,
            @Param("entity") MetricEntity entity
    );
}
