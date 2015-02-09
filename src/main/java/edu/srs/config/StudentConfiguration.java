package edu.srs.config;

import edu.srs.dao.DatabaseConnection;
import edu.srs.dao.StudentJDBCTemplate;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author ozlem
 */
@Configuration
@Import({ SecurityConfig.class })
public class StudentConfiguration{

    @Bean
    public DriverManagerDataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        DatabaseConnection dbConnection = databaseConnection();
        dataSource.setDriverClassName(dbConnection.getDriverClassName());
        dataSource.setUrl(dbConnection.getJdbcUrl());
        dataSource.setUsername(dbConnection.getUsername());
        dataSource.setPassword(dbConnection.getPassword());
        return dataSource;
    }

    @Bean
    public StudentJDBCTemplate studentJDBCTemplate(){
        StudentJDBCTemplate studentJDBCTemplate = new StudentJDBCTemplate();
        studentJDBCTemplate.setDataSource(dataSource());
        return studentJDBCTemplate;
    }

    @Bean
    public DatabaseConnection databaseConnection(){
        return new DatabaseConnection();
    }


    @Bean
    public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {

        PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer();
        propertyPlaceholderConfigurer.setLocation(new ClassPathResource("jdbc.properties"));

        return propertyPlaceholderConfigurer;
    }
}
