package org.metatrans.apps.balloons.model;


import org.metatrans.apps.balloons.cfg.world.IConfigurationWorld;
import org.metatrans.apps.balloons.model.entities.Entity2D_Challenger_StopTheBalls;
import org.metatrans.apps.balloons.model.entities.Entity2D_Player_StopTheBalls;
import org.metatrans.commons.graphics2d.model.World;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Moving;
import org.metatrans.commons.ui.utils.ScreenUtils;

import android.content.Context;
import android.graphics.RectF;


public class WorldGenerator_StopTheBalls {


	public static int LAST_BALLOONS_COUNT = 55555;


	public static final int getBalloonsCount(float scaleFactor) {

		LAST_BALLOONS_COUNT = (int) (25 * scaleFactor);

		if (LAST_BALLOONS_COUNT < 0) {

			LAST_BALLOONS_COUNT = 0;
		}

		return LAST_BALLOONS_COUNT;
	}


	public static final World generate(Context activity, IConfigurationWorld cfg_world) {


		System.out.println("GAMEDATA GENERATION");


		float spaceScaleFactor = cfg_world.getSpaceMultiplier();

		int[] screen_size = ScreenUtils.getScreenSize(activity);
		int main_width = (int) (1 * Math.max(screen_size[0], screen_size[1]));
		int main_height = (int) (1 * Math.min(screen_size[0], screen_size[1]));

		int cell_size = main_width / 17;

		//World_StopTheBalls world = new World_StopTheBalls(activity, (int) (spaceScaleFactor * main_width), (int) (spaceScaleFactor * main_height));
		World_StopTheBalls world = new World_StopTheBalls(activity, 1, 1, cell_size);


		Entity2D_Moving.ENVELOP_DRAW_UPSIDE = 0.5f;
		Entity2D_Moving.ENVELOP_DRAW_DOWNSIDE = 1 - Entity2D_Moving.ENVELOP_DRAW_UPSIDE;
		Entity2D_Moving.ENVELOP_DRAW_EXTENSION = 1;


		float total_scale = 2.5f;

		float player_scale = 1f * total_scale;

		float player_size = player_scale * cell_size;

		world.addEntity(

				new Entity2D_Player_StopTheBalls(

						world,
						new RectF(
								spaceScaleFactor * main_width / 2 -  player_size / 2,
								spaceScaleFactor * main_height / 2 - player_size / 2,
								spaceScaleFactor * main_width / 2 + player_size / 2,
								spaceScaleFactor * main_height / 2 + player_size / 2
						),
						world.getKillersEntities_forPlayer()
				)
		);


		System.out.println("GAMEDATA GENERATION: Balloons count is " + getBalloonsCount(spaceScaleFactor));

		RectF rect_screen = new RectF(
				spaceScaleFactor * main_width/ 2  - main_width / 2,
				spaceScaleFactor * main_height/ 2 - main_height / 2,
				spaceScaleFactor * main_width / 2 + main_width / 2,
				spaceScaleFactor * main_height / 2 + main_height / 2);

		for (int i = 0; i < getBalloonsCount(spaceScaleFactor); i++) {

			float balloons_scale = 1f * total_scale;
			float balloon_size = balloons_scale * cell_size;

			int x = (int) (spaceScaleFactor * Math.random() * main_width - balloon_size);
			int y = (int) (spaceScaleFactor * Math.random() * main_height - balloon_size);

			x = (int) Math.max(balloon_size, x);
			y = (int) Math.max(balloon_size, y);

			RectF rect = new RectF(x, y, x + balloon_size, y + balloon_size);

			if (rect_screen.contains(rect) || RectF.intersects(rect_screen, rect)) {

				i--;

				continue;

			} else {

				world.addEntity(

					new Entity2D_Challenger_StopTheBalls(
						world,
						rect,
						world.getGroundEntities(),
						world.getKillersEntities_forChallengers(),
						world.getPlayerEntity().getEnvelop().left,
						world.getPlayerEntity().getEnvelop().top,
						cfg_world.getSpeedMultiplier(),
						cfg_world.getBitmapBalloons_Random()
					)
				);
			}
		}


		for (Entity2D_Moving moving: world.getMovingEntities()) {

			moving.setWorldSize(world.get_WORLD_SIZE_X(), world.get_WORLD_SIZE_Y());
		}


		return world;
	}
}

	