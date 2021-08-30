package org.metatrans.apps.balloons.cfg.world;


import org.metatrans.commons.cfg.difficulty.IConfigurationDifficulty;


public interface IConfigurationWorld extends IConfigurationDifficulty {
	
	public float getSpaceMultiplier();
	public float getSpeedMultiplier();
	
	public String getName_String();
	public String getDescription_String();
	
}
