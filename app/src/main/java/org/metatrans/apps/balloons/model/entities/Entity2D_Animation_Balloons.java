package org.metatrans.apps.balloons.model.entities;


import android.graphics.Bitmap;
import android.graphics.RectF;

import org.metatrans.commons.graphics2d.model.World;
import org.metatrans.commons.graphics2d.model.entities.Entity2D_Animation;


public class Entity2D_Animation_Balloons extends Entity2D_Animation {


    public Entity2D_Animation_Balloons(World _world, RectF _envelop, int[] _bitmap_ids,
                                       int rotation_in_degrees) {

        super(_world, _envelop, _bitmap_ids, rotation_in_degrees);
    }


    @Override
    protected Bitmap scaleBitmap(int BITMAP_ID, Bitmap bitmap) {

        return bitmap;
    }
}
