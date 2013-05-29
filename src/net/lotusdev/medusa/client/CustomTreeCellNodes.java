package net.lotusdev.medusa.client;

import java.util.ArrayList;

public class CustomTreeCellNodes {
	private static ArrayList<Object> treeIcons = new ArrayList<>();
	
	public static void makeTreeIcons() {
		getTreeIcons().add("Email");
		getTreeIcons().add("Timeout");
		getTreeIcons().add("Sent Items");
	}

	public static ArrayList<Object> getTreeIcons() {
		return treeIcons;
	}
}
