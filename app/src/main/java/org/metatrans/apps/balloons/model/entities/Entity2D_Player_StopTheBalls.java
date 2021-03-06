package org.metatrans.apps.balloons.model.entities;


import java.util.List;

import org.metatrans.apps.balloons.app.Application_StopTheBalls;
import org.metatrans.apps.balloons.model.World_StopTheBalls;
import org.metatrans.commons.app.Application_Base;
import org.metatrans.commons.graphics2d.app.Application_2D_Base;
import org.metatrans.commons.graphics2d.model.GameData;
import org.metatrans.commons.graphics2d.model.World;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Moving;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Player;
import org.metatrans.commons.graphics2d.model.entities.IEntity2D;
import org.metatrans.commons.model.LevelResult_Base;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;


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

		int count_balloons = 0;

		for (Entity2D_Moving moving: getWorld().getMovingEntities()) {

			//if (moving instanceof Entity2D_Challenger_StopTheBalls) {

				count_balloons++;
			//}
		}

		System.out.println("count_balloons=" + count_balloons);

		return count_balloons <= 11;
	}
	
	
	@Override
	protected void killedFinal() {
		
		super.killedFinal();

	}
	
	
	protected GameData getGameData() {
		return (GameData) (Application_StopTheBalls.getInstance()).getGameData();
	}


	@Override
	public Bitmap getBitmap() {

		return null;
	}


	@Override
	public void draw(Canvas c) {
		getPaint().setColor(colour);
		getPaint().setAlpha(255);
		c.drawCircle(getEnvelop().left + (getEnvelop().right - getEnvelop().left) / 2,
					getEnvelop().top + (getEnvelop().bottom - getEnvelop().top) / 2,
					 (getEnvelop().right - getEnvelop().left) / 2,
					 getPaint());
	}
}
