package org.metatrans.apps.balloons.model;


import org.metatrans.apps.balloons.lib.R;
import org.metatrans.commons.app.Application_Base;
import org.metatrans.commons.model.BitmapCache_Base;
import org.metatrans.commons.ui.utils.BitmapUtils;


public class BitmapCache_Balloons extends BitmapCache_Base {


	public static final int BITMAP_ID_LEVEL 					= 11;

	public static final int BITMAP_ID_CROSSBOW_1 				= 120;
	public static final int BITMAP_ID_CROSSBOW_2 				= 130;

	public static final int BITMAP_ID_ARROWS_BLACK 				= 140;
	public static final int BITMAP_ID_ARROWS_WHITE 				= 145;
	public static final int BITMAP_ID_ARROWS_GRAY 				= 150;
	public static final int BITMAP_ID_ARROWS_RED 				= 160;
	public static final int BITMAP_ID_ARROWS_ORANGE 			= 170;
	public static final int BITMAP_ID_ARROWS_YELLOW 			= 180;
	public static final int BITMAP_ID_ARROWS_GREEN 				= 190;
	public static final int BITMAP_ID_ARROWS_BLUE 				= 200;
	public static final int BITMAP_ID_ARROWS_INDIGO 			= 210;
	public static final int BITMAP_ID_ARROWS_VIOLET 			= 220;

	public static final int BITMAP_ID_BALLOONS_BLACK_ORG 		= 230;
	public static final int BITMAP_ID_BALLOONS_WHITE_ORG 		= 235;
	public static final int BITMAP_ID_BALLOONS_GRAY_ORG 		= 240;
	public static final int BITMAP_ID_BALLOONS_RED_ORG 			= 250;
	public static final int BITMAP_ID_BALLOONS_ORANGE_ORG 		= 260;
	public static final int BITMAP_ID_BALLOONS_YELLOW_ORG 		= 270;
	public static final int BITMAP_ID_BALLOONS_GREEN_ORG 		= 280;
	public static final int BITMAP_ID_BALLOONS_BLUE_ORG 		= 290;
	public static final int BITMAP_ID_BALLOONS_INDIGO_ORG 		= 300;
	public static final int BITMAP_ID_BALLOONS_VIOLET_ORG 		= 310;

	public static final int BITMAP_ID_BALLOONS_BLACK_PART_1 	= 320;
	public static final int BITMAP_ID_BALLOONS_WHITE_PART_1 	= 325;
	public static final int BITMAP_ID_BALLOONS_GRAY_PART_1 		= 330;
	public static final int BITMAP_ID_BALLOONS_RED_PART_1 		= 340;
	public static final int BITMAP_ID_BALLOONS_ORANGE_PART_1 	= 350;
	public static final int BITMAP_ID_BALLOONS_YELLOW_PART_1 	= 360;
	public static final int BITMAP_ID_BALLOONS_GREEN_PART_1 	= 370;
	public static final int BITMAP_ID_BALLOONS_BLUE_PART_1 		= 380;
	public static final int BITMAP_ID_BALLOONS_INDIGO_PART_1 	= 390;
	public static final int BITMAP_ID_BALLOONS_VIOLET_PART_1 	= 400;

	public static final int BITMAP_ID_BALLOONS_BLACK_PART_2 	= 410;
	public static final int BITMAP_ID_BALLOONS_WHITE_PART_2 	= 415;
	public static final int BITMAP_ID_BALLOONS_GRAY_PART_2 		= 420;
	public static final int BITMAP_ID_BALLOONS_RED_PART_2 		= 430;
	public static final int BITMAP_ID_BALLOONS_ORANGE_PART_2 	= 440;
	public static final int BITMAP_ID_BALLOONS_YELLOW_PART_2 	= 450;
	public static final int BITMAP_ID_BALLOONS_GREEN_PART_2 	= 460;
	public static final int BITMAP_ID_BALLOONS_BLUE_PART_2 		= 470;
	public static final int BITMAP_ID_BALLOONS_INDIGO_PART_2 	= 480;
	public static final int BITMAP_ID_BALLOONS_VIOLET_PART_2 	= 490;

	public static final int BITMAP_ID_BALLOONS_BLACK_PART_3 	= 500;
	public static final int BITMAP_ID_BALLOONS_WHITE_PART_3 	= 505;
	public static final int BITMAP_ID_BALLOONS_GRAY_PART_3 		= 510;
	public static final int BITMAP_ID_BALLOONS_RED_PART_3 		= 520;
	public static final int BITMAP_ID_BALLOONS_ORANGE_PART_3 	= 530;
	public static final int BITMAP_ID_BALLOONS_YELLOW_PART_3 	= 540;
	public static final int BITMAP_ID_BALLOONS_GREEN_PART_3 	= 550;
	public static final int BITMAP_ID_BALLOONS_BLUE_PART_3 		= 560;
	public static final int BITMAP_ID_BALLOONS_INDIGO_PART_3 	= 570;
	public static final int BITMAP_ID_BALLOONS_VIOLET_PART_3 	= 580;

	public static final int BITMAP_ID_BALLOONS_BLACK_PART_4 	= 590;
	public static final int BITMAP_ID_BALLOONS_WHITE_PART_4 	= 595;
	public static final int BITMAP_ID_BALLOONS_GRAY_PART_4 		= 600;
	public static final int BITMAP_ID_BALLOONS_RED_PART_4 		= 610;
	public static final int BITMAP_ID_BALLOONS_ORANGE_PART_4 	= 620;
	public static final int BITMAP_ID_BALLOONS_YELLOW_PART_4 	= 630;
	public static final int BITMAP_ID_BALLOONS_GREEN_PART_4 	= 640;
	public static final int BITMAP_ID_BALLOONS_BLUE_PART_4 		= 650;
	public static final int BITMAP_ID_BALLOONS_INDIGO_PART_4 	= 660;
	public static final int BITMAP_ID_BALLOONS_VIOLET_PART_4 	= 670;

	public static final int BITMAP_ID_BALLOONS_BLACK_PART_5 	= 680;
	public static final int BITMAP_ID_BALLOONS_WHITE_PART_5 	= 685;
	public static final int BITMAP_ID_BALLOONS_GRAY_PART_5 		= 690;
	public static final int BITMAP_ID_BALLOONS_RED_PART_5 		= 700;
	public static final int BITMAP_ID_BALLOONS_ORANGE_PART_5 	= 710;
	public static final int BITMAP_ID_BALLOONS_YELLOW_PART_5 	= 720;
	public static final int BITMAP_ID_BALLOONS_GREEN_PART_5 	= 730;
	public static final int BITMAP_ID_BALLOONS_BLUE_PART_5 		= 740;
	public static final int BITMAP_ID_BALLOONS_INDIGO_PART_5 	= 750;
	public static final int BITMAP_ID_BALLOONS_VIOLET_PART_5 	= 760;

	public static final int BITMAP_ID_BALLOONS_BLACK_PART_6 	= 770;
	public static final int BITMAP_ID_BALLOONS_WHITE_PART_6 	= 775;
	public static final int BITMAP_ID_BALLOONS_GRAY_PART_6 		= 780;
	public static final int BITMAP_ID_BALLOONS_RED_PART_6 		= 790;
	public static final int BITMAP_ID_BALLOONS_ORANGE_PART_6 	= 800;
	public static final int BITMAP_ID_BALLOONS_YELLOW_PART_6 	= 810;
	public static final int BITMAP_ID_BALLOONS_GREEN_PART_6 	= 820;
	public static final int BITMAP_ID_BALLOONS_BLUE_PART_6 		= 830;
	public static final int BITMAP_ID_BALLOONS_INDIGO_PART_6 	= 840;
	public static final int BITMAP_ID_BALLOONS_VIOLET_PART_6 	= 850;


	public static final int BITMAP_ID_BALLOONS_BACKGROUND_GRADIENT_BLUE 	= 1000;
	public static final int BITMAP_ID_BALLOONS_BACKGROUND_GRADIENT_GREEN 	= 1010;
	public static final int BITMAP_ID_BALLOONS_BACKGROUND_GRADIENT_PINK 	= 1020;
	public static final int BITMAP_ID_BALLOONS_BACKGROUND_BRICKWALL_BLUE	= 1100;
	public static final int BITMAP_ID_BALLOONS_BACKGROUND_BRICKWALL_GREEN	= 1110;
	public static final int BITMAP_ID_BALLOONS_BACKGROUND_BRICKWALL_RED		= 1120;
	public static final int BITMAP_ID_BALLOONS_BACKGROUND_FORTRESS			= 1200;

	public static final int BITMAP_ID_BALLOONS_ICON_GRADIENT_BLUE 			= 1300;
	public static final int BITMAP_ID_BALLOONS_ICON_GRADIENT_GREEN 			= 1310;
	public static final int BITMAP_ID_BALLOONS_ICON_GRADIENT_PINK 			= 1320;
	public static final int BITMAP_ID_BALLOONS_ICON_BRICKWALL_BLUE			= 1400;
	public static final int BITMAP_ID_BALLOONS_ICON_BRICKWALL_GREEN			= 1420;
	public static final int BITMAP_ID_BALLOONS_ICON_BRICKWALL_RED			= 1430;
	public static final int BITMAP_ID_BALLOONS_ICON_FORTRESS				= 1500;


	public BitmapCache_Balloons(Integer cache_id) {

		super(cache_id);
	}


	@Override
	public void initBitmaps() {


		System.out.println("!EXPENSIVE OP: RE-INIT BITMAPS OF THE WORLD");


		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_LEVEL,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_level));


		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_CROSSBOW_1,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_crossbow_unloaded_v2));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_CROSSBOW_2,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_crossbow_loaded_v2));
		//bitmap_player   	= BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_ball_green);
		//bitmap_player   	= BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_color_circle);


		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_BLUE_ORG,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_blue));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_INDIGO_ORG,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_indigo));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_VIOLET_ORG,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_violet));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_BLACK_ORG,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_black));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_WHITE_ORG,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_white));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_GRAY_ORG,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_gray));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_RED_ORG,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_red));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_GREEN_ORG,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_green));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_YELLOW_ORG,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_yellow));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_ORANGE_ORG,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_orange));


		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_ARROWS_BLUE,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_arrow_blue_v2));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_ARROWS_INDIGO,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_arrow_indigo_v2));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_ARROWS_VIOLET,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_arrow_violet_v2));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_ARROWS_BLACK,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_arrow_black_v2));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_ARROWS_WHITE,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_arrow_white_v2));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_ARROWS_GRAY,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_arrow_grey_v2));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_ARROWS_RED,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_arrow_red_v2));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_ARROWS_GREEN,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_arrow_green_v2));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_ARROWS_YELLOW,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_arrow_yellow_v2));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_ARROWS_ORANGE,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_arrow_orange_v2));


		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_INDIGO_PART_1,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_indigo_step_0));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_INDIGO_PART_2,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_indigo_step_1));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_INDIGO_PART_3,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_indigo_step_2));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_INDIGO_PART_4,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_indigo_step_3));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_INDIGO_PART_5,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_indigo_step_4));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_INDIGO_PART_6,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_indigo_step_5));

		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_BLUE_PART_1,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_blue_step_0));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_BLUE_PART_2,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_blue_step_1));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_BLUE_PART_3,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_blue_step_2));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_BLUE_PART_4,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_blue_step_3));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_BLUE_PART_5,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_blue_step_4));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_BLUE_PART_6,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_blue_step_5));

		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_VIOLET_PART_1,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_violet_step_0));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_VIOLET_PART_2,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_violet_step_1));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_VIOLET_PART_3,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_violet_step_2));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_VIOLET_PART_4,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_violet_step_3));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_VIOLET_PART_5,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_violet_step_4));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_VIOLET_PART_6,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_violet_step_5));

		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_BLACK_PART_1,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_black_step_0));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_BLACK_PART_2,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_black_step_1));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_BLACK_PART_3,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_black_step_2));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_BLACK_PART_4,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_black_step_3));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_BLACK_PART_5,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_black_step_4));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_BLACK_PART_6,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_black_step_5));

		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_WHITE_PART_1,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_white_step_0));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_WHITE_PART_2,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_white_step_1));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_WHITE_PART_3,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_white_step_2));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_WHITE_PART_4,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_white_step_3));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_WHITE_PART_5,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_white_step_4));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_WHITE_PART_6,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_white_step_5));

		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_GRAY_PART_1,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_gray_step_0));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_GRAY_PART_2,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_gray_step_1));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_GRAY_PART_3,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_gray_step_2));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_GRAY_PART_4,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_gray_step_3));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_GRAY_PART_5,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_gray_step_4));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_GRAY_PART_6,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_gray_step_5));

		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_RED_PART_1,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_red_step_0));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_RED_PART_2,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_red_step_1));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_RED_PART_3,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_red_step_2));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_RED_PART_4,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_red_step_3));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_RED_PART_5,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_red_step_4));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_RED_PART_6,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_red_step_5));

		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_GREEN_PART_1,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_green_step_0));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_GREEN_PART_2,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_green_step_1));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_GREEN_PART_3,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_green_step_2));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_GREEN_PART_4,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_green_step_3));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_GREEN_PART_5,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_green_step_4));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_GREEN_PART_6,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_green_step_5));

		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_YELLOW_PART_1,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_yellow_step_0));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_YELLOW_PART_2,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_yellow_step_1));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_YELLOW_PART_3,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_yellow_step_2));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_YELLOW_PART_4,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_yellow_step_3));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_YELLOW_PART_5,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_yellow_step_4));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_YELLOW_PART_6,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_yellow_step_5));

		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_ORANGE_PART_1,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_orange_step_0));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_ORANGE_PART_2,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_orange_step_1));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_ORANGE_PART_3,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_orange_step_2));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_ORANGE_PART_4,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_orange_step_3));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_ORANGE_PART_5,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_orange_step_4));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_ORANGE_PART_6,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloon_orange_step_5));


		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_ICON_GRADIENT_BLUE,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloons_icon_gradient_blue));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_ICON_GRADIENT_GREEN,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloons_icon_gradient_green));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_ICON_GRADIENT_PINK,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloons_icon_gradient_pink));

		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_ICON_BRICKWALL_BLUE,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloons_icon_brickwall_blue));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_ICON_BRICKWALL_GREEN,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloons_icon_brickwall_green));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_ICON_BRICKWALL_RED,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloons_icon_brickwall_red));

		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_ICON_FORTRESS,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_balloons_icon_fortress_v5));

		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_BACKGROUND_GRADIENT_BLUE,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_background_gradient_blue));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_BACKGROUND_GRADIENT_GREEN,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_background_gradient_green));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_BACKGROUND_GRADIENT_PINK,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_background_gradient_pink));

		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_BACKGROUND_BRICKWALL_BLUE,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_background_brickwall_blue));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_BACKGROUND_BRICKWALL_GREEN,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_background_brickwall_green));
		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_BACKGROUND_BRICKWALL_RED,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_background_brickwall_red));

		BitmapCache_Balloons.STATIC.getInstance_Impl(BitmapCache_Balloons.BITMAP_ID_COMMON).add(
				BitmapCache_Balloons.BITMAP_ID_BALLOONS_BACKGROUND_FORTRESS,
				BitmapUtils.fromResource(Application_Base.getInstance(), R.drawable.ic_background_fortress_v3));
	}
}
