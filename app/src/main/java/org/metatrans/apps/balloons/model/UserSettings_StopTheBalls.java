package org.metatrans.apps.balloons.model;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.metatrans.apps.balloons.cfg.world.ConfigurationUtils_Level;
import org.metatrans.apps.balloons.menu.ConfigurationUtils_WorldView;
import org.metatrans.commons.cfg.colours.IConfigurationColours;
import org.metatrans.commons.cfg.melody.IConfigurationMelody;
import org.metatrans.commons.graphics2d.model.UserSettings;


public class UserSettings_StopTheBalls extends UserSettings {
	
	
	private static final long serialVersionUID = 3199714911195754477L;


	public int cfg_id_worldview;


	public UserSettings_StopTheBalls() {
		
		super();

		cfg_id_worldview 		= ConfigurationUtils_WorldView.START_INDEX;
		uiColoursID 			= IConfigurationColours.CFG_COLOUR_BLUE_SKY_ON_GRAY;
		modeID 					= ConfigurationUtils_Level.LEVEL_ID_DEFAULT;
		melody_cfg_id 			= IConfigurationMelody.CFG_MELODY_BATTLE;
	}
	
	
	private void writeObject(ObjectOutputStream oos) throws IOException {
		
	    fixFields("writeObject");
	    
	    // default serialization 
	    oos.defaultWriteObject();
	}
	
	
	private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
	    
	    // default deserialization
	    ois.defaultReadObject();
	    
	    fixFields("readObject");
	}
	
	
	private void fixFields(String op) {
		
		if (uiColoursID == 0) {
	    	uiColoursID 		= IConfigurationColours.CFG_COLOUR_BLUE_SKY_ON_GRAY;
	    	System.out.println("UserSettings: " + op + " - updating colour id");
	    }
	    
		if (modeID == 0) {
			modeID = ConfigurationUtils_Level.LEVEL_ID_DEFAULT;
			System.out.println("UserSettings: " + op + " - updating mode id");
		}

		if (cfg_id_worldview == 0) {
			cfg_id_worldview = ConfigurationUtils_WorldView.START_INDEX;
			System.out.println("UserSettings: " + op + " - updating space_objects id");
		}
	}
}
