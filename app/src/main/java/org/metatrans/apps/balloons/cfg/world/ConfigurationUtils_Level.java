package org.metatrans.apps.balloons.cfg.world;


import org.metatrans.commons.cfg.ConfigurationUtils_Base;
import org.metatrans.commons.cfg.IConfigurationEntry;


public class ConfigurationUtils_Level extends ConfigurationUtils_Base {
	
	
	private static final String TAG_NAME = ConfigurationUtils_Level.class.getName();
	
	
	public static final int LEVEL_ID_DEFAULT = 1;


	private static final int[][] bitmaps_from_to_indexes = new int[][] {
			{0, 2},
			{0, 3},
			{0, 4},
			{0, 5},
			{0, 6},
			{0, 7},
			{0, 8},
			{0, 9},
			{1, 9},
			{2, 9},
			{3, 9},
			{4, 9},
			{5, 9},
			{6, 9},
			{7, 9},
			{8, 9},
			{9, 9},
			{8, 9},
			{7, 9},
			{6, 9},
			{5, 9},
			{4, 9},
			{3, 9},
			{2, 9},
			{1, 9},
			{0, 9},
	};

	
	public static ConfigurationUtils_Level getInstance() {

		return (ConfigurationUtils_Level) getInstance(TAG_NAME);
	}
	
	
	public static void createInstance() {
		
		IConfigurationEntry[] cfgs_levels = new IConfigurationEntry[50];

		float speed_scale = 0.333f;

		for (int i=0; i<cfgs_levels.length; i++) {

			float scaleFactor = (float) (3 + i);

			float speedMultiplier = 1f * speed_scale + 2f * speed_scale * i / (float) cfgs_levels.length;

			int[] from_to_index = get_bitmap_from_to_index(i);

			//System.out.println("Bitmaps from_to_index=[" + from_to_index[0] + ", " + from_to_index[1] + "]");

			cfgs_levels[i] = new Configuration_World(i + 1, scaleFactor, speedMultiplier, from_to_index);
		}
		
		createInstance(TAG_NAME, new ConfigurationUtils_Level(), cfgs_levels);
	}


	private static int[] get_bitmap_from_to_index(int cfg_index) {


		if (cfg_index >= bitmaps_from_to_indexes.length) {

			return new int[] {0, 9};
		}

		return bitmaps_from_to_indexes[cfg_index];
	}


	public IConfigurationWorld getConfigByID(int id) {

		return (IConfigurationWorld) super.getConfigByID(id);
	}
}
