package parsers;

import model.Attribute;
import model.Operation;

public class ClassParser {
	
	public static String parse(model.Class classPom) {
		String parsed = "class " + classPom.getClassName();
		if(!classPom.getExtendsClasses().isEmpty() || !classPom.getImplementsInterfaces().isEmpty()) {
			if(!classPom.getExtendsClasses().isEmpty())
				parsed += " extends " + classPom.getExtendsClasses().get(0);
			
			if(!classPom.getImplementsInterfaces().isEmpty()) {
				parsed += " implements ";
				for(String interfacePom : classPom.getImplementsInterfaces())
					if(classPom.getImplementsInterfaces().indexOf(interfacePom) == classPom.getImplementsInterfaces().size() - 1)
						parsed += interfacePom + " {\n\n";
					else
						parsed += interfacePom + ", ";
			}
		}else {
			parsed += " {\n\n";
		}
		
		if(!classPom.getAttributes().isEmpty()) {
			for(Attribute attribute: classPom.getAttributes()) {
				parsed += "\t";
				parsed += attribute.getAcsModifier() + " ";
				if(attribute.isStatic())
					parsed += "static ";
				if(attribute.isConst())
					parsed += "const ";
				parsed += attribute.getType() + " " + attribute.getName() + ";\n";
			}
			parsed += "\n";
		}
		
		if(classPom.isDefaultConstructor())
			parsed += "\t public " + classPom.getClassName() + "() { \n\t }\n\n";
		
		if(!classPom.getOperations().isEmpty()) {
			for(Operation operation : classPom.getOperations()) {
				parsed += "\t " + operation.getAcsModifier() + " " + operation.getReturnValue() + " " + operation.getName() + "(";
				for(Attribute attribute : operation.getParameters()) {
					if(operation.getParameters().indexOf(attribute) == operation.getParameters().size() - 1)
						parsed += " " + attribute.getType() + " " + attribute.getName() + " ";
					else
						parsed += " " + attribute.getType() + " " + attribute.getName() + ",";
				}
				parsed += "){\n\t}\n\n";
			}
		}
		
		for(Attribute attribute : classPom.getAttributes()) {
			if(attribute.isGetter()) 
				parsed += "\tpublic " + attribute.getType() + " get" + attribute.getName() +
					"() { return this." + attribute.getName() + "; }\n\n";
			if(attribute.isSetter())
				parsed += "\tpublic void set" + attribute.getName() + "(" + attribute.getType() +
					" " + attribute.getName() + "){ this." + attribute.getName() + " = " + attribute.getName() + "; }\n\n";
		}
		
		
		parsed += "}";
		return parsed;
	}

}
