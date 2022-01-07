package org.metatrans.apps.balloons.cfg.world;


import org.metatrans.apps.balloons.lib.R;
import org.metatrans.apps.balloons.model.WorldGenerator_StopTheBalls;
import org.metatrans.commons.app.Application_Base;


public class Configuration_World extends Configuration_World_Base {
	
	
	public Configuration_World(int id, float spaceMultiplier, float speedMultiplier) {
		
		super(id, spaceMultiplier, speedMultiplier);
	}
	
	
	private String getName(float spaceMultiplier) {
		
		String name = Application_Base.getInstance().getString(R.string.level) + " " + getID();
		
		int ballsCount = WorldGenerator_StopTheBalls.getBallsCount(spaceMultiplier);
		
		name += " (" + ballsCount + " " + Application_Base.getInstance().getString(R.string.balls) + ")";
		
		return name;
	}
	
	
	@Override
	public int getName() {
		throw new UnsupportedOperationException();
	}
	
	
	@Override
	public int getIconResID() {
		return R.drawable.ic_star_gold;
	}
	
	
	@Override
	public int getDescription() {
		throw new UnsupportedOperationException();
	}


	@Override
	public String getName_String() {	
		return getName(spaceMultiplier);
	}


	@Override
	public String getDescription_String() {
		return "";
	}
}
