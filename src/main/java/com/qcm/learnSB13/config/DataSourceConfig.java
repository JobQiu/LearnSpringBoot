package com.qcm.learnSB13.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * 
 * @author Congmin Qiu 
 */
// @Configuration
public class DataSourceConfig {

	@Bean(name = "primaryDataSource")
	@Qualifier("primaryDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.primaryDataSource")
	public DataSource primaryDataSource() {
		return DataSourceBuilder.create().build();
	}

	// @Bean(name = "secondaryDataSource")
	// @Qualifier("secondaryDataSource")
	// @ConfigurationProperties(prefix =
	// "spring.datasource.secondaryDataSource")
	// public DataSource secondaryDataSource() {
	// return DataSourceBuilder.create().build();
	// }

}
