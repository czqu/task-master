package net.czqu.taskmaster.sso.config;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: task-master
 * @description:
 * @author: Paul Chen
 * @create: 2023-03-27 22:07
 **/
@Configuration
public class PrometheusConfiguration {
    @Bean
    public MeterRegistryCustomizer<MeterRegistry> metricsCommonTags() {
        return registry -> registry.config()
                .commonTags("application", "task-master-sso");
    }
}
