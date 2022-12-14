package org.metatrans.apps.balloons.model.entities;


import android.graphics.Bitmap;
import android.graphics.RectF;

import org.metatrans.apps.balloons.menu.ConfigurationUtils_WorldView;
import org.metatrans.apps.balloons.menu.IConfiguration_WorldView;
import org.metatrans.apps.balloons.model.BitmapCache_Balloons;
import org.metatrans.apps.balloons.model.UserSettings_StopTheBalls;
import org.metatrans.commons.app.Application_Base;
import org.metatrans.commons.graphics2d.model.IWorld;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Ground;
import org.metatrans.commons.graphics2d.model.entities.IEntity2D;
import org.metatrans.commons.ui.utils.BitmapUtils;


public class Entity2D_Terrain_Balloons extends Entity2D_Ground {


    private static final long serialVersionUID = -434579107317800373L;


    private transient Bitmap bitmap_background;
    private transient Bitmap bitmap_latest_backup;


    public Entity2D_Terrain_Balloons(IWorld world) {

        super(world, null, IEntity2D.SUBTYPE_GROUND_EMPTY, 0, 0);
    }


    @Override
    public RectF getEnvelop() {

        return getWorld().getCamera();
    }


    @Override
    public Bitmap getBitmap() {


        /* FPS check
        // TODO: Why the drawing of this big bitmap is soo slow?
        if (Math.random() <= 0.9f) {

            return null;
        }
        */


        //Bitmap latest = getWorld().getBitmapCache().get(BitmapCache_Balloons.BITMAP_ID_BALLOONS_BACKGROUND_FORTRESS);
        //Bitmap latest = getWorld().getBitmapCache().get(BitmapCache_Balloons.BITMAP_ID_BALLOONS_BACKGROUND_GRADIENT);
        //Bitmap latest = getWorld().getBitmapCache().get(BitmapCache_Balloons.BITMAP_ID_BALLOONS_BACKGROUND_BRICKWALL);

        UserSettings_StopTheBalls userSettings_gravity = (UserSettings_StopTheBalls) Application_Base.getInstance().getUserSettings();
        IConfiguration_WorldView objects_config = ConfigurationUtils_WorldView.getConfigByID(userSettings_gravity.cfg_id_worldview);
        Bitmap latest = getWorld().getBitmapCache().get(objects_config.getBitmapResourceID_Background());

        if (bitmap_latest_backup != latest) {

            bitmap_latest_backup = latest;

            bitmap_background = BitmapUtils.createScaledBitmap(bitmap_latest_backup,
                    (int) (getEnvelop_ForDraw().right - getEnvelop_ForDraw().left),
                    (int) (getEnvelop_ForDraw().bottom - getEnvelop_ForDraw().top));

        }


        return bitmap_background;
    }


    @Override
    public int getBackgroundColour() {

        return Application_Base.getInstance().getColoursCfg().getColour_Square_White();
    }
}
