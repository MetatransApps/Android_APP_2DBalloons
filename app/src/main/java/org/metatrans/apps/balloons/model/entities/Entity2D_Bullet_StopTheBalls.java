package org.metatrans.apps.balloons.model.entities;


import java.util.List;

import org.metatrans.apps.balloons.model.World_StopTheBalls;
import org.metatrans.commons.graphics2d.model.World;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Bullet;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Moving;
import org.metatrans.commons.graphics2d.model.entities.IEntity2D;

import android.graphics.RectF;


public class Entity2D_Bullet_StopTheBalls extends Entity2D_Bullet {
	
	
	private static final long serialVersionUID = -2015301064405980601L;


	private int fixed_rotation_angle_in_degrees;


	public Entity2D_Bullet_StopTheBalls(
										World _world,
										RectF _envelop,
										List<? extends IEntity2D> _blockerEntities,
										List<? extends IEntity2D> _killerEntities,
										int bitmap_id, int rotation_angle_in_degrees) {

		super(_world,
				_envelop,
				_blockerEntities, _killerEntities,
				bitmap_id, rotation_angle_in_degrees);

		fixed_rotation_angle_in_degrees =  rotation_angle_in_degrees;
	}


	@Override
	protected World_StopTheBalls getWorld() {

		return (World_StopTheBalls) super.getWorld();
	}


	@Override
	protected void rotate() {

		cur_bitmap_rotation_degrees = fixed_rotation_angle_in_degrees;
	}


	@Override
	public void nextMoment(float takts) {
		
		super.nextMoment(takts);
		
		if (!getWorld().getCamera().contains(getEnvelop())) {

			//System.out.println("Bullet out of screen");

			getWorld().removeMovingEntity(this);
		}
	}
	
	
	@Override
	protected void killed(Entity2D_Moving killer) {

		//System.out.println("Bullet destroyed");

		getWorld().removeMovingEntity(this);
	}
}
