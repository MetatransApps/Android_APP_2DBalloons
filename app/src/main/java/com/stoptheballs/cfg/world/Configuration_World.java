package com.stoptheballs.cfg.world;


import com.apps.mobile.android.commons.app.Application_Base;
import com.stoptheballs.lib.R;
import com.stoptheballs.model.WorldGenerator_StopTheBalls;


public class Configuration_World extends Configuration_World_Base {
	
	
	private String name;
	private String description;
	
	
	public Configuration_World(int id, float spaceMultiplier, float speedMultiplier) {
		
		super(id, spaceMultiplier, speedMultiplier);
		
		description = getDescription(spaceMultiplier);
		name 		= getName(spaceMultiplier);
	}
	
	
	private String getDescription(float spaceMultiplier) {
		
		//int[] cells_count = WorldGenerator_Labyrints.getCellsCount(spaceMultiplier);
		return ""; //"Cells " + cells_count[0] + "x" + cells_count[1] + ", Enemies " + challengers;
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
		return name;
	}


	@Override
	public String getDescription_String() {
		return description;
	}
}
