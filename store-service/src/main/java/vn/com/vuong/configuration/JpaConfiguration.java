package vn.com.vuong.configuration;

import java.util.Properties;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import vn.com.vuong.utils.AppUtil;

@Configuration
public class JpaConfiguration {
	
	@Autowired
	private Config config;
	
	/*
	 * Configure BasicDataSource pooled DataSource.
	 */
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(config.getDriverClassName());
		dataSource.setUrl(config.getUrl());
		dataSource.setUsername(config.getUsername());
		dataSource.setPassword(config.getPassword());
		dataSource.setInitialSize(config.getInitialSize());
		dataSource.setMaxTotal(config.getMaxTotal());
		dataSource.setMaxIdle(config.getMaxIdle());
		dataSource.setMinIdle(config.getMinIdle());
		dataSource.setMaxWaitMillis(config.getMaxWait());
		dataSource.setValidationQuery("select 1");
		return dataSource;
	}
	
	/*
	 * Entity Manager Factory setup.
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws NamingException {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setDataSource(dataSource());
		factoryBean.setPackagesToScan(new String[] { "vn.com.vuong.entity" });
		factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
		factoryBean.setJpaProperties(jpaProperties());
		return factoryBean;
	}
	
	/*
	 * Provider specific adapter.
	 */
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		return hibernateJpaVendorAdapter;
	}
	
	/*
	 * Here you can specify any provider specific properties.
	 */
	private Properties jpaProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", config.getDialect());
		properties.put("hibernate.show_sql", config.isShowSQL());
		properties.put("hibernate.enable_lazy_load_no_trans", config.isLazyLoad());
		properties.put("hibernate.connection.useUnicode", config.isUseUniCode());
		properties.put("hibernate.connection.characterEncoding", config.getEndCoding());
		properties.put("hibernate.connection.charSet", config.getCharset());
		properties.put("hibernate.jdbc.batch_size", "5");
		properties.put("hibernate.order_inserts", "true");
		properties.put("hibernate.order_updates", "true");
		properties.put("hibernate.jdbc.batch_versioned_data", "true");
		if (AppUtil.isStringNullOrEmpty(config.getDefaultSchema())) {
			properties.put("hibernate.default_schema", config.getDefaultSchema());
		}
		return properties;
	}
	
	@Bean
	public BeanPostProcessor persistenceTranslation() {
	return new PersistenceExceptionTranslationPostProcessor();
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(emf);
		return txManager;
	}
}
