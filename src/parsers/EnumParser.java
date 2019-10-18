package parsers;

import model.Enum;

public class EnumParser extends MainParser {

	public static String parse(Enum enumeration) {
		String parsed = "enum " + enumeration.getEnumName() + " {\n";
		for(String s : enumeration.getItems()) {
			if(enumeration.getItems().indexOf(s) != (enumeration.getItems().size() - 1)) {
				parsed += "\t" + s + ",\n";
			}else {
				parsed += "\t" + s;
			}
		}
		parsed += "\n}";
		return parsed;
	}

}
