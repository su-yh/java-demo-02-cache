package com.suyh0201.datasource.properties;

import com.baomidou.dynamic.datasource.provider.DynamicDataSourceProvider;
import com.suyh0201.datasource.constants.DataSourceEnums;
import com.suyh0201.datasource.hikari.HikariDataSourcePlus;
import lombok.Data;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.FluentConfiguration;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationInitializer;
import org.springframework.boot.autoconfigure.flyway.FlywayProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import javax.sql.DataSource;
import javax.validation.Valid;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author suyh
 * @since 2024-03-20
 */
@ConfigurationProperties(prefix = DynamicDataSourceProviderProperties.PREFIX)
@Data
public class DynamicDataSourceProviderProperties implements DynamicDataSourceProvider, InitializingBean {
    public static final String PREFIX = "base.datasource";

    private boolean enable = true;

    @NestedConfigurationProperty
    @Valid
    private final Map<DataSourceEnums, HikariDataSourcePlus> hikari = new HashMap<>();

    @Override
    public synchronized Map<String, DataSource> loadDataSources() {
        Map<String, DataSource> map = new HashMap<>();
        hikari.forEach((k, v) -> map.put(k.getCode(), v));
        return map;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Collection<HikariDataSourcePlus> hikariDataSourcePluses = hikari.values();
        for (HikariDataSourcePlus ds : hikariDataSourcePluses) {
            doFlyway(ds);
        }
    }

    private void doFlyway(HikariDataSourcePlus ds) throws Exception {
        FlywayProperties flywayProperties = ds.getFlyway();
        if (!flywayProperties.isEnabled()) {
            return;
        }

        String[] locations = flywayProperties.getLocations().toArray(new String[0]);
        FluentConfiguration cdsWebFlywayConfig = new FluentConfiguration();
        cdsWebFlywayConfig.baselineOnMigrate(true)
                .dataSource(ds)
                .locations(locations)
                .table(flywayProperties.getTable())
                .validateOnMigrate(flywayProperties.isValidateOnMigrate())
                .ignoreFutureMigrations(flywayProperties.isIgnoreFutureMigrations())
                .outOfOrder(flywayProperties.isOutOfOrder());
        Flyway cdsWebFlyway = cdsWebFlywayConfig.load();
        FlywayMigrationInitializer flywayMigrationInitializer = new FlywayMigrationInitializer(cdsWebFlyway, null);
        flywayMigrationInitializer.afterPropertiesSet();
    }
}
