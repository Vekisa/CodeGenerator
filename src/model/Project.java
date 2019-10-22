package model;

public class Project extends Item implements java.io.Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4086180871865663019L;
	private String path;
	
	public Project(String name) {
		super();
		this.name = name;
		path = null;
	}
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getName() {
		return name;
	}
}
