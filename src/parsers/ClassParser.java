package parsers;

import model.Enum;

public class ClassParser {
	
	public static String parse(model.Class classPom) {
		String parsed = "class " + classPom.getClassName() + " {\n";
		parsed += "\n}";
		return parsed;
	}

}
