package edu.srs.dao;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author ozlem
 */
public class DatabaseConnection {

    @Value("${username}")
    private String username;
    @Value("${password}")
    private String password;
    @Value("${driverClass}")
    private String driverClassName;
    @Value("${jdbcUrl}")
    private String jdbcUrl;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }
}
