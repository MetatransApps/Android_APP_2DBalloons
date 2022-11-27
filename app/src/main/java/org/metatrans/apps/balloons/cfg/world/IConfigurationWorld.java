package org.metatrans.apps.balloons.cfg.world;


import org.metatrans.commons.cfg.difficulty.IConfigurationDifficulty;


public interface IConfigurationWorld extends IConfigurationDifficulty {
	
	float getSpaceMultiplier();
	float getSpeedMultiplier();
	
	String getName_String();
	String getDescription_String();

    int getBitmapBalloons_Random();
    int getBitmapArrows_Random();
}
