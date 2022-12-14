package org.metatrans.apps.balloons.model.entities;


import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.RectF;

import org.metatrans.apps.balloons.cfg.world.ConfigurationUtils_Level;
import org.metatrans.apps.balloons.cfg.world.IConfigurationWorld;
import org.metatrans.commons.app.Application_Base;
import org.metatrans.commons.graphics2d.model.World;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Animation;


public class Entity2D_Animation_Balloons extends Entity2D_Animation {


    private int balloon_bitmap_id;


    public Entity2D_Animation_Balloons(World _world, RectF _envelop,
                                       int _balloon_bitmap_id,
                                       int[] _bitmap_ids,
                                       int rotation_in_degrees) {

        super(_world, _envelop, _bitmap_ids, rotation_in_degrees);

        balloon_bitmap_id = _balloon_bitmap_id;
    }


    @Override
    protected int getBaseColor() {

        IConfigurationWorld cfg_world = ConfigurationUtils_Level.getInstance().getConfigByID(Application_Base.getInstance().getUserSettings().modeID);

        Color base_color = cfg_world.getBaseExplosionColor(balloon_bitmap_id);

        byte[] bytes = intToByteArray(random2.nextInt());

       return Color.argb(
                bytes[0] / (float) 256,
                adjustByMaxPercent(base_color.red(), bytes[1]),
                adjustByMaxPercent(base_color.green(), bytes[2]),
                adjustByMaxPercent(base_color.blue(), bytes[3])
        );

        /*return Color.argb(
                bytes[0],
                base_color.red(),
                base_color.green(),
                base_color.blue()
        );*/
    }


    private float adjustByMaxPercent(float value, byte random) {

        float percent = 0.50f;

        float adjustment = (float) (value * (percent * (0.5f - Math.random())));

        //System.out.println("adjustByMaxPercent: adjustment=" + adjustment);

        float value_adjusted = value + adjustment;

        if (value_adjusted < 0) {

            value_adjusted = 0;
        }
        if (value_adjusted > 1) {

            value_adjusted = 1;
        }


        return value_adjusted;
    }


    @Override
    protected Bitmap scaleBitmap(int BITMAP_ID, Bitmap bitmap) {

        return bitmap;
    }
}
