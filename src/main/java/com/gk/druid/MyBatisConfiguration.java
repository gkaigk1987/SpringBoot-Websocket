package com.gk.druid;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@EnableTransactionManagement
@AutoConfigureAfter(value = BaseDataSourceConfiguration.class)
@MapperScan(basePackages = { "com.gk.mapper" })
public class MyBatisConfiguration implements EnvironmentAware {

	private static Logger logger = LoggerFactory.getLogger(MyBatisConfiguration.class);

	private RelaxedPropertyResolver propertyResolver;

	@Autowired
	private DruidDataSource dataSource;

	@Override
	public void setEnvironment(Environment environment) {
		this.propertyResolver = new RelaxedPropertyResolver(environment, "mybatis.");
	}

	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory() {
		try {
			logger.info("SqlSessionFactory configuration......");
			SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
			bean.setDataSource(dataSource);
			bean.setTypeAliasesPackage(propertyResolver.getProperty("typeAliasesPackage"));
			bean.setMapperLocations(new PathMatchingResourcePatternResolver()
					.getResources(propertyResolver.getProperty("mapperLocations")));
			// PageHelper配置
//			PageHelper pageHelper = new PageHelper();//4.x版本
			/*PageInterceptor pageHelper = new PageInterceptor();//5.x版本
			Properties properties = new Properties();
			properties.setProperty("reasonable", "true");
			properties.setProperty("supportMethodsArguments", "true");
			properties.setProperty("returnPageInfo", "check");
			properties.setProperty("params", "count=countSql");
			pageHelper.setProperties(properties);
			bean.setPlugins(new Interceptor[] { pageHelper });*/

			return bean.getObject();

		} catch (Exception e) {
			logger.error("SqlSessionFactory configuration error!{}", e.getMessage());
			return null;
		}
	}

//	@Bean
//	public SqlSessionTemplate sqlSessionTemplate(
//			@Qualifier(value = "sqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
//		return new SqlSessionTemplate(sqlSessionFactory);
//	}

	/**
	 * 手动配置事务管理器
	 * 如果不手动配置，springboot会自动调用DataSourceTransactionManagerAutoConfiguration配置transactionManager
	 * @return
	 */
	@Bean(name="transactionManager")
	public DataSourceTransactionManager dataSourceTransactionManager() {
		return new DataSourceTransactionManager(dataSource);
	}

}
