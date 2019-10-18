package model;

import java.util.ArrayList;

public class Class extends Item {
	
	private String className;
	private ArrayList<String> extendsClasses;
	private ArrayList<String> extendsInterfaces;
	private ArrayList<Attribute> attributes;
	private ArrayList<Operation> operations;
	private boolean defaultConstructor;
	private boolean getters;
	private boolean setters;
	
	public Class ( ) {
		extendsClasses = new ArrayList<String>();
		extendsInterfaces = new ArrayList<String>();
		attributes = new ArrayList<Attribute>();
		operations = new ArrayList<Operation>();
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public ArrayList<String> getExtendsClasses() {
		return extendsClasses;
	}

	public void setExtendsClasses(ArrayList<String> extendsClasses) {
		this.extendsClasses = extendsClasses;
	}

	public ArrayList<String> getExtendsInterfaces() {
		return extendsInterfaces;
	}

	public void setExtendsInterfaces(ArrayList<String> extendsInterfaces) {
		this.extendsInterfaces = extendsInterfaces;
	}

	public ArrayList<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(ArrayList<Attribute> attributes) {
		this.attributes = attributes;
	}

	public ArrayList<Operation> getOperations() {
		return operations;
	}

	public void setOperations(ArrayList<Operation> operations) {
		this.operations = operations;
	}

	public boolean isDefaultConstructor() {
		return defaultConstructor;
	}

	public void setDefaultConstructor(boolean defaultConstructor) {
		this.defaultConstructor = defaultConstructor;
	}

	public boolean isGetters() {
		return getters;
	}

	public void setGetters(boolean getters) {
		this.getters = getters;
	}

	public boolean isSetters() {
		return setters;
	}

	public void setSetters(boolean setters) {
		this.setters = setters;
	}
	
}
