package org.metatrans.apps.balloons.model;


import org.metatrans.apps.balloons.cfg.world.IConfigurationWorld;
import org.metatrans.apps.balloons.model.entities.Entity2D_Challenger_StopTheBalls;
import org.metatrans.apps.balloons.model.entities.Entity2D_Player_StopTheBalls;
import org.metatrans.apps.balloons.model.entities.Entity2D_Terrain_Balloons;
import org.metatrans.commons.graphics2d.model.World;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Moving;
import org.metatrans.commons.ui.utils.ScreenUtils;

import android.content.Context;
import android.graphics.RectF;


public class WorldGenerator_StopTheBalls {


	public static final int getBalloonsCount_Reduced(float scaleFactor) {

		int all_balloons = getBalloonsCount(scaleFactor);

		all_balloons = all_balloons - (int) (0.25f * all_balloons);

		return all_balloons;
	}


	private static final int getBalloonsCount(float scaleFactor) {

		return (int) (25 * scaleFactor);
	}


	public static final World generate(Context activity, IConfigurationWorld cfg_world) {


		System.out.println("GAMEDATA GENERATION");


		float spaceScaleFactor = cfg_world.getSpaceMultiplier();

		int[] screen_size = ScreenUtils.getScreenSize();
		int main_width = Math.max(screen_size[0], screen_size[1]);
		int main_height = Math.min(screen_size[0], screen_size[1]);

		int cell_size = main_width / 17;

		//World_StopTheBalls world = new World_StopTheBalls(activity, (int) (spaceScaleFactor * main_width), (int) (spaceScaleFactor * main_height));
		World_StopTheBalls world = new World_StopTheBalls(activity, 1, 1);
		world.setCellSize(cell_size);


		float total_scale = 2.25f;

		float player_scale = 1f * total_scale;

		float player_size = player_scale * cell_size;

		float space_center_x = spaceScaleFactor * main_width / 2;
		float space_center_y = spaceScaleFactor * main_height / 2;


		System.out.println("GAMEDATA GENERATION: Balloons count is " + getBalloonsCount(spaceScaleFactor));

		RectF screen_rectangle = new RectF(
				space_center_x - main_width / 2,
				space_center_y - main_height / 2,
				space_center_x + main_width / 2,
				space_center_y + main_height / 2
		);

		for (int i = 0; i < getBalloonsCount(spaceScaleFactor); i++) {

			float balloons_scale = 1f * total_scale;
			float balloon_size = balloons_scale * cell_size;

			int x = (int) (spaceScaleFactor * Math.random() * main_width - balloon_size);
			int y = (int) (spaceScaleFactor * Math.random() * main_height - balloon_size);

			x = (int) Math.max(balloon_size, x);
			y = (int) Math.max(balloon_size, y);

			RectF rect = new RectF(x, y, x + balloon_size, y + balloon_size);

			if (screen_rectangle.contains(rect) || RectF.intersects(screen_rectangle, rect)) {

				i--;

				continue;

			} else {

				world.addEntity(

					new Entity2D_Challenger_StopTheBalls(
						world,
						rect,
						world.getGroundEntities(),
						world.getKillersEntities_forChallengers(),
						space_center_x,
						space_center_y,
						cfg_world.getSpeedMultiplier(),
						cfg_world.getBitmapBalloons_Random()
					)
				);
			}
		}


		world.addEntity(

				new Entity2D_Terrain_Balloons(

						world
				)
		);


		for (Entity2D_Moving moving: world.getMovingEntities()) {

			moving.setWorldSize(world.get_WORLD_SIZE_X(), world.get_WORLD_SIZE_Y());
		}

		RectF player_rectangle = new RectF(
				space_center_x - player_size / 2,
				space_center_y - player_size / 2,
				space_center_x + player_size / 2,
				space_center_y + player_size / 2
		);


		world.addEntity(

				new Entity2D_Player_StopTheBalls(

						world,
						player_rectangle,
						world.getKillersEntities_forPlayer()
				)
		);


		return world;
	}
}

	