package org.metatrans.apps.balloons.model.entities;


import java.util.List;

import org.metatrans.apps.balloons.app.Application_StopTheBalls;
import org.metatrans.apps.balloons.cfg.world.ConfigurationUtils_Level;
import org.metatrans.apps.balloons.cfg.world.IConfigurationWorld;
import org.metatrans.apps.balloons.model.BitmapCache_Balloons;
import org.metatrans.apps.balloons.model.GameData_StopTheBalls;
import org.metatrans.apps.balloons.model.WorldGenerator_StopTheBalls;
import org.metatrans.apps.balloons.model.World_StopTheBalls;
import org.metatrans.commons.app.Application_Base;
import org.metatrans.commons.graphics2d.app.Application_2D_Base;
import org.metatrans.commons.graphics2d.model.GameData;
import org.metatrans.commons.graphics2d.model.World;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Player;
import org.metatrans.commons.graphics2d.model.entities.IEntity2D;
import org.metatrans.commons.model.LevelResult_Base;

import android.graphics.Bitmap;
import android.graphics.RectF;


public class Entity2D_Player_StopTheBalls extends Entity2D_Player {
	
	
	private static final long serialVersionUID = 564766339328166322L;


	private static final int ROTATION_ERROR = 16; //In degrees


	private boolean crossbow_loaded;


	public Entity2D_Player_StopTheBalls(World _world, RectF _evelop,
			List<? extends IEntity2D> _killerEntities) {

		super(_world, _evelop, _world.getGroundEntities_SolidOnly(), _killerEntities,

				BitmapCache_Balloons.BITMAP_ID_CROSSBOW_1, 0);
	}


	@Override
	public RectF getEnvelop_ForDraw() {

		RectF target = new RectF();

		target.left = getWorld().getCamera().left +
						(getWorld().getCamera().right - getWorld().getCamera().left) / 2 - getEnvelop().width() / 2;
		target.right = target.left + getEnvelop().width();
		target.top = getWorld().getCamera().top +
						(getWorld().getCamera().bottom - getWorld().getCamera().top) / 2 - getEnvelop().height() / 2;
		target.bottom = target.top + getEnvelop().height();

		return target;
	}


	public void setLoaded(boolean _crossbow_loaded) {

		crossbow_loaded = _crossbow_loaded;
	}


	@Override
	public Bitmap getBitmap() {


		if (crossbow_loaded) {

			bitmap_id = BitmapCache_Balloons.BITMAP_ID_CROSSBOW_1;

		} else {

			bitmap_id = BitmapCache_Balloons.BITMAP_ID_CROSSBOW_2;

		}

		return super.getBitmap();
	}


	@Override
	protected World_StopTheBalls getWorld() {
		return (World_StopTheBalls) super.getWorld();
	}


	protected GameData getGameData() {

		return (GameData) (Application_StopTheBalls.getInstance()).getGameData();
	}


	@Override
	protected void rotate() {

		//super.rotate();

		float direction_x = getWorld().getPointer_X();
		float direction_y = getWorld().getPointer_Y();

		if (direction_x != 0 && direction_y != 0) {

			//cur_bitmap_rotation_degrees = (int) (Math.random() * 359);
			//cur_bitmap_rotation_degrees = (int) (fire_x / fire_y);
			cur_bitmap_rotation_degrees = (int) -(Math.toDegrees(Math.atan2(direction_y, direction_x) + 360) % 360);
			cur_bitmap_rotation_degrees += ROTATION_ERROR;
		}
	}


	@Override
	protected boolean drawContourCircle() {

		return true;
	}


	@Override
	public void nextMoment(float takts) {
		
		super.nextMoment(takts);
		
		if (!getGameData().level_completed && levelCompletedCondition()) {
			
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

			((GameData_StopTheBalls) Application_Base.getInstance().getGameData()).count_leaking_balloons_current_level = 0;

			//Application_Base_Ads.getInstance().openInterstitial();

		} else {

			if (getGameData().count_lives <= 0) {

				killedFinal();

				getGameData().count_lives = 0;
			}
		}
	}
	
	
	protected boolean levelCompletedCondition() {

		int count_balloons = getCount_Balloons();

		//System.out.println("count_balloons=" + count_balloons);

		return count_balloons <= 0;
	}


	public int getCount_Balloons() {

		IConfigurationWorld world_cfg = ConfigurationUtils_Level.getInstance().getConfigByID(Application_Base.getInstance().getUserSettings().modeID);

		int count_balloons_all = WorldGenerator_StopTheBalls.getBalloonsCount_Reduced(world_cfg.getSpaceMultiplier());

		int count_balloons_to_complete_level = count_balloons_all
				- ((GameData_StopTheBalls) Application_Base.getInstance().getGameData()).count_leaking_balloons_current_level;

		if (count_balloons_to_complete_level < 0) {

			count_balloons_to_complete_level = 0;
		}

		return count_balloons_to_complete_level;
	}
}
