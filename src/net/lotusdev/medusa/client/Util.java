package net.lotusdev.medusa.client;

import javax.swing.ImageIcon;

public class Util {
	public static ImageIcon getIcon(String name) {
		return new ImageIcon(Main.class.getResource("/net/lotusdev/medusa/client/res/" + name + ".png"));
	}
}
