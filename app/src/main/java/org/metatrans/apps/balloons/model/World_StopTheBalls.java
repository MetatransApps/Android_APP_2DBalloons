package org.metatrans.apps.balloons.model;


import java.util.ArrayList;
import java.util.List;

import org.metatrans.apps.balloons.model.entities.Entity2D_Bullet_StopTheBalls;
import org.metatrans.apps.balloons.model.entities.Entity2D_Player_StopTheBalls;
import org.metatrans.commons.graphics2d.model.World;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Bullet;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Challenger;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Moving;
import org.metatrans.commons.graphics2d.model.entities.I2DBitmapCache;
import org.metatrans.commons.graphics2d.model.entities.IEntity2D;

import android.content.Context;
import android.graphics.RectF;


public class World_StopTheBalls extends World {
	
	
	private static final long serialVersionUID = 3276469433687306613L;


	private static final int produce_shot_frequency_div = 2;

	
	private List<IEntity2D> killersEntities_forPlayer;
	private List<IEntity2D> killersEntities_forChallengers;

	private boolean fire_on;
	private float pointer_x;
	private float pointer_y;

	private int produce_shot_frequency_counter;

	private Entity2D_Moving loaded_bulletEntity;


	public World_StopTheBalls(Context _activity, int _maze_size_x, int _maze_size_y, int cell_size) {
		
		super(_activity, _maze_size_x, _maze_size_y);

		setCellSize(cell_size);

		SPEED_MAX_CHALLENGER = 1 * SPEED_MAX_CHALLENGER / 2;
		
		killersEntities_forPlayer 		= new ArrayList<IEntity2D>();
		killersEntities_forChallengers 	= new ArrayList<IEntity2D>();
	}


	public void setFireVector(float x, float y) {

		float dx = x + getCamera().left - getPlayerEntity().getEnvelop().left
				- (getPlayerEntity().getEnvelop().right - getPlayerEntity().getEnvelop().left) / 2;
		float dy = y + getCamera().top - getPlayerEntity().getEnvelop().top
				- (getPlayerEntity().getEnvelop().bottom - getPlayerEntity().getEnvelop().top) / 2;

		if (dx != 0 && dy != 0) {

			fire_on = true;
			pointer_x = (float) (dx / Math.sqrt(dx * dx + dy * dy));
			pointer_y = (float) (dy / Math.sqrt(dx * dx + dy * dy));
		}
	}
	

	public float getPointer_X() {

		return pointer_x;
	}


	public float getPointer_Y() {

		return pointer_y;
	}


	@Override
	public synchronized void update() {

		produce_shot_frequency_counter++;

		if (loaded_bulletEntity != null) {

			removeMovingEntity(loaded_bulletEntity);
		}

		loaded_bulletEntity = createBulletEntity();

		addEntity(loaded_bulletEntity);

		if (fire_on) {

			if (isShooting()) {

				((Entity2D_Player_StopTheBalls) getPlayerEntity()).setLoaded(false);

				produceShot();

			} else {

				((Entity2D_Player_StopTheBalls) getPlayerEntity()).setLoaded(true);
			}

		} else {

			produce_shot_frequency_counter = 0;
		}

		super.update();
	}

	private boolean isShooting() {

		return produce_shot_frequency_counter % produce_shot_frequency_div == 0;
	}


	public void produceShot() {

		if (pointer_x != 0 && pointer_y != 0) {

			if (fire_on) {

				if (isShooting()) {

					loaded_bulletEntity.setSpeed(pointer_x * getMaxSpeed_BULLET(), pointer_y * getMaxSpeed_BULLET());

					addEntity(loaded_bulletEntity);

					loaded_bulletEntity = null;
				}
			}

			fire_on = false;
		}
	}


	private Entity2D_Moving createBulletEntity() {

		RectF playerEnvelop = getPlayerEntity().getEnvelop();

		float bullet_scale = 0.15f; //0.21f
		float bullet_width_function = bullet_scale * playerEnvelop.width();
		float bullet_height_function = bullet_scale * playerEnvelop.height();
		float bullet_shift = 0.33f * Math.max(playerEnvelop.width(), playerEnvelop.height());

		float shift_x = 0; //getPlayerEntity().getEnvelop().left + getPlayerEntity().getEnvelop().width() / 2;
		float shift_y = 0; //getPlayerEntity().getEnvelop().top + getPlayerEntity().getEnvelop().height() / 2;

		RectF bulletEnvelop = new RectF(
				shift_x + pointer_x * bullet_shift + playerEnvelop.left + bullet_width_function,
				shift_y + pointer_y * bullet_shift + playerEnvelop.top + bullet_height_function,
				shift_x + pointer_x * bullet_shift + playerEnvelop.right - bullet_width_function,
				shift_y + pointer_y * bullet_shift + playerEnvelop.bottom - bullet_height_function
		);

		/*RectF bulletEnvelop = new RectF(
				pointer_x * bullet_shift + playerEnvelop.left - bullet_width_function,
				pointer_y * bullet_shift + playerEnvelop.top - bullet_height_function,
				pointer_x * bullet_shift + playerEnvelop.right + bullet_width_function,
				pointer_y * bullet_shift + playerEnvelop.bottom + bullet_height_function
		);
		*/

		int bitmap_id = WorldGenerator_StopTheBalls.getBitmapArrows_Random();

		Entity2D_Moving bulletEntity = new Entity2D_Bullet_StopTheBalls(
				this,
				bulletEnvelop,
				getGroundEntities_SolidOnly(), new ArrayList<>(),
				bitmap_id,
				getPlayerEntity().getRotationDegrees()
		);


		bulletEntity.setWorldSize(get_WORLD_SIZE_X(), get_WORLD_SIZE_Y());

		return bulletEntity;
	}


	@Override
	protected I2DBitmapCache createBitmapCache() {

		return BitmapCache_Balloons.getStaticInstance(BitmapCache_Balloons.BITMAP_ID_COMMON);
	}


	@Override
	public boolean hasToDrawPlayerLast() {

		return false;
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
}
