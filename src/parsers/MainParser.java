package parsers;

import model.Enum;
import model.Item;

public class MainParser {

	public static String parse(Item item) {
		if(item instanceof Enum) {
			Enum enumeration = (Enum)item;
			return EnumParser.parse(enumeration);
		}else if(item instanceof model.Class) {
			model.Class classPom = (model.Class)item;
			return ClassParser.parse(classPom);
		}else if(item instanceof model.Package) {
			model.Package packagePom = (model.Package)item;
			return PackageParser.parse(packagePom);
		}else if(item instanceof model.Interface) {
			model.Interface interfacePom = (model.Interface)item;
			return InterfaceParser.parse(interfacePom);
		}
		
		return "";
	}
}
