package org.metatransapps.apps.balloons.loading;


import java.util.Random;

import org.metatransapps.apps.balloons.lib.R;
import org.metatransapps.commons.loading.View_Loading_Base;
import org.metatransapps.commons.model.UserSettings_Base;
import org.metatransapps.commons.ui.utils.BitmapUtils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;


public class View_Loading extends View_Loading_Base {
	
	
	private Bitmap[] bitmap_commons;
	private Bitmap background_image;
	
	
	public View_Loading(Context context, UserSettings_Base _settings) {
		
		super(context);
		
		//background_image = BitmapUtils.fromResource(getContext(), R.drawable.ic_logo_balls);
	}
	
	
	@Override
	protected Bitmap getBitmapBackground() {
		return background_image;
	}
	
	
	@Override
	protected Bitmap[] getCommonBitmaps() {
		return bitmap_commons;
	}
	
	
	@Override
	protected void initPiecesBitmaps() {
		
		bitmap_commons = new Bitmap[] {
				getImageBitmap(R.drawable.ic_logo_balls),
				getImageBitmap(R.drawable.ic_logo_balls),
		};
		
		
		Bitmap[] bitmap_others = new Bitmap[50];
		
		
		for (int i=0; i< bitmap_others.length; i++) {
			
			bitmap_others[i] = createOval((int) getSquareSize(), (int) getSquareSize());
			createEntry(bitmap_others[i]);
			
		}
	}
	
	
	private static Bitmap createOval(int w, int h) {
		
	    Bitmap bm = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
	    Canvas c = new Canvas(bm);
	    Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);

		Random rnd = new Random(); 
	    p.setColor(Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
	    
	    c.drawOval(new RectF(0, 0, w * 3 / 4, h * 3 / 4), p);
	    
	    return bm;
	}
	
	
	protected Bitmap getImageBitmap(int imageResID) {
		return BitmapUtils.fromResource(getContext(), imageResID, (int) getSquareSize());
	}
}
