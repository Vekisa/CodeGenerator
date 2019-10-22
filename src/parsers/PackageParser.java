package parsers;

import model.Class;
import model.Item;
import model.Package;

public class PackageParser {
	
	public static String parse(Package packagePom) {
		String parsed = " Name: " + packagePom.getName();
		parsed += "\n Size: 50MB";
		parsed += "\n Elements: \n";
		for(Item item : packagePom.getChildren()) {
			if(item instanceof Package)
				parsed += "\tPackage: " + ((Package)item).getName() + "\n";
			else if(item instanceof Class)
				parsed += "\tClass: " + ((Class)item).getClassName() + "\n";
			else if(item instanceof model.Enum)
				parsed += "\tEnum: " + ((model.Enum)item).getEnumName() + "\n";
		}
		return parsed;
	}
}
