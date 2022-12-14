package org.metatrans.apps.balloons.menu;


import org.metatrans.apps.balloons.lib.R;
import org.metatrans.apps.balloons.model.BitmapCache_Balloons;

import java.util.HashMap;
import java.util.Map;


public class ConfigurationUtils_WorldView {


	public static final int START_INDEX = 1;


	private static org.metatrans.apps.balloons.menu.IConfiguration_WorldView[] ALL_CFGs;


	static {

		ALL_CFGs = new org.metatrans.apps.balloons.menu.IConfiguration_WorldView[3];

		ALL_CFGs[0] = new Config_WorldView(START_INDEX + 0, R.string.background_fortress, -1, BitmapCache_Balloons.BITMAP_ID_BALLOONS_BACKGROUND_FORTRESS, BitmapCache_Balloons.BITMAP_ID_BALLOONS_ICON_FORTRESS);
		ALL_CFGs[1] = new Config_WorldView(START_INDEX + 1, R.string.background_gradient, -1, BitmapCache_Balloons.BITMAP_ID_BALLOONS_BACKGROUND_GRADIENT, BitmapCache_Balloons.BITMAP_ID_BALLOONS_ICON_GRADIENT);
		ALL_CFGs[2] = new Config_WorldView(START_INDEX + 2, R.string.background_brickwall, -1, BitmapCache_Balloons.BITMAP_ID_BALLOONS_BACKGROUND_BRICKWALL, BitmapCache_Balloons.BITMAP_ID_BALLOONS_ICON_BRICKWALL);
	}

	private static final Map<Integer, IConfiguration_WorldView> mapping = new HashMap<Integer, IConfiguration_WorldView>();
	
	
	static {

		for (int i=0; i<ALL_CFGs.length; i++) {

			org.metatrans.apps.balloons.menu.IConfiguration_WorldView cfg = ALL_CFGs[i];

			if (cfg!= null) {

				Integer id = cfg.getID();

				if (mapping.containsKey(id)) {
					throw new IllegalStateException("Duplicated cfg id: " + id);
				}

				mapping.put(id, cfg);
			}
		}
	}
	
	
	public static org.metatrans.apps.balloons.menu.IConfiguration_WorldView[] getAll() {
		return ALL_CFGs;
	}
	
	
	public static int getID(int orderNumber) {
		return ALL_CFGs[orderNumber].getID();
	}
	
	
	public static org.metatrans.apps.balloons.menu.IConfiguration_WorldView getConfigByID(int id) {

		org.metatrans.apps.balloons.menu.IConfiguration_WorldView result = mapping.get(id);
		
		if (result == null) {
			throw new IllegalStateException("Config with id = " + id + " not found.");
		}
		
		return result;
	}
	
	
	public static int getOrderNumber(int cfgID) {
		for (int i=0; i<ALL_CFGs.length; i++) {
			if (ALL_CFGs[i] != null) {
				Integer id = ALL_CFGs[i].getID();
				if (id == cfgID) {
					return i;
				}
			}
		}

		throw new IllegalStateException("CFG identifier " + cfgID + " not found.");
	}
}
