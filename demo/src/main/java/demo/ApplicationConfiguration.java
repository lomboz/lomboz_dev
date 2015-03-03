package demo;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@PropertySource("classpath:database.properties")
@Configuration
public class ApplicationConfiguration {

	@Autowired
	private Environment env;

	@Bean
	public DataSource dataSource() throws PropertyVetoException {
		ComboPooledDataSource datasource = new ComboPooledDataSource();
		datasource.setDriverClass(env.getProperty("database.driverclass"));
		datasource.setUser(env.getProperty("database.user"));
		datasource.setPassword(env.getProperty("database.password"));
		datasource.setJdbcUrl(env.getProperty("database.jdbcUrl"));
		return datasource;
	}

}
