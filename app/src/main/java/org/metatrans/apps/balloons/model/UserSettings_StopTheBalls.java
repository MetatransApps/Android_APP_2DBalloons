package org.metatrans.apps.balloons.model;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.metatrans.apps.balloons.cfg.world.ConfigurationUtils_Level;
import org.metatrans.commons.cfg.colours.IConfigurationColours;
import org.metatrans.commons.graphics2d.model.UserSettings;


public class UserSettings_StopTheBalls extends UserSettings {
	
	
	private static final long serialVersionUID = 3199714911195754477L;
	
	
	public UserSettings_StopTheBalls() {
		
		super();
		
		uiColoursID 		= IConfigurationColours.CFG_COLOUR_BLUE_PETROL;
		modeID 				= ConfigurationUtils_Level.LEVEL_ID_DEFAULT;
		
		//fixFields("constructor");
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
	    	uiColoursID 		= IConfigurationColours.CFG_COLOUR_BLUE_PETROL;
	    	System.out.println("UserSettings: " + op + " - updating colour id");
	    }
	    
		if (modeID == 0) {
			modeID = ConfigurationUtils_Level.LEVEL_ID_DEFAULT;
		}
	}
}
