package org.metatrans.apps.balloons.model.entities;


import java.util.List;

import org.metatrans.apps.balloons.model.GameData_StopTheBalls;
import org.metatrans.commons.app.Application_Base;
import org.metatrans.commons.graphics2d.model.World;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Challenger;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Ground;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Moving;
import org.metatrans.commons.graphics2d.model.entities.IEntity2D;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;


public class Entity2D_Challenger_StopTheBalls extends Entity2D_Challenger {
	
	
	private static final long serialVersionUID = 5416967203188382917L;
	
	private int colour;	
	
	
	public Entity2D_Challenger_StopTheBalls(World _world,
			RectF _evelop,
			List<Entity2D_Ground> _blockerEntities,
			List<? extends IEntity2D> _killerEntities,
			float x_player, float y_player, float speedMultiplier, int _colour) {
		
		super(_world, _evelop, _blockerEntities, _killerEntities);
		
		float dx = 1f * (x_player - getEnvelop().left);
		float dy = 1f * (y_player - getEnvelop().top);
		
		float sx = (float) (dx / Math.sqrt(dx * dx + dy * dy));
		float sy = (float) (dy / Math.sqrt(dx * dx + dy * dy));
		
		setSpeed(speedMultiplier * sx *_world.getMaxSpeed_CHALLENGER(), speedMultiplier * sy * _world.getMaxSpeed_CHALLENGER());
		
		colour = _colour;
	}
	
	
	@Override
	protected void killed(Entity2D_Moving killer) {
		
		super.killed(killer);
		
		((GameData_StopTheBalls)Application_Base.getInstance().getGameData()).count_killed_balls++;
	}


	@Override
	protected boolean supportsFeeding() {

		return false;
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
