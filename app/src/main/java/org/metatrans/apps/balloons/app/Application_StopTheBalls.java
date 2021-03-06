package org.metatrans.apps.balloons.app;


import org.metatrans.apps.balloons.achievements.AchievementsManager_StopTheBalls;
import org.metatrans.apps.balloons.cfg.app.AppConfig_StopTheBalls;
import org.metatrans.apps.balloons.cfg.world.ConfigurationUtils_Level;
import org.metatrans.apps.balloons.events.EventsManager_StopTheBalls;
import org.metatrans.apps.balloons.lib.BuildConfig;
import org.metatrans.apps.balloons.main.Activity_Result;
import org.metatrans.apps.balloons.model.GameData_StopTheBalls;
import org.metatrans.apps.balloons.model.UserSettings_StopTheBalls;
import org.metatrans.apps.balloons.model.WorldGenerator_StopTheBalls;
import org.metatrans.commons.achievements.IAchievementsManager;
import org.metatrans.commons.app.Application_Base;
import org.metatrans.commons.cfg.app.IAppConfig;
import org.metatrans.commons.cfg.colours.ConfigurationUtils_Colours;
import org.metatrans.commons.cfg.menu.ConfigurationUtils_Base_MenuMain;
import org.metatrans.commons.engagement.ILeaderboardsProvider;
import org.metatrans.commons.engagement.leaderboards.LeaderboardsProvider_Base;
import org.metatrans.commons.events.api.IEventsManager;
import org.metatrans.commons.graphics2d.app.Application_2D_Base;
import org.metatrans.commons.graphics2d.model.IWorld;
import org.metatrans.commons.model.GameData_Base;
import org.metatrans.commons.model.UserSettings_Base;
import org.metatrans.commons.ui.utils.DebugUtils;


public abstract class Application_StopTheBalls extends Application_2D_Base {
	
	
	protected IAppConfig appConfig 					= new AppConfig_StopTheBalls();
	
	
	@Override
	public void onCreate() {

		ConfigurationUtils_Level.createInstance();

		super.onCreate();
		//Called when the application is starting, before any other application objects have been created.
		
		System.out.println("Application_EC: onCreate called " + System.currentTimeMillis());
		
		ConfigurationUtils_Colours.class.getName();
		
		ConfigurationUtils_Base_MenuMain.createInstance();
	}
	
	
	@Override
	public IAppConfig getAppConfig() {
		return appConfig;
	}
	
	
	@Override
	protected IAchievementsManager createAchievementsManager() {
		return new AchievementsManager_StopTheBalls(this);
	}
	
	
	@Override
	protected IEventsManager createEventsManager() {
		return new EventsManager_StopTheBalls(getExecutor(), getAnalytics(), getAchievementsManager());
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
		return WorldGenerator_StopTheBalls.generate(this, ConfigurationUtils_Level.getInstance().getConfigByID(Application_Base.getInstance().getUserSettings().modeID));
	}
	
	
	@Override
	public GameData_Base createGameDataObject() {
		
		System.out.println("GAMEDATA CREATE");
		
		GameData_StopTheBalls result = new GameData_StopTheBalls();
		
		int levelID = getUserSettings().modeID;
		result.world = WorldGenerator_StopTheBalls.generate(this, ConfigurationUtils_Level.getInstance().getConfigByID(levelID));
		
		result.timestamp_lastborn = System.currentTimeMillis();
		
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
