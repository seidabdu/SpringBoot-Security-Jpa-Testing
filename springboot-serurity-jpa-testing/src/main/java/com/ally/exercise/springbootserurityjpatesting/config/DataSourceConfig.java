/*package com.ally.exercise.springbootserurityjpatesting.config;

import java.util.Arrays;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ConfigurationProperties("spring.datasource")
public class DataSourceConfig {

	@Autowired
	private Environment env;

	private String url;
	


	private String username;

	private String password;


	private String driverclassname;

	@Bean(name = "dataSource")
	public DataSource devDataSource() {

		Optional<String> profile = Arrays.stream(env.getActiveProfiles())
				.findFirst();
		System.out.println("======================" + profile
				+ "======================");
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName(driverclassname);
		dataSourceBuilder.url(url);
		dataSourceBuilder.username(username);
		dataSourceBuilder.password(password);

		return dataSourceBuilder.build();

	}

}
*/