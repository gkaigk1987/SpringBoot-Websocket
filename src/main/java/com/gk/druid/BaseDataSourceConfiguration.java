package com.gk.druid;


import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@EnableTransactionManagement
public class BaseDataSourceConfiguration implements EnvironmentAware {
	
	private static Logger logger = LoggerFactory.getLogger(BaseDataSourceConfiguration.class);
	
	private RelaxedPropertyResolver propertyResolver;
	
	@Override
	public void setEnvironment(Environment environment) {
		this.propertyResolver = new RelaxedPropertyResolver(environment,"spring.datasource.");
	}
	
	@Bean(name="dataSource")
	public DruidDataSource dataSource() throws SQLException {
		DruidDataSource dataSource = new DruidDataSource();
		logger.info("datasource configuration start ......");
		dataSource.setUrl(propertyResolver.getProperty("url"));
		dataSource.setDriverClassName(propertyResolver.getProperty("driverClassName"));
		dataSource.setUsername(propertyResolver.getProperty("username"));
		dataSource.setPassword(propertyResolver.getProperty("password"));
		dataSource.setFilters(propertyResolver.getProperty("filters"));
		dataSource.setMaxActive(propertyResolver.getProperty("maxActive", Integer.class));
		dataSource.setInitialSize(propertyResolver.getProperty("initialSize", Integer.class));
		dataSource.setMinIdle(propertyResolver.getProperty("minIdle", Integer.class));
		logger.info("datasource configuration end ......");
		return dataSource;
	}

}
