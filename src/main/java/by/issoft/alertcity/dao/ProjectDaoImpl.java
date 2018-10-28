package by.issoft.alertcity.dao;

import by.issoft.alertcity.entity.Project;
import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectDaoImpl implements ProjectDao {
	private DataSource dataSource;

	public ProjectDaoImpl(BasicDataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public boolean add(Project project) {
		if (getById(project.getId()) != null) {
			return false;
		}
		try (Connection connection = getConnection();
		     PreparedStatement statement = connection.prepareStatement("INSERT INTO PROJECT VALUES (?,?)")) {
			statement.setLong(1, project.getId());
			statement.setString(2, project.getName());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean update(Project project) {
		return false;
	}

	@Override
	public Project getById(Long id) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Project result = null;
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement("SELECT * FROM PROJECT WHERE ID = ?");
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				result = createProject(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection, statement, resultSet);
		}
		return result;
	}

	@Override
	public List<Project> getAll() throws Exception {
		ResultSet resultSet = null;
		List<Project> projects = new ArrayList<>();
		Connection connection = getConnection();
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM PROJECT");
		try {
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				projects.add(createProject(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection, statement, resultSet);
		}
		return projects;
	}

	private Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

	private Project createProject(ResultSet resultSet) throws SQLException {
		return new Project(resultSet.getLong("id"), resultSet.getString("name"));
	}

	private void close(Connection connection, PreparedStatement statement, ResultSet resultSet) {
		try {
			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
