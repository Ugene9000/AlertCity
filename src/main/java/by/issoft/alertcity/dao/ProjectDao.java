package by.issoft.alertcity.dao;

import by.issoft.alertcity.entity.Project;

import java.util.List;

public interface ProjectDao {

	boolean add(Project project) throws Exception;

	boolean update(Project project);

	Project getById(Long id);

	List<Project> getAll() throws Exception;


}
