package org.metatrans.apps.balloons.app;


import org.metatrans.apps.balloons.achievements.AchievementsManager_StopTheBalls;
import org.metatrans.apps.balloons.cfg.world.ConfigurationUtils_Level;
import org.metatrans.apps.balloons.cfg.world.IConfigurationWorld;
import org.metatrans.apps.balloons.events.EventsManager_StopTheBalls;
import org.metatrans.apps.balloons.lib.BuildConfig;
import org.metatrans.apps.balloons.lib.R;
import org.metatrans.apps.balloons.main.Activity_Result;
import org.metatrans.apps.balloons.model.BitmapCache_Balloons;
import org.metatrans.apps.balloons.model.GameData_StopTheBalls;
import org.metatrans.apps.balloons.model.UserSettings_StopTheBalls;
import org.metatrans.apps.balloons.model.WorldGenerator_StopTheBalls;
import org.metatrans.commons.achievements.IAchievementsManager;
import org.metatrans.commons.app.Application_Base;
import org.metatrans.commons.cfg.colours.ConfigurationUtils_Colours;
import org.metatrans.commons.cfg.menu.ConfigurationUtils_Base_MenuMain;
import org.metatrans.commons.engagement.ILeaderboardsProvider;
import org.metatrans.commons.engagement.leaderboards.LeaderboardsProvider_Base;
import org.metatrans.commons.events.api.IEventsManager;
import org.metatrans.commons.graphics2d.app.Application_2D_Base;
import org.metatrans.commons.graphics2d.model.IWorld;
import org.metatrans.commons.model.BitmapCache_Base;
import org.metatrans.commons.model.GameData_Base;
import org.metatrans.commons.model.I2DBitmapCache;
import org.metatrans.commons.model.UserSettings_Base;
import org.metatrans.commons.ui.utils.DebugUtils;


public abstract class Application_StopTheBalls extends Application_2D_Base {

	
	@Override
	public void onCreate() {

		ConfigurationUtils_Level.createInstance();

		getSFXManager().loadSounds(this,
				new int[] {
					org.metatrans.commons.R.raw.sfx_button_pressed_1,
					org.metatrans.commons.R.raw.sfx_button_pressed_2,
					org.metatrans.commons.R.raw.sfx_button_pressed_3,
					R.raw.sfx_new_game,
					R.raw.sfx_game_over,
					R.raw.sfx_level_completed,
					R.raw.sfx_arrow,
					R.raw.sfx_balloon_popping
				}
		);

		super.onCreate();
		//Called when the application is starting, before any other application objects have been created.
		
		System.out.println("Application_EC: onCreate called " + System.currentTimeMillis());
		
		ConfigurationUtils_Colours.class.getName();
		
		ConfigurationUtils_Base_MenuMain.createInstance();

		BitmapCache_Base.STATIC = new BitmapCache_Balloons(I2DBitmapCache.BITMAP_ID_STATIC);

		BitmapCache_Base.STATIC.initBitmaps();
	}

	
	@Override
	protected IAchievementsManager createAchievementsManager() {
		return new AchievementsManager_StopTheBalls(this);
	}
	
	
	@Override
	protected IEventsManager createEventsManager() {

		return new EventsManager_StopTheBalls(getExecutor(), getAchievementsManager());
	}
	
	
	@Override
	protected ILeaderboardsProvider createLeaderboardsProvider() {
		return new LeaderboardsProvider_Base(this, Activity_Result.class);
	}
	
	
	@Override
	public void setNextLevel() {
		getUserSettings().modeID = ConfigurationUtils_Level.getInstance().getNextConfigID(getUserSettings().modeID);
		Application_Base.getInstance().storeUserSettings();
		System.out.println("Next level: " + getUserSettings().modeID);
	}
	
	
	@Override
	public IWorld createNewWorld() {

		int level_id = Application_Base.getInstance().getUserSettings().modeID;

		IConfigurationWorld cfg_world = ConfigurationUtils_Level.getInstance().getConfigByID(level_id);

		if (cfg_world == null) {

			throw new IllegalStateException("No cfg for level_id=" + level_id);
		}

		return WorldGenerator_StopTheBalls.generate(this, cfg_world);
	}
	
	
	@Override
	public GameData_Base createGameDataObject() {
		
		System.out.println("GAMEDATA CREATE");

		GameData_StopTheBalls result = new GameData_StopTheBalls();

		result.world = createNewWorld();
		//result.world.
		
		result.timestamp_lastborn = System.currentTimeMillis();

		Application_Base.getInstance().getSFXManager().playSound(R.raw.sfx_new_game);

		return result;
	}
	
	
	@Override
	protected UserSettings_Base createUserSettingsObject() {
		return new UserSettings_StopTheBalls();
	}
	
	
	@Override
	public boolean isTestMode() {
		boolean productiveMode = !BuildConfig.DEBUG || !DebugUtils.isDebuggable(this);
		return !productiveMode;
	}
}
