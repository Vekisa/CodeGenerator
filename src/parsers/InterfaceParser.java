package parsers;

import model.Attribute;
import model.Operation;

public class InterfaceParser {
	
	public static String parse(model.Interface interfacePom) {
		String parsed = "interface " + interfacePom.getName() + " {\n\n";
		if(!interfacePom.getOperations().isEmpty()) {
			for(Operation operation: interfacePom.getOperations()) {
				parsed += "\t " + operation.getAcsModifier() + " " + operation.getReturnValue() + " " + operation.getName() + "(";
				for(Attribute attribute : operation.getParameters()) {
					if(operation.getParameters().indexOf(attribute) == operation.getParameters().size() - 1)
						parsed += " " + attribute.getType() + " " + attribute.getName() + " ";
					else
						parsed += " " + attribute.getType() + " " + attribute.getName() + ",";
				}
				parsed += ");\n\n";
			}
		}
		
		parsed += "}";
		return parsed;
	}
}
