package model;

import java.util.ArrayList;

public class Operation {
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

	public void setStatic(boolean isStatic) {
		this.isStatic = isStatic;
	}

	public boolean isVirtual() {
		return isVirtual;
	}

	public void setVirtual(boolean isVirtual) {
		this.isVirtual = isVirtual;
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

	public void setConst(boolean isConst) {
		this.isConst = isConst;
	}

	public ArrayList<Attribute> getParameters() {
		return parameters;
	}

	public void setParameters(ArrayList<Attribute> parameters) {
		this.parameters = parameters;
	}
	
}
