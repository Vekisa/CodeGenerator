package parsers;

import model.Enum;
import model.Item;

public class MainParser {

	public static String parse(Item item) {
		if(item instanceof Enum) {
			Enum enumeration = (Enum)item;
			return EnumParser.parse(enumeration);
		}
		
		return "";
	}
}
