package model;

import java.io.Serializable;

import javax.swing.DefaultListModel;

public class Configuration implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6173650301201053205L;
	private String lastOpenedProjectPath;
	private model.Project lastProject;
	private DefaultListModel<String> extendsModel;
	private DefaultListModel<String> implementsModel;
	
	public Configuration() {
		extendsModel = new DefaultListModel<String>();
		implementsModel = new DefaultListModel<String>();
	}

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

	public DefaultListModel<String> getExtendsModel() {
		return extendsModel;
	}

	public void setExtendsModel(DefaultListModel<String> extendsModel) {
		this.extendsModel = extendsModel;
	}

	public DefaultListModel<String> getImplementsModel() {
		return implementsModel;
	}

	public void setImplementsModel(DefaultListModel<String> implementsModel) {
		this.implementsModel = implementsModel;
	}
}
