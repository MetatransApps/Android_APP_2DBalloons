package com.stoptheballs.model;


import java.util.ArrayList;
import java.util.List;

import org.metatransapps.commons.app.Application_Base;
import org.metatransapps.commons.cfg.colours.ConfigurationUtils_Colours;
import org.metatransapps.commons.graphics2d.model.World;
import org.metatransapps.commons.graphics2d.model.entities.Entity2D_Bullet;
import org.metatransapps.commons.graphics2d.model.entities.Entity2D_Challenger;
import org.metatransapps.commons.graphics2d.model.entities.Entity2D_Moving;
import org.metatransapps.commons.graphics2d.model.entities.IEntity2D;
import org.metatransapps.commons.ui.utils.BitmapUtils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;

import com.stoptheballs.lib.R;
import com.stoptheballs.model.entities.Entity2D_Bullet_StopTheBalls;


public class World_StopTheBalls extends World {
	
	
	private static final long serialVersionUID = 3276469433687306613L;
	
	
	private static Bitmap bitmap_level;
	private static Bitmap bitmap_balls;
	
	private List<IEntity2D> killersEntities_forPlayer;
	private List<IEntity2D> killersEntities_forChallengers;
	
	
	public World_StopTheBalls(Context _activity) {
		
		super(_activity);
		
		SPEED_MAX_CHALLENGER = 1 * SPEED_MAX_CHALLENGER / 2;
		
		killersEntities_forPlayer 		= new ArrayList<IEntity2D>();
		killersEntities_forChallengers 	= new ArrayList<IEntity2D>();
	}
	
	
	public void createBullet(float x, float y) {
		
		int border = 20;
		
		RectF bulletEnvelop = new RectF(getPlayerEntity().getEvelop().left + border,
				getPlayerEntity().getEvelop().top + border,
				getPlayerEntity().getEvelop().right - border,
				getPlayerEntity().getEvelop().bottom - border);
		
		Entity2D_Moving bulletEntity = new Entity2D_Bullet_StopTheBalls(this, bulletEnvelop, getGroundEntities_SolidOnly(), getKillersEntities_forPlayer(),
				ConfigurationUtils_Colours.getConfigByID(Application_Base.getInstance().getUserSettings().uiColoursID).getColour_Square_ValidSelection());
		
		float dx = x + getCamera().left - getPlayerEntity().getEvelop().left;
		float dy = y + getCamera().top - getPlayerEntity().getEvelop().top;
		
		if (dx != 0 && dy != 0) {
		
			float sx = (float) (dx / Math.sqrt(dx * dx + dy * dy));
			float sy = (float) (dy / Math.sqrt(dx * dx + dy * dy));
			
			bulletEntity.setSpeed(sx * getMaxSpeed_BULLET(), sy * getMaxSpeed_BULLET());
			
			addEntity(bulletEntity);
		}
	}
	
	
	private static void initBitmaps() {
		
		System.out.println("!EXPENSIVE OP: RE-INIT BITMAPS OF THE WORLD");
		
		bitmap_level   	= BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_level);
		bitmap_balls   	= BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_ball_green);
	}
	
	
	@Override
	public synchronized void addEntity(IEntity2D entity) {
		
		super.addEntity(entity);
		
		if (entity instanceof Entity2D_Challenger) {
			killersEntities_forPlayer.add(entity);
		}
		
		if (entity instanceof Entity2D_Bullet) {
			killersEntities_forChallengers.add(entity);
		}
		
		if (getSpecialEntities().size() > 1) {
			throw new IllegalStateException();
		}
	}
	
	
	@Override
	public synchronized void removeMovingEntity(Entity2D_Moving entity) {
		
		super.removeMovingEntity(entity);
		
		if (entity instanceof Entity2D_Challenger) {
			killersEntities_forPlayer.remove(entity);
		}
		
		if (entity instanceof Entity2D_Bullet) {
			killersEntities_forChallengers.remove(entity);
		}
	}
	
	
	@Override
	public synchronized void button1(float dx, float dy) {
		
		//((Entity2D_Player_Labyrints)getPlayerEntity()).shot(dx, dy);
		
	}
	
	
	protected List<IEntity2D> getKillersEntities_forPlayer() {
		return killersEntities_forPlayer;
	}
	
	
	protected List<IEntity2D> getKillersEntities_forChallengers() {
		return killersEntities_forChallengers;
	}
	
	
	public static Bitmap getBitmap_level() {
		if (bitmap_level == null || bitmap_level.isRecycled()) {
			initBitmaps();
		}
		return bitmap_level;
	}
	
	
	public static Bitmap getBitmap_balls() {
		if (bitmap_balls == null || bitmap_balls.isRecycled()) {
			initBitmaps();
		}
		return bitmap_balls;
	}
}
