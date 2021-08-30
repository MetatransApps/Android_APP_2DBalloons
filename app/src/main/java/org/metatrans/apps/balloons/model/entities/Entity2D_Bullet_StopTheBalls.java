package org.metatrans.apps.balloons.model.entities;


import java.util.List;

import org.metatrans.commons.graphics2d.model.World;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Bullet;
import org.metatrans.commons.graphics2d.model.entities.IEntity2D;

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
		
		if (!getWorld().getCamera().contains(getEvelop())) {
			getWorld().removeMovingEntity(this);
		}
	}
	
	
	@Override
	protected void killed() {
		getWorld().removeMovingEntity(this);
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
