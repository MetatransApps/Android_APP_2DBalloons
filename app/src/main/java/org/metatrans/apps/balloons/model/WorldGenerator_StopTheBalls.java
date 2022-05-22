package org.metatrans.apps.balloons.model;


import java.util.Random;

import org.metatrans.apps.balloons.cfg.world.IConfigurationWorld;
import org.metatrans.apps.balloons.model.entities.Entity2D_Challenger_StopTheBalls;
import org.metatrans.apps.balloons.model.entities.Entity2D_Player_StopTheBalls;
import org.metatrans.commons.app.Application_Base;
import org.metatrans.commons.cfg.colours.ConfigurationUtils_Colours;
import org.metatrans.commons.graphics2d.model.World;
import org.metatrans.commons.ui.utils.ScreenUtils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.RectF;


public class WorldGenerator_StopTheBalls {
	
	
	public static int getBallsCount(float scaleFactor) {
		return (int) (75 * scaleFactor);
	}
	
	
	public static World generate(Context activity, IConfigurationWorld cfg_world) {
		
		System.out.println("GAMEDATA GENERATION");
		
		float spaceScaleFactor = cfg_world.getSpaceMultiplier();
		
		int[] screen_size = ScreenUtils.getScreenSize(activity);
		int main_width = (int) (1 * Math.max(screen_size[0], screen_size[1]));
		int main_height = (int) (1 * Math.min(screen_size[0], screen_size[1]));
		
		int cell_size = main_width / 17;

		//World_StopTheBalls world = new World_StopTheBalls(activity, (int) (spaceScaleFactor * main_width), (int) (spaceScaleFactor * main_height));
		World_StopTheBalls world = new World_StopTheBalls(activity, 0, 0);

		world.setCellSize(cell_size);//Buttons size
		
		world.addEntity(new Entity2D_Player_StopTheBalls(world,
				new RectF(spaceScaleFactor / 2 * main_width - cell_size / 2,
						spaceScaleFactor / 2 * main_height - cell_size / 2,
						spaceScaleFactor / 2 * main_width + cell_size / 2,
						spaceScaleFactor / 2 * main_height + cell_size / 2
						),
						world.getKillersEntities_forPlayer(),
						ConfigurationUtils_Colours.getConfigByID(Application_Base.getInstance().getUserSettings().uiColoursID).getColour_Square_ValidSelection()));
		
		RectF rect_screen = new RectF(spaceScaleFactor / 2 * main_width - main_width / 2,
				spaceScaleFactor / 2 * main_height - main_height / 2,
				spaceScaleFactor / 2 * main_width + main_width / 2,
				spaceScaleFactor / 2 * main_height + main_height / 2);
		
		for (int i = 0; i < getBallsCount(spaceScaleFactor); i++) {
			
			//int x = main_width / 2 + (int) ((Math.random() - 0.5) * 4 * main_width);
			//int y = main_height / 2 + (int) ((Math.random() - 0.5) * 4 * main_height);
			int x = (int) (Math.random() * spaceScaleFactor * main_width);
			int y = (int) (Math.random() * spaceScaleFactor * main_height);
			RectF rect = new RectF(x, y, x + 2.5f * cell_size, y + 2.5f * cell_size);
			
			if (rect_screen.contains(rect) || RectF.intersects(rect_screen, rect)) {
				
				continue;
				
			} else {
				
				Random rnd = new Random(); 
				int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
				
				world.addEntity(new Entity2D_Challenger_StopTheBalls(world,
								rect,
								world.getGroundEntities(), world.getKillersEntities_forChallengers(),
								world.getPlayerEntity().getEnvelop().left, world.getPlayerEntity().getEnvelop().top,
								cfg_world.getSpeedMultiplier(),
								color
						)
				);

			}			
		}
		
		return world;
	}
}

	