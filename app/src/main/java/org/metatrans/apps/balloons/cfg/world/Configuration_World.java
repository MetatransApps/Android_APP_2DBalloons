package org.metatrans.apps.balloons.cfg.world;


import org.metatrans.apps.balloons.lib.R;
import org.metatrans.apps.balloons.model.WorldGenerator_StopTheBalls;
import org.metatrans.commons.app.Application_Base;


public class Configuration_World extends Configuration_World_Base {
	
	
	public Configuration_World(int id, float spaceMultiplier, float speedMultiplier, int[] _from_to_index) {
		
		super(id, spaceMultiplier, speedMultiplier, _from_to_index);
	}
	
	
	private String getName(float spaceMultiplier) {
		
		String name = Application_Base.getInstance().getString(R.string.level) + " " + getID();

		IConfigurationWorld world_cfg = ConfigurationUtils_Level.getInstance().getConfigByID(getID());

		int count_balloons_all = WorldGenerator_StopTheBalls.getBalloonsCount_Reduced(world_cfg.getSpaceMultiplier());
		
		name += " (" + count_balloons_all + " " + Application_Base.getInstance().getString(R.string.balls) + ")";
		
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
