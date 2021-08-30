package org.metatransapps.apps.balloons.cfg.world;


public abstract class Configuration_World_Base implements IConfigurationWorld {
	
	
	private int id;
	private float spaceMultiplier;
	private float speedMultiplier;
	
	
	public Configuration_World_Base(int _id, float _spaceMultiplier, float _speedMultiplier) {
		id = _id;
		spaceMultiplier = _spaceMultiplier;
		speedMultiplier = _speedMultiplier;
	}
	
	
	@Override
	public int getID() {
		return id;
	}
	
	
	@Override
	public float getSpaceMultiplier() {
		return spaceMultiplier;
	}
	
	
	public float getSpeedMultiplier() {
		return speedMultiplier;
	}
}
