package com.stoptheballs.model.entities;


import java.util.List;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.RectF;

import com.apps.mobile.android.commons.app.Application_Base;
import com.apps.mobile.android.commons.app.Application_Base_Ads;
import com.apps.mobile.android.commons.graphics2d.app.Application_2D_Base;
import com.apps.mobile.android.commons.graphics2d.model.GameData;
import com.apps.mobile.android.commons.graphics2d.model.World;
import com.apps.mobile.android.commons.graphics2d.model.entities.Entity2D_Player;
import com.apps.mobile.android.commons.graphics2d.model.entities.IEntity2D;
import com.apps.mobile.android.commons.model.LevelResult_Base;
import com.stoptheballs.app.Application_StopTheBalls;
import com.stoptheballs.main.Activity_Result;
import com.stoptheballs.model.World_StopTheBalls;


public class Entity2D_Player_StopTheBalls extends Entity2D_Player {
	
	
	private static final long serialVersionUID = 564766339328166322L;
	
	
	private int colour;
	
	
	public Entity2D_Player_StopTheBalls(World _world, RectF _evelop,
			List<? extends IEntity2D> _killerEntities, int _colour) {
		super(_world, _evelop, _world.getGroundEntities_SolidOnly(), _killerEntities);
		
		colour = _colour;
	}
	
	
	@Override
	protected World_StopTheBalls getWorld() {
		return (World_StopTheBalls) super.getWorld();
	}
	
	
	protected Class<? extends Activity> getActivityResult_Class() {
		return Activity_Result.class;
	}
	
	
	@Override
	public void nextMoment(float takts) {
		
		super.nextMoment(takts);
		
		if (levelCompletedCondition()) {
			
			getGameData().level_completed = true;
			
			getGameData().count_stars = 3;//Work around
			
			LevelResult_Base levelResult = Application_2D_Base.getInstance().getLevelsResults().getResult(Application_2D_Base.getInstance().getUserSettings().modeID);
			
			levelResult.setCount_stars(getGameData().count_stars);
			Application_2D_Base.getInstance().storeLevelsResults();
			
			if (getGameData().count_stars >= 3) {
				Application_2D_Base.getInstance().setNextLevel();
			}
			getGameData().last_count_stars = getGameData().count_stars;
			getGameData().count_stars = 0;
			
			getGameData().total_count_steps += getGameData().count_steps;
			getGameData().count_steps = 0;
			
			getGameData().world = Application_2D_Base.getInstance().createNewWorld();
			
			Application_Base.getInstance().storeGameData();
			
			//Application_Base_Ads.getInstance().openInterstitial();
		}
	}
	
	
	protected boolean levelCompletedCondition() {
		return getWorld().getMovingEntities().size() <= 10;
	}
	
	
	@Override
	protected void killedFinal() {
		
		super.killedFinal();
		
		Application_Base_Ads.getInstance().openInterstitial();
	}
	
	
	protected GameData getGameData() {
		return (GameData) (Application_StopTheBalls.getInstance()).getGameData();
	}
	
	
	@Override
	public void draw(Canvas c) {
		getPaint().setColor(colour);
		getPaint().setAlpha(255);
		c.drawCircle(getEvelop().left + (getEvelop().right - getEvelop().left) / 2,
					 getEvelop().top + (getEvelop().bottom - getEvelop().top) / 2,
					 (getEvelop().right - getEvelop().left) / 2,
					 getPaint());
	}
}
