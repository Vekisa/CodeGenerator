package model;

import java.util.ArrayList;

public class Operation implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4527410502453255430L;
	private String name;
	private boolean isStatic;
	private boolean isVirtual;
	private String returnValue;
	private boolean isConst;
	private ArrayList<Attribute> parameters;
	
	public Operation() {
		parameters = new ArrayList<Attribute>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isStatic() {
		return isStatic;
	}

	public void setStatic(String s) {
		this.isStatic = Boolean.parseBoolean(s);
	}

	public boolean isVirtual() {
		return isVirtual;
	}

	public void setVirtual(String s) {
		this.isVirtual = Boolean.parseBoolean(s);
	}

	public String getReturnValue() {
		return returnValue;
	}

	public void setReturnValue(String returnValue) {
		this.returnValue = returnValue;
	}

	public boolean isConst() {
		return isConst;
	}

	public void setConst(String s) {
		this.isConst = Boolean.parseBoolean(s);
	}

	public ArrayList<Attribute> getParameters() {
		return parameters;
	}

	public void setParameters(ArrayList<Attribute> parameters) {
		this.parameters = parameters;
	}
	
}
