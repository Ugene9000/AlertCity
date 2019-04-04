package by.issoft.alertcity.dao;

import by.issoft.alertcity.entity.Project;

import java.util.List;

public interface ProjectDao {

	Long save(Project project);

	void update(Project project);

	Project findById(Long id);

	List<Project> findAll();

}
