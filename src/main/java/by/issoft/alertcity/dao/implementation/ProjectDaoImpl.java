package by.issoft.alertcity.dao.implementation;

//public class ProjectDaoImpl implements ProjectDao {
//
//	private final DataSource dataSource;
//
//	public ProjectDaoImpl(DataSource dataSource) {
//		this.dataSource = dataSource;
//	}
//
//	@Override
//	public Long save(Project project) {
//		assert project.getId() == null;
//
//		try (Connection connection = getConnection();
//		     PreparedStatement statement = connection.prepareStatement("INSERT INTO PROJECT (name) VALUES (?)")) {
//			statement.setString(0, project.getName());
//			statement.execute();
//
//			//TODO retrieve generated id
//
//			return 1L;
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new RuntimeException(e);
//		}
//	}
//
//	@Override
//	public void update(Project project) {
//
//	}
//
//	@Override
//	public Project findById(Long id) {
//		try (Connection connection = getConnection();
//		     PreparedStatement statement = connection.prepareStatement("SELECT * FROM PROJECT WHERE ID = ?")) {
//
//
//			statement.
//
//			statement.setLong(1, id);
//			ResultSet resultSet = statement.executeQuery();
//			if (resultSet.next()) {
//				return createProject(resultSet);
//			}
//			return null;
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new RuntimeException(e);
//		}
//	}
//
//	@Override
//	public List<Project> findAll() throws Exception {
//		ResultSet resultSet = null;
//		List<Project> projects = new ArrayList<>();
//		Connection connection = getConnection();
//		PreparedStatement statement = connection.prepareStatement("SELECT * FROM PROJECT");
//		try {
//			resultSet = statement.executeQuery();
//			while (resultSet.next()) {
//				projects.add(createProject(resultSet));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return projects;
//	}
//
//	private Connection getConnection() throws SQLException {
//		return dataSource.getConnection();
//	}
//
//	private Project createProject(ResultSet resultSet) throws SQLException {
//		return new Project(resultSet.getLong("id"), resultSet.getString("name"));
//	}
//}
