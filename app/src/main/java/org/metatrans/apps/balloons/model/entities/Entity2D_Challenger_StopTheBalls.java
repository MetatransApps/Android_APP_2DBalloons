package org.metatrans.apps.balloons.model.entities;


import java.util.List;

import org.metatrans.apps.balloons.lib.R;
import org.metatrans.apps.balloons.model.BitmapCache_Balloons;
import org.metatrans.apps.balloons.model.GameData_StopTheBalls;
import org.metatrans.commons.app.Application_Base;
import org.metatrans.commons.graphics2d.model.World;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Challenger;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Ground;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Moving;
import org.metatrans.commons.graphics2d.model.entities.IEntity2D;

import android.graphics.RectF;


public class Entity2D_Challenger_StopTheBalls extends Entity2D_Challenger {


	private static final long serialVersionUID = 5416967203188382917L;


	public Entity2D_Challenger_StopTheBalls(World _world,
			RectF _envelop,
			List<Entity2D_Ground> _blockerEntities,
			List<? extends IEntity2D> _killerEntities,
			float x_player, float y_player, float speedMultiplier, int _bitmap_id) {

		super(_world, _envelop, _blockerEntities, _killerEntities,
				_bitmap_id, 0);
		
		float dx = x_player - getEnvelop().left;
		float dy = y_player - getEnvelop().top;

		float dxy_normalizer = (float) Math.max(1, Math.sqrt(dx * dx + dy * dy));
		float dx_norm = dx / dxy_normalizer;
		float dy_norm = dy / dxy_normalizer;

		float speed_x = dx_norm * speedMultiplier * _world.getMaxSpeed_CHALLENGER();
		float speed_y = dy_norm * speedMultiplier * _world.getMaxSpeed_CHALLENGER();

		if (false && Math.abs(speed_x) < 1 && Math.abs(speed_y) < 1) {

			throw new IllegalStateException("Math.abs(speed_x) <= 1 && Math.abs(speed_y) <= 1");
		}

		setSpeed(speed_x, speed_y);


		float rotation_step = (float) (3.5 - (7 * Math.random()));

		/*if (rotation_step >= 0) {

			rotation_step = rotation_step % 10;
		}
		if (rotation_step < 0) {

			rotation_step = rotation_step % 10;
		}


		if (rotation_step >= 0 && rotation_step < 1) {

			rotation_step = 1;

		} else if (rotation_step < 0 && rotation_step > -1) {

			rotation_step = -1;
		}
		*/

		setRotationStep((int) rotation_step);
	}


	@Override
	protected void killed(Entity2D_Moving killer) {
		
		super.killed(killer);
		
		((GameData_StopTheBalls)Application_Base.getInstance().getGameData()).count_killed_balls++;

		((GameData_StopTheBalls)Application_Base.getInstance().getGameData()).count_leaking_balloons_current_level++;

		//Create Animation

		float explosion_scale = 1f;

		RectF envelop = new RectF();

		envelop.left = getEnvelop().left - explosion_scale * getEnvelop().width();
		envelop.top = getEnvelop().top - explosion_scale * getEnvelop().height();
		envelop.right = getEnvelop().right + explosion_scale * getEnvelop().width();
		envelop.bottom = getEnvelop().bottom + explosion_scale * getEnvelop().height();


		Entity2D_Moving balloon_burst = new Entity2D_Animation_Balloons(
				getWorld(),
				envelop,
				bitmap_id,
				getBurstBitmapSequenceIDs(),
				getRotationDegrees()
		);

		balloon_burst.setWorldSize(getWorld().get_WORLD_SIZE_X(), getWorld().get_WORLD_SIZE_Y());

		getWorld().addEntity(balloon_burst);

		Application_Base.getInstance().getSFXManager().playSound(R.raw.sfx_balloon_popping);
	}


	private int[] getBurstBitmapSequenceIDs() {

		if (bitmap_id == BitmapCache_Balloons.BITMAP_ID_BALLOONS_BLUE_ORG) {

			return new int[] {
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_BLUE_PART_1,
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_BLUE_PART_2,
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_BLUE_PART_3,
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_BLUE_PART_4,
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_BLUE_PART_5,
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_BLUE_PART_6,
			};

		} else if (bitmap_id == BitmapCache_Balloons.BITMAP_ID_BALLOONS_INDIGO_ORG) {

			return new int[] {
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_INDIGO_PART_1,
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_INDIGO_PART_2,
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_INDIGO_PART_3,
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_INDIGO_PART_4,
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_INDIGO_PART_5,
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_INDIGO_PART_6,
			};

		} else if (bitmap_id == BitmapCache_Balloons.BITMAP_ID_BALLOONS_VIOLET_ORG) {

			return new int[] {
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_VIOLET_PART_1,
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_VIOLET_PART_2,
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_VIOLET_PART_3,
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_VIOLET_PART_4,
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_VIOLET_PART_5,
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_VIOLET_PART_6,
			};

		} else if (bitmap_id == BitmapCache_Balloons.BITMAP_ID_BALLOONS_BLACK_ORG) {

			return new int[] {
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_BLACK_PART_1,
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_BLACK_PART_2,
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_BLACK_PART_3,
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_BLACK_PART_4,
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_BLACK_PART_5,
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_BLACK_PART_6,
			};

		} else if (bitmap_id == BitmapCache_Balloons.BITMAP_ID_BALLOONS_WHITE_ORG) {

			return new int[] {
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_WHITE_PART_1,
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_WHITE_PART_2,
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_WHITE_PART_3,
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_WHITE_PART_4,
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_WHITE_PART_5,
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_WHITE_PART_6,
			};

		} else if (bitmap_id == BitmapCache_Balloons.BITMAP_ID_BALLOONS_GRAY_ORG) {

			return new int[] {
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_GRAY_PART_1,
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_GRAY_PART_2,
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_GRAY_PART_3,
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_GRAY_PART_4,
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_GRAY_PART_5,
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_GRAY_PART_6,
			};

		} else if (bitmap_id == BitmapCache_Balloons.BITMAP_ID_BALLOONS_RED_ORG) {

			return new int[] {
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_RED_PART_1,
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_RED_PART_2,
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_RED_PART_3,
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_RED_PART_4,
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_RED_PART_5,
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_RED_PART_6,
			};

		} else if (bitmap_id == BitmapCache_Balloons.BITMAP_ID_BALLOONS_GREEN_ORG) {

			return new int[] {
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_GREEN_PART_1,
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_GREEN_PART_2,
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_GREEN_PART_3,
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_GREEN_PART_4,
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_GREEN_PART_5,
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_GREEN_PART_6,
			};

		} else if (bitmap_id == BitmapCache_Balloons.BITMAP_ID_BALLOONS_YELLOW_ORG) {

			return new int[] {
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_YELLOW_PART_1,
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_YELLOW_PART_2,
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_YELLOW_PART_3,
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_YELLOW_PART_4,
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_YELLOW_PART_5,
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_YELLOW_PART_6,
			};

		} else if (bitmap_id == BitmapCache_Balloons.BITMAP_ID_BALLOONS_ORANGE_ORG) {

			return new int[] {
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_ORANGE_PART_1,
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_ORANGE_PART_2,
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_ORANGE_PART_3,
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_ORANGE_PART_4,
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_ORANGE_PART_5,
					BitmapCache_Balloons.BITMAP_ID_BALLOONS_ORANGE_PART_6,
			};


		} else {

			throw new IllegalStateException("bitmap_id=" + bitmap_id + " not found");
		}
	}


	@Override
	protected boolean supportsFeeding() {

		return false;
	}
}
