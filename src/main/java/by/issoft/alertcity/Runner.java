package by.issoft.alertcity;

import by.issoft.alertcity.dao.ProjectDaoImpl;
import org.apache.commons.dbcp.BasicDataSource;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.ClassicConfiguration;

import javax.sql.DataSource;

public class Runner {

	public static void main(String[] args) throws Exception {
		//apply flyway
		registerJDBCDriver();
		BasicDataSource dataSource = createDataSource();
		ClassicConfiguration configuration = prepareMigrateConfigurationUsingDataSource(dataSource);
		Flyway flyway = new Flyway(configuration);
		flyway.migrate();

		//insert some data using dao
		ProjectDaoImpl projectDao = new ProjectDaoImpl(dataSource);
//		projectDao.add(new Project(1, "Project 1"));
//		projectDao.add(new Project(2, "Project 2"));

		//load some data using data
		projectDao.getAll();
	}

	private static void registerJDBCDriver() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static BasicDataSource createDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/alert_city");
		dataSource.setUsername("root1");
		dataSource.setPassword("password");
		return dataSource;
	}

	private static ClassicConfiguration prepareMigrateConfigurationUsingDataSource(DataSource dataSource) {
		ClassicConfiguration configuration = new ClassicConfiguration();
		configuration.setDataSource(dataSource);
		configuration.setBaselineOnMigrate(true);
		return configuration;
	}

}
