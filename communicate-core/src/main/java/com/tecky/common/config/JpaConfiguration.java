package com.tecky.common.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * @author mkeysersoze
 *
 */

// @Configuration
// When Spring Data finds it, it creates an implementation of all repositories
// @EnableJpaRepositories(basePackages = "com.tecky",
// repositoryImplementationPostfix = "Impl")
// @ComponentScan(basePackages = { "com.tecky" })

public class JpaConfiguration {

	private static final Logger LOG = LoggerFactory.getLogger(JpaConfiguration.class);

	private final String dataSourceConfigFile = "datasource.properties";
	private final String packageToScan = "com.tecky";

	// @Bean
	public DataSource dataSource() {
		LOG.debug("Configuring DataSource");
		final Properties properties = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		final InputStream stream = loader.getResourceAsStream(dataSourceConfigFile);
		try {
			properties.load(stream);
		} catch (IOException e) {
			LOG.error("Failed to load configuration");
		}

		HikariConfig config = new HikariConfig(properties);
		config.setDriverClassName("com.mysql.jdbc.Driver");
		HikariDataSource ds = new HikariDataSource(config);
		return ds;
	}

	/**
	 * Use this option for full JPA capabilities in a Spring-based application
	 * environment. This includes web containers such as Tomcat as well as
	 * stand-alone applications and integration tests with sophisticated persistence
	 * requirements. <br>
	 * {@link LocalContainerEntityManagerFactoryBean} produces a container-managed
	 * {@link EntityManagerFactory}.
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LOG.debug("Enter entityManagerFactory()");
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		// factory.setDataSource(dataSource());
		factory.setJpaVendorAdapter(jpaVendorAdapter());
		factory.setPackagesToScan(packageToScan);
		LOG.debug("Exit entityManagerFactory()");
		return factory;
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setGenerateDdl(true);
		adapter.setShowSql(true);
		return adapter;
	}

	/**
	 * To enable support for transactions, we must configure a
	 * {@link PlatformTransactionManager} bean
	 */
	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return txManager;
	}
}
