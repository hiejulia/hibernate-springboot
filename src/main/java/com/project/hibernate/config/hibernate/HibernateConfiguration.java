package com.project.hibernate.config.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


@Configuration
@EntityScan("com.project.hibernate.entity")
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class HibernateConfiguration {

    // CONFIG data source
    @Value("${spring.datasource.driverClassName}") String
            driverClassName;
    @Value("${spring.datasource.url}") String url;
    @Value("${spring.datasource.username}") String username;
    @Value("${spring.datasource.password}") String password;

    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        DataSource dataSource = DataSourceBuilder
                .create()
                .username(username)
                .password(password)
                .url(url)
                .driverClassName(driverClassName)
                .build();
        return dataSource;
    }

    // SESSION FACTORY
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(@Qualifier("dataSource") DataSource dataSource) {
        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
        sessionBuilder.scanPackages("com.project.hibernate.entity");
        return sessionBuilder.buildSessionFactory();
    }

    // HIBERNATE TRANSACTION MANAGER

    @Bean(name = "transactionManager")
    public HibernateTransactionManager getTransactionManager(
            SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new
                HibernateTransactionManager(sessionFactory);
        return transactionManager;
    }




}
