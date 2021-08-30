package org.metatransapps.apps.balloons.main;


import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;

import org.metatransapps.apps.balloons.menu.Activity_Menu_Main;
import org.metatransapps.apps.balloons.model.GameData_StopTheBalls;
import org.metatransapps.apps.balloons.model.World_StopTheBalls;
import org.metatransapps.commons.app.Application_Base;
import org.metatransapps.commons.graphics2d.app.Application_2D_Base;
import org.metatransapps.commons.graphics2d.main.Activity_Main_Base2D;
import org.metatransapps.commons.graphics2d.ui.View_Main_Base;
import org.metatransapps.commons.ui.TextArea;
import org.metatransapps.commons.ui.utils.ScreenUtils;


public class View_Main_StopTheBalls extends View_Main_Base {
	
	
	private Paint default_paint;
	
	private RectF rect_level;
	private RectF rect_level_icon;
	private RectF rect_level_text;
	
	private RectF rect_balls;
	private RectF rect_balls_icon;
	private RectF rect_balls_text;
	
	private TextArea textarea_level;
	private TextArea textarea_balls;
	
	
	public View_Main_StopTheBalls(Activity_Main_Base2D activity) {
		
		super(activity);
		
		default_paint = new Paint();
		
		int cell_size = (int) getWorld().getCellSize();
		
		int height = (int) ((8.0f * cell_size) / 10f);
		int start_y = (int) ((1.0f * cell_size) / 10f);
		
		int width = (int) (1.7f * height);
		int width_icon = height;
		int interval_x = cell_size / 3;
		
		float extend_factor_bullets = 1.1f;
		float extend_factor_steps 	= 1.35f;
		
		int[] screen_size = ScreenUtils.getScreenSize((Activity) getContext());
		int screen_width = Math.max(screen_size[0], screen_size[1]);
		int start_x = (int) ((screen_width - 5 * interval_x - 4 * width - extend_factor_bullets * width - extend_factor_steps * width) / 2f);
		
		int border_icon = start_y;
		
		rect_level			= new RectF(start_x, 										start_y, start_x + width, 															start_y + height);
		rect_level_icon		= new RectF(start_x + border_icon, 							start_y + border_icon, start_x + width_icon - border_icon, 							start_y + height - border_icon);
		rect_level_text		= new RectF(rect_level_icon.right, 							start_y, rect_level.right, 															start_y + height);
		
		rect_balls 			= new RectF(rect_level.right + interval_x, 				start_y, rect_level.right + 3 * interval_x + extend_factor_steps * width,				start_y + height);
		rect_balls_icon		= new RectF(rect_level.right + interval_x + border_icon,	start_y + border_icon, rect_level.right + interval_x + width_icon - border_icon, 	start_y + height - border_icon);
		rect_balls_text		= new RectF(rect_balls_icon.right,						 	start_y, rect_balls.right,															start_y + height);
		
		textarea_level 		= new TextArea(rect_level_text, 	"00 ", 		Color.GREEN);
		textarea_balls 		= new TextArea(rect_balls_text, 	"x 000000 ", 	Color.GREEN);

	}
	
	
	@Override
	public Class getMainMenuClass() {
		return Activity_Menu_Main.class;
	}
	
	
	@Override
	public void onDraw(Canvas canvas) {
		
		super.onDraw(canvas);
		
		default_paint.setColor(Color.BLACK);
		
		canvas.drawRect(rect_level, default_paint);
		canvas.drawRect(rect_balls, default_paint);
		
		int level = Application_Base.getInstance().getUserSettings().modeID;
		canvas.drawBitmap(World_StopTheBalls.getBitmap_level(), null, rect_level_icon, default_paint);
		textarea_level.setColour_Text(Color.GREEN);
		textarea_level.setText("" + level + " ");
		textarea_level.draw(canvas);
		
		int balls = ((GameData_StopTheBalls)Application_Base.getInstance().getGameData()).count_killed_balls;
		canvas.drawBitmap(World_StopTheBalls.getBitmap_balls(), null, rect_balls_icon, default_paint);
		textarea_balls.setColour_Text(Color.GREEN);
		textarea_balls.setText("x " + balls + " ");
		textarea_balls.draw(canvas);
	}
	
	
	protected World_StopTheBalls getWorld() {
		return (World_StopTheBalls) super.getWorld();
	}
	
	
	@Override
	protected void processEvent_DOWN(MotionEvent event) {
		
		super.processEvent_DOWN(event);
		
		if (!Application_2D_Base.getInstance().isCurrentlyGameActiveIntoTheMainScreen()) {
			return;
		}
		
		float x = event.getX(event.getActionIndex());
		float y = event.getY(event.getActionIndex());
		getWorld().createBullet(x, y);
	}
	
	
	@Override
	protected void processEvent_MOVE(MotionEvent event) {
		
		super.processEvent_MOVE(event);
		
		if (!Application_2D_Base.getInstance().isCurrentlyGameActiveIntoTheMainScreen()) {
			return;
		}
		
		float x = event.getX();
		float y = event.getY();
		getWorld().createBullet(x, y);
	}
	
	
	@Override
	protected void processEvent_UP(MotionEvent event) {
		
		super.processEvent_UP(event);
		
		if (!Application_2D_Base.getInstance().isCurrentlyGameActiveIntoTheMainScreen()) {
			return;
		}
		
		float x = event.getX();
		float y = event.getY();
		getWorld().createBullet(x, y);
	}
}
