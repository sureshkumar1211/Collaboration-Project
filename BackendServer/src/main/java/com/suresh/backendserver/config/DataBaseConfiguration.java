package com.suresh.backendserver.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.suresh.backendserver")
public class DataBaseConfiguration {
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("raina");
		dataSource.setPassword("raina");
		return dataSource;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory() {
		LocalSessionFactoryBuilder localSessionFactoryBuilder = new LocalSessionFactoryBuilder(getDataSource());
		localSessionFactoryBuilder.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		localSessionFactoryBuilder.setProperty("hibernate.show_sql", "true");
		localSessionFactoryBuilder.setProperty("hibernate.hbm2ddl.auto", "update");
		localSessionFactoryBuilder.scanPackages("com.suresh.backendserver.model");
		return localSessionFactoryBuilder.buildSessionFactory();

	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransaction() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(getSessionFactory());
		return transactionManager;
	}

}
