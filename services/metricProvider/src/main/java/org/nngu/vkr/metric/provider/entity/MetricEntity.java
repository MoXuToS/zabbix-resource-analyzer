package org.nngu.vkr.metric.provider.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetricEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long id;

    @Column(nullable = false)
    public Date metricTime;

    @Column(nullable = false)
    public String metricName;

    @Column(nullable = false)
    public double metricValue;
}
