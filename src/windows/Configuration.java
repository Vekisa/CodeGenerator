package windows;

import java.awt.Color;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.ImageIcon;

public class Configuration {
	private static Path currentRelativePath = Paths.get("");

	public static Color themeColor = new Color(199,255,248);
	public static Color themeColorToolBar = new Color(180,255,150);
	public static ImageIcon packageIcon = new ImageIcon(currentRelativePath.toAbsolutePath().toString() + "/resources/package.png");
	public static ImageIcon projectIcon = new ImageIcon(currentRelativePath.toAbsolutePath().toString() + "/resources/project.png");
	public static ImageIcon classIcon = new ImageIcon(currentRelativePath.toAbsolutePath().toString() + "/resources/class.png");
	public static ImageIcon folderIcon = new ImageIcon(currentRelativePath.toAbsolutePath().toString() + "/resources/folder.png");
	public static ImageIcon enumIcon = new ImageIcon(currentRelativePath.toAbsolutePath().toString() + "/resources/enum.png");
}
