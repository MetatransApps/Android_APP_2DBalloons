package org.metatrans.apps.balloons.cfg.world;


import org.metatrans.commons.cfg.ConfigurationUtils_Base;
import org.metatrans.commons.cfg.IConfigurationEntry;


public class ConfigurationUtils_Level extends ConfigurationUtils_Base {
	
	
	private static final String TAG_NAME = ConfigurationUtils_Level.class.getName();
	
	
	public static final int LEVEL_ID_DEFAULT = 1;
	
	
	public static ConfigurationUtils_Level getInstance() {
		return (ConfigurationUtils_Level) getInstance(TAG_NAME);
	}
	
	
	public static void createInstance() {
		
		IConfigurationEntry[] cfgs_levels = new IConfigurationEntry[50];

		float speed_scale = 0.333f;

		for (int i=0; i<cfgs_levels.length; i++) {

			float scaleFactor = (float) (3 + i);
			float speedMultiplier = 1f * speed_scale + 2f * speed_scale * i / (float) cfgs_levels.length;
			
			cfgs_levels[i] = new Configuration_World(i + 1, scaleFactor, speedMultiplier);
		}
		
		createInstance(TAG_NAME, new ConfigurationUtils_Level(), cfgs_levels);
	}
	
	
	public IConfigurationWorld getConfigByID(int id) {
		return (IConfigurationWorld) super.getConfigByID(id);
	}
}
