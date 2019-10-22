package model;

import java.io.Serializable;

public class Configuration implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6173650301201053205L;
	private String lastOpenedProjectPath;
	private model.Project lastProject;
	
	public Configuration() {}

	public String getLastOpenedProjectPath() {
		return lastOpenedProjectPath;
	}

	public void setLastOpenedProjectPath(String lastOpenedProjectPath) {
		this.lastOpenedProjectPath = lastOpenedProjectPath;
	}

	public model.Project getLastProject() {
		return lastProject;
	}

	public void setLastProject(model.Project lastProject) {
		this.lastProject = lastProject;
	}
}
