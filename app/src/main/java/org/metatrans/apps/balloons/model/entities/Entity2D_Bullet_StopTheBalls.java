package org.metatrans.apps.balloons.model.entities;


import java.util.List;

import org.metatrans.commons.graphics2d.model.World;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Bullet;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Moving;
import org.metatrans.commons.graphics2d.model.entities.IEntity2D;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;


public class Entity2D_Bullet_StopTheBalls extends Entity2D_Bullet {
	
	
	private static final long serialVersionUID = -2015301064405980601L;
	
	private int colour;
	
	
	public Entity2D_Bullet_StopTheBalls(World _world, RectF _evelop, List<? extends IEntity2D> _blockerEntities, List<? extends IEntity2D> _killerEntities, int _colour) {
		
		super(_world, _evelop, _blockerEntities, _killerEntities);
		
		colour = _colour;
	}
	
	
	@Override
	public void nextMoment(float takts) {
		
		super.nextMoment(takts);
		
		if (!getWorld().getCamera().contains(getEnvelop())) {

			getWorld().removeMovingEntity(this);
		}
	}
	
	
	@Override
	protected void killed(Entity2D_Moving killer) {

		getWorld().removeMovingEntity(this);
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
