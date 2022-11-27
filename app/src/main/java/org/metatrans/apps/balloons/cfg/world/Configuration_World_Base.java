package org.metatrans.apps.balloons.cfg.world;


import org.metatrans.apps.balloons.model.BitmapCache_Balloons;


public abstract class Configuration_World_Base implements IConfigurationWorld {
	

		private static final int[] BITMAP_IDS_BALLOONS = new int[] {

			BitmapCache_Balloons.BITMAP_ID_BALLOONS_BLACK_ORG,
			BitmapCache_Balloons.BITMAP_ID_BALLOONS_WHITE_ORG,
			BitmapCache_Balloons.BITMAP_ID_BALLOONS_GRAY_ORG,
			BitmapCache_Balloons.BITMAP_ID_BALLOONS_RED_ORG,
			BitmapCache_Balloons.BITMAP_ID_BALLOONS_ORANGE_ORG,
			BitmapCache_Balloons.BITMAP_ID_BALLOONS_YELLOW_ORG,
			BitmapCache_Balloons.BITMAP_ID_BALLOONS_GREEN_ORG,
			BitmapCache_Balloons.BITMAP_ID_BALLOONS_BLUE_ORG,
			BitmapCache_Balloons.BITMAP_ID_BALLOONS_INDIGO_ORG,
			BitmapCache_Balloons.BITMAP_ID_BALLOONS_VIOLET_ORG,
	};


	private static final int[] BITMAP_IDS_ARROWS = new int[] {

			BitmapCache_Balloons.BITMAP_ID_ARROWS_BLACK,
			BitmapCache_Balloons.BITMAP_ID_ARROWS_WHITE,
			BitmapCache_Balloons.BITMAP_ID_ARROWS_GRAY,
			BitmapCache_Balloons.BITMAP_ID_ARROWS_RED,
			BitmapCache_Balloons.BITMAP_ID_ARROWS_ORANGE,
			BitmapCache_Balloons.BITMAP_ID_ARROWS_YELLOW,
			BitmapCache_Balloons.BITMAP_ID_ARROWS_GREEN,
			BitmapCache_Balloons.BITMAP_ID_ARROWS_BLUE,
			BitmapCache_Balloons.BITMAP_ID_ARROWS_INDIGO,
			BitmapCache_Balloons.BITMAP_ID_ARROWS_VIOLET,
	};


	private int id;
	protected float spaceMultiplier;
	private float speedMultiplier;
	private int[] from_to_index;

	
	public Configuration_World_Base(int _id, float _spaceMultiplier, float _speedMultiplier, int[] _from_to_index) {
		id = _id;
		spaceMultiplier = _spaceMultiplier;
		speedMultiplier = _speedMultiplier;
		from_to_index = _from_to_index;
	}
	
	
	@Override
	public int getID() {
		return id;
	}
	
	
	@Override
	public float getSpaceMultiplier() {
		return spaceMultiplier;
	}


	@Override
	public float getSpeedMultiplier() {
		return speedMultiplier;
	}


	@Override
	public int getBitmapBalloons_Random() {

		int length = from_to_index[1] - from_to_index[0];

		int bitmap_id = from_to_index[0] + (int) ((length + 1) * Math.random());

		return BITMAP_IDS_BALLOONS[bitmap_id];
	}


	@Override
	public int getBitmapArrows_Random() {

		int length = from_to_index[1] - from_to_index[0];

		int bitmap_id = from_to_index[0] + (int) ((length + 1) * Math.random());

		return BITMAP_IDS_ARROWS[bitmap_id];
	}
}
