package com.anirban.spring.data;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class SpringJDBCConfig {
	
	@Value("${spring.datasource.url}")
	String databaseUrl;
	
	@Value("${spring.datasource.username}")
	String userName;
	
	@Value("${spring.datasource.password}")
	String password;
	
	@Bean
    public DataSource mysqlDataSource() throws ClassNotFoundException {
		//ClassLoader.getSystemClassLoader().loadClass("com.mysql.cj.jdbc.Driver");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(databaseUrl);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        return dataSource;
    }
	
	@Bean
	public JdbcTemplate template() throws ClassNotFoundException {
		JdbcTemplate template = new JdbcTemplate(mysqlDataSource());
		return template;
	}

}
