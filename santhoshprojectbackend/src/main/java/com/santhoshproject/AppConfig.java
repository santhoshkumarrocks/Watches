package com.santhoshproject;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

/**
 * Hello world!
 *
 */
@Configuration
public class AppConfig 
{
	@Bean(name = "dataSource")
    public DataSource getDataSource()
    {
    	BasicDataSource dataSource = new BasicDataSource();
    	dataSource.setDriverClassName("org.h2.Driver");
    	dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
    	dataSource.setUsername("sa");
    	dataSource.setPassword("");
    	return dataSource;
    }
    
    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory()
    {
    	LocalSessionFactoryBuilder sessionBuilder = 
    		new LocalSessionFactoryBuilder(getDataSource());
    	
    	sessionBuilder.scanPackages("com.santhoshproject.model");
    	sessionBuilder.setProperty("hibernate.show_sql","true");
    	sessionBuilder.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
    	sessionBuilder.setProperty("hibernate.hbm2ddl.auto", "update");
    	return sessionBuilder.buildSessionFactory();
    }
}
