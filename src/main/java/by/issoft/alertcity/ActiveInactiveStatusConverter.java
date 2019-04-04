package by.issoft.alertcity;

import by.issoft.alertcity.entity.ProjectStatus;

import javax.persistence.AttributeConverter;

public class ActiveInactiveStatusConverter implements AttributeConverter<ProjectStatus, Integer> {

	@Override
	public Integer convertToDatabaseColumn(ProjectStatus projectStatus) {
		return null;
	}

	@Override
	public ProjectStatus convertToEntityAttribute(Integer integer) {
		return null;
	}
}
