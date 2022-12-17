package org.metatrans.apps.balloons.model;


import java.util.ArrayList;
import java.util.List;

import org.metatrans.apps.balloons.cfg.world.ConfigurationUtils_Level;
import org.metatrans.apps.balloons.cfg.world.IConfigurationWorld;
import org.metatrans.apps.balloons.model.entities.Entity2D_Bullet_StopTheBalls;
import org.metatrans.apps.balloons.model.entities.Entity2D_Challenger_StopTheBalls;
import org.metatrans.apps.balloons.model.entities.Entity2D_Player_StopTheBalls;
import org.metatrans.commons.app.Application_Base;
import org.metatrans.commons.cfg.colours.ConfigurationUtils_Colours;
import org.metatrans.commons.graphics2d.model.World;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Bullet;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Challenger;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Moving;
import org.metatrans.commons.graphics2d.model.entities.IEntity2D;
import org.metatrans.commons.model.I2DBitmapCache;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
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


	public World_StopTheBalls(Context _activity, int _maze_size_x, int _maze_size_y) {
		
		super(_activity, _maze_size_x, _maze_size_y);

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

		IConfigurationWorld world_cfg = ConfigurationUtils_Level.getInstance().getConfigByID(Application_Base.getInstance().getUserSettings().modeID);

		float bullet_center_x = bulletEnvelop.left + (bulletEnvelop.right - bulletEnvelop.left) / 2;
		float bullet_center_y = bulletEnvelop.top + (bulletEnvelop.bottom - bulletEnvelop.top) / 2;

		Entity2D_Challenger_StopTheBalls closest_balloon = null;

		List<Entity2D_Moving> moving_entities = getMovingEntities();

		int DISTANCE_INC_STEP = 50;

		int MAX_DISTANCE = (int) Math.max(get_WORLD_SIZE_X(), get_WORLD_SIZE_Y());

		for (int distance = DISTANCE_INC_STEP; distance <= MAX_DISTANCE; distance += DISTANCE_INC_STEP) {

			float bullet_infinity_target_x = bullet_center_x + pointer_x * distance;
			float bullet_infinity_target_y = bullet_center_y + pointer_y * distance;

			Segment ray = new Segment(
					(int) bullet_center_x,
					(int) bullet_center_y,
					(int) bullet_infinity_target_x,
					(int) bullet_infinity_target_y);

			for (Entity2D_Moving cur: moving_entities) {

				if (cur instanceof Entity2D_Challenger_StopTheBalls) {

					if (Segment.intersects2(ray, cur.getEnvelop())) {

						closest_balloon = (Entity2D_Challenger_StopTheBalls) cur;

						break;
					}
				}
			}

			if (closest_balloon != null) {

				break;
			}
		}


		int balloon_bitmap_id;

		if (closest_balloon == null) {

			balloon_bitmap_id = BitmapCache_Balloons.BITMAP_ID_BALLOONS_GRAY_ORG;

		} else {

			balloon_bitmap_id = closest_balloon.getBitmapID();
		}


		int arrow_bitmap_id = world_cfg.getBitmapArrows_ByDirection(balloon_bitmap_id);

		Entity2D_Moving bulletEntity = new Entity2D_Bullet_StopTheBalls(
				this,
				bulletEnvelop,
				getGroundEntities_SolidOnly(), new ArrayList<>(),
				arrow_bitmap_id,
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


	/**
	 * Origin: 	stackoverflow.com
	 * URL: 	https://stackoverflow.com/questions/9935533/android-java-how-to-check-if-a-rectangle-and-a-line-segment-intersect-without-li
	 * Author: 	Oli Charlesworth
	 */
	private static class Segment {

		int x1;
		int y1;
		int x2;
		int y2;
		double m;
		double b;
		boolean ishoriz;
		boolean isvert;

		public Segment(int x1s, int y1s, int x2s, int y2s) {
			if (x1s > x2s) {
				this.x1 = x2s;
				this.x2 = x1s;
			} else {
				this.x1 = x1s;
				this.x2 = x2s;
			}
			if (y1s > y2s) {
				this.y1 = y2s;
				this.y2 = y1s;
			} else {
				this.y1 = y1s;
				this.y2 = y2s;
			}
			int ydif = y2s - y1s;
			int xdif = x2s - x1s;
			if (ydif == 0) {
				this.ishoriz = true;
				this.m = 0;
				this.b = x1s;
			} else if (xdif == 0) {
				this.isvert = true;
			} else {
				this.m = (double) ydif / xdif;
				double r = (double) ydif / xdif;
				this.b = y1s - (r * x1s);
				this.isvert = false;
				this.ishoriz = false;
			}
		}

		public static final boolean intersected(Segment s, Segment s2) {
			if (s.ishoriz && s2.ishoriz) {
				//parallel
				return false;
			}

			if (s.isvert && s2.isvert) {
				//parallel

				return false;
			}

			if (s.isvert) {
				//x is constant see if the x is on the other line
				int x = s.x1;
				//add 2 for round-off error
				if (s2.x1 <= x + 2 && s2.x2 + 2 >= x) {
					//solve and check if y is on both segments
					int y = (int) ((s.m * x) + s.b);
					if (s.y1 <= y + 2 && s.y2 + 2 >= y) {
						if (s2.y1 <= y + 2 && s2.y2 + 2 >= y) {
							return true;
						}
					}
				}
				return false;
			}

			if (s2.isvert) {
				//x is constant see if the x is on the other line
				int x = s2.x1;
				//add 2 for round-off error
				if (s.x1 <= x + 2 && s.x2 + 2 >= x) {
					//solve and check if y is on both segments
					int y = (int) ((s.m * x) + s.b);
					if (s.y1 <= y + 2 && s.y2 + 2 >= y) {
						if (s2.y1 <= y + 2 && s2.y2 + 2 >= y) {
							return true;
						}
					}
				}
				return false;
			}

			if (s.ishoriz) {
				//y is constant see if the y is on the other line
				int y = s.y1;
				//add 2 for round-off error
				if (s2.y1 <= y + 2 && s2.y2 + 2 >= y) {
					//solve and check if x is on both segments
					int x = (int) ((y - s.b) / s.m);
					if (s.x1 <= x + 2 && s.x2 + 2 >= x) {
						if (s2.x1 <= x + 2 && s2.x2 + 2 >= x)
							return true;
					}
					return false;
				}
			}

			if (s2.ishoriz) {
				//y is constant see if the y is on the other line
				int y = s2.y1;
				//add 2 for round-off error
				if (s.y1 <= y + 2 && s.y2 + 2 >= y) {
					//solve and check if x is on both segments
					int x = (int) ((y - s.b) / s.m);
					if (s.x1 <= x + 2 && s.x2 + 2 >= x) {
						if (s2.x1 <= x + 2 && s2.x2 + 2 >= x)
							return true;
					}
				}
				return false;
			}

			if (s.m == s2.m) {
				//parallel
				return false;
			}

			// use substitution
			// (s.m-s2.m)x=s2.b-s.b
			int x = (int) (s.m - s2.m);
			x = (int) ((s2.b - s.b) / x);
			// find y
			int y = (int) ((x * s.m) + s.b);
			//check if the values are in between for both lines
			//add 2 for round-off error
			if (s.y1 <= y + 2) {
				if (s.y2 + 2 >= y) {
					if (s2.y1 <= y + 2) {
						if (s2.y2 + 2 >= y) {
							if (s.x1 <= x + 2) {
								if (s.x2 + 2 >= x) {
									if (s2.x1 <= x + 2) {
										if (s2.x2 + 2 >= x) {
											return true;
										}
									}
								}
							}
						}
					}
				}
			}
			return false;
		}

		public static final boolean intersects2(Segment s, RectF r) {
			//created lines of the rect
			Segment top = new Segment((int) r.left, (int) r.top, (int) r.right, (int) r.top);
			Segment left = new Segment((int) r.left, (int) r.top, (int) r.left, (int) r.bottom);
			Segment bottom = new Segment((int) r.left, (int) r.bottom, (int) r.right, (int) r.bottom);
			Segment right = new Segment((int) r.right, (int) r.top, (int) r.right, (int) r.bottom);
			boolean topp = s.intersected(s, top);
			if (topp) {
				return true;
			}
			boolean leftp = s.intersected(s, left);
			if (leftp) {
				return true;
			}
			boolean bottomp = s.intersected(s, bottom);
			if (bottomp) {
				return true;
			}
			boolean rightp = s.intersected(s, right);
			if (rightp) {
				return true;
			} else {
				return false;
			}
		}
	}
}
