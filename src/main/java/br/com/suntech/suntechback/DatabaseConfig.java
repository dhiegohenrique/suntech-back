package br.com.suntech.suntechback;

import java.net.URI;
import java.net.URISyntaxException;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DatabaseConfig {
    
	@Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() throws URISyntaxException {
//    	DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//    	dataSourceBuilder.url("jdbc:mysql://localhost:3306/suntech");
//        return dataSourceBuilder.build();
		
		String dbUrl = "jdbc:mysql://localhost:3306/suntech";
		String username = "root";
		String password = "root";
		
		String dataBaseEnv = System.getenv("CLEARDB_DATABASE_URL");
		System.err.println("dataBaseEnv: " + dataBaseEnv);
		if (dataBaseEnv != null) {
			URI dbUri = new URI(System.getenv("CLEARDB_DATABASE_URL"));
			
			username = dbUri.getUserInfo().split(":")[0];
			password = dbUri.getUserInfo().split(":")[1];
			dbUrl = "jdbc:mysql://" + dbUri.getHost() + dbUri.getPath();
		}
		
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.url(dbUrl);
		dataSourceBuilder.username(username);
		dataSourceBuilder.password(password);
        return dataSourceBuilder.build();
    }
}