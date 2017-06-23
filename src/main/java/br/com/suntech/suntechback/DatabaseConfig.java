package br.com.suntech.suntechback;

import java.net.URI;
import java.net.URISyntaxException;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

@Configuration
public class DatabaseConfig {
    
	@Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() throws URISyntaxException, ClassNotFoundException {
		String dbUrl = "jdbc:mysql://localhost:3306";
		String username = "root";
		String password = "root";
		
		String dataBaseEnv = System.getenv("CLEARDB_DATABASE_URL");
		if (dataBaseEnv != null) {
			URI dbUri = new URI(dataBaseEnv);
			
			username = dbUri.getUserInfo().split(":")[0];
			password = dbUri.getUserInfo().split(":")[1];
			dbUrl = "jdbc:mysql://" + dbUri.getHost() + dbUri.getPath();
		}
		
//		MysqlDataSource dataSource = new MysqlDataSource();
//		dataSource.setUrl(dbUrl);
//	    dataSource.setUser(username);
//	    dataSource.setPassword(password);
//	    dataSource.setDatabaseName("suntech");
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(dbUrl);
	    dataSource.setUsername(username);
	    dataSource.setPassword(password);
		
		
		Resource initSchema = new ClassPathResource("script.sql");
	    DatabasePopulator databasePopulator = new ResourceDatabasePopulator(initSchema);
	    DatabasePopulatorUtils.execute(databasePopulator, dataSource);
	    dataSource.setUrl(dbUrl + "/suntech");
		return dataSource;
    }
}