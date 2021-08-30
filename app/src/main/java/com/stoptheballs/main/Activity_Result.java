package com.stoptheballs.main;


import org.metatransapps.commons.ads.api.IAdsConfiguration;
import org.metatransapps.commons.graphics2d.app.Application_2D_Base;
import org.metatransapps.commons.graphics2d.main.Activity_Result_Base2D;
import org.metatransapps.commons.graphics2d.model.UserSettings;
import org.metatransapps.commons.main.View_Result;

import com.stoptheballs.lib.R;
import com.stoptheballs.app.Application_StopTheBalls;
import com.stoptheballs.model.GameData_StopTheBalls;


public class Activity_Result extends Activity_Result_Base2D {
	
	
	@Override
	public View_Result createView() {
		
		GameData_StopTheBalls gameGata = (GameData_StopTheBalls) ((Application_2D_Base) getApplication()).getGameData();
		UserSettings settings = (UserSettings) ((Application_StopTheBalls)getApplication()).getUserSettings();
		
		View_Result view = new View_Result(this,
				gameGata.count_killed_balls >= settings.best_scores, //new record
				false, //show mode
				null,//"All Levels", //mode name
				new String[] {getString(R.string.balls)},//, "l2", "l3"},
				new String[] {"" + gameGata.count_killed_balls},//, "dy2", "dy3"},
				new String[] {"" + settings.best_scores}//, "db2", "db3"}
				);
		
		return view;
	}
	
	
	@Override
	protected String getBannerName() {
		return IAdsConfiguration.AD_ID_BANNER3;
	}
}
