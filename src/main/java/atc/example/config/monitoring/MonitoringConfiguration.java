package atc.example.config.monitoring;

import org.springframework.boot.actuate.autoconfigure.ExportMetricWriter;
import org.springframework.boot.actuate.metrics.jmx.JmxMetricWriter;
import org.springframework.boot.actuate.metrics.writer.MetricWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.MBeanExporter;


@Configuration
public class MonitoringConfiguration
{
    /**
     * Export spring boot metrics to JMX.
     *
     * @param exporter
     * @return a MetricsWriter object
     */
    @Bean
    @ExportMetricWriter
    public MetricWriter metricWriter ( final MBeanExporter exporter )
    {
        return new JmxMetricWriter( exporter );
    }
}
