package model;

public class Attribute {
	private String name;
	private String type;
	private String isStatic;
	private boolean isConst;
	private boolean getter;
	private boolean setter;
	
	public Attribute() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIsStatic() {
		return isStatic;
	}

	public void setIsStatic(String isStatic) {
		this.isStatic = isStatic;
	}

	public boolean isConst() {
		return isConst;
	}

	public void setConst(boolean isConst) {
		this.isConst = isConst;
	}

	public boolean isGetter() {
		return getter;
	}

	public void setGetter(boolean getter) {
		this.getter = getter;
	}

	public boolean isSetter() {
		return setter;
	}

	public void setSetter(boolean setter) {
		this.setter = setter;
	}
	
}
