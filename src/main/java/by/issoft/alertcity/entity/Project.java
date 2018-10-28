package by.issoft.alertcity.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Project {

	private long id;
	private String name;

	public Project(long id, String name) {
		this.id = id;
		this.name = name;
	}
}
