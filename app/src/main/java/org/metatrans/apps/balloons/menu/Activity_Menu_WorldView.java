package org.metatrans.apps.balloons.menu;


import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import org.metatrans.apps.balloons.model.BitmapCache_Balloons;
import org.metatrans.apps.balloons.model.UserSettings_StopTheBalls;
import org.metatrans.commons.Activity_Base;
import org.metatrans.commons.R;
import org.metatrans.commons.app.Application_Base;
import org.metatrans.commons.ui.list.ListViewFactory;
import org.metatrans.commons.ui.list.RowItem_CIdTD;
import org.metatrans.commons.ui.utils.BitmapUtils;

import java.util.ArrayList;
import java.util.List;


public class Activity_Menu_WorldView extends Activity_Base {
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		System.out.println("Activity_Menu_WorldView: onCreate()");
		
		super.onCreate(savedInstanceState);
		
		int currOrderNumber = ConfigurationUtils_WorldView.getOrderNumber(((UserSettings_StopTheBalls) Application_Base.getInstance().getUserSettings()).cfg_id_worldview);
		
		LayoutInflater inflater = LayoutInflater.from(this);

		ViewGroup frame = ListViewFactory.create_CITD_ByXML(this, inflater, buildRows(currOrderNumber), -1, currOrderNumber, new OnItemClickListener_Menu());
		
		setContentView(frame);
		
		setBackgroundPoster(R.id.commons_listview_frame, 55);
	}
	
	
	@Override
	protected int getBackgroundImageID() {
		return 0;//R.drawable.ic_rainbow;
	}
	
	
	public List<RowItem_CIdTD> buildRows(int initialSelection) {
		
		List<RowItem_CIdTD> rowItems = new ArrayList<RowItem_CIdTD>();

		IConfiguration_WorldView[] objects_cfg_all = ConfigurationUtils_WorldView.getAll();
		
		for (int i = 0; i < objects_cfg_all.length; i++) {

			IConfiguration_WorldView objects_cfg = objects_cfg_all[i];

			if (objects_cfg == null) {

				continue;
			}

			int bitmap_id = objects_cfg.getBitmapResourceID_Icon();

			Bitmap bitmap = BitmapCache_Balloons.STATIC.getInstance(BitmapCache_Balloons.BITMAP_ID_COMMON).get(bitmap_id);
			bitmap = BitmapUtils.createScaledBitmap(bitmap, getIconSize(), getIconSize());

			Drawable drawable = BitmapUtils.createDrawable(this, bitmap);
			
			RowItem_CIdTD item = new RowItem_CIdTD(i == initialSelection, drawable, getString(objects_cfg.getName()), "");

			rowItems.add(item);
		}
		
		return rowItems;
	}
	
	
	private class OnItemClickListener_Menu implements
			AdapterView.OnItemClickListener {
		
		
		private OnItemClickListener_Menu() {
		}
		
		
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

			//System.out.println("Selection POS=" + position + ", id=" + id);
			
			int currOrderNumber = ConfigurationUtils_WorldView.getOrderNumber(((UserSettings_StopTheBalls) Application_Base.getInstance().getUserSettings()).cfg_id_worldview);

			if (position != currOrderNumber) {

				int newCfgID = ConfigurationUtils_WorldView.getID(position);

				changeCfg(newCfgID);
			}
			
			finish();
		}
	}
	
	
	public void changeCfg(int cfg_id_space_objects) {

		((UserSettings_StopTheBalls) Application_Base.getInstance().getUserSettings()).cfg_id_worldview = cfg_id_space_objects;
		
		((Application_Base)getApplication()).storeUserSettings();

		org.metatrans.commons.graphics2d.model.GameData data
				= (org.metatrans.commons.graphics2d.model.GameData) ((Application_Base) getApplication()).getGameData();

		//TODO: Implement
		//((World_StopTheBalls) data.world).initBitmaps();
	}
}
