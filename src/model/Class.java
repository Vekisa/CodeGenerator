package model;

import java.util.ArrayList;

public class Class extends Item {
	
	private String className;
	private ArrayList<String> extendsClasses;
	private ArrayList<String> implementsInterfaces;
	private ArrayList<Attribute> attributes;
	private ArrayList<Operation> operations;
	private boolean defaultConstructor;
	private boolean getters;
	private boolean setters;
	
	public Class ( ) {
		extendsClasses = new ArrayList<String>();
		implementsInterfaces = new ArrayList<String>();
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

	public ArrayList<String> getImplementsInterfaces() {
		return implementsInterfaces;
	}

	public void setImplementsInterfaces(ArrayList<String> implementsInterfaces) {
		this.implementsInterfaces = implementsInterfaces;
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

	public void setDefaultConstructor(String s) {
		this.defaultConstructor = Boolean.parseBoolean(s);
	}

	public boolean isGetters() {
		return getters;
	}

	public void setGetters(String s) {
		this.getters = Boolean.getBoolean(s);
	}

	public boolean isSetters() {
		return setters;
	}

	public void setSetters(String s) {
		this.setters = Boolean.parseBoolean(s);
	}
	
}
