package by.issoft.alertcity;

import by.issoft.alertcity.entity.Project;
import by.issoft.alertcity.entity.ProjectStatus;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.EntityManager;

public class Runner {

	public static void main(String[] args){

		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.configure("hibernate.cfg.xml")
				.build();

		MetadataSources metadataSources = new MetadataSources(serviceRegistry);
		metadataSources.addAnnotatedClass(Project.class);

		SessionFactory sessionFactory = metadataSources.buildMetadata().buildSessionFactory();

		Session session = null;
		Transaction transaction = null;

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			EntityManager entityManager = session.unwrap(EntityManager.class);

			Project project = new Project();
			project.setName("Project 133");
			project.setStatus(ProjectStatus.UNKNOWN);

			entityManager.persist(project);

			transaction.commit();

		} catch (Exception e) {
			if (transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session!=null) {
				session.close();
			}
		}







//		//apply flyway
//		registerJDBCDriver();
//		DataSource dataSource = createDataSource();
//		ClassicConfiguration configuration = prepareMigrateConfigurationUsingDataSource(dataSource);
//		Flyway flyway = new Flyway(configuration);
//		flyway.migrate();
//
//		//insert some data using dao
//		ProjectDaoImpl projectDao = new ProjectDaoImpl(dataSource);
//
//		projectDao.save(new Project("Project 1"));
		//another dao save

		//commit


//		projectDao.save(new Project(2, "Project 2"));

		//load some data using data
//		projectDao.findAll();
//	}
//
//	private static void registerJDBCDriver() {
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static BasicDataSource createDataSource() {
//		BasicDataSource dataSource = new BasicDataSource();
//		dataSource.setUrl("jdbc:mysql://localhost:3306/alert_city");
//		dataSource.setUsername("root1");
//		dataSource.setPassword("password");
//
//		return dataSource;
//	}
//
//	private static ClassicConfiguration prepareMigrateConfigurationUsingDataSource(DataSource dataSource) {
//		ClassicConfiguration configuration = new ClassicConfiguration();
//		configuration.setDataSource(dataSource);
//		configuration.setBaselineOnMigrate(true);
//		return configuration;
//	}

	}
}
