package exam.config;

import java.awt.*;

public final class Config {
    public static final boolean DEBUG_MODE = true;
    public static final String WINDOW_TITLE = "NumberGame";
    public static int DEFAULT_WINDOW_HEIGHT = 700;
    public static int DEFAULT_WINDOW_WIDTH = 520;
    public static final boolean WINDOW_RESIZABLE = true;
    public static final boolean ANTI_ALIASING = true;
    public static boolean START_WITH_DEFAULT = true;
    public static final GameModes DEFAULT_GAMEMODE = GameModes.MASTERMIND;
    public static final FieldSizes DEFAULT_FIELDSIZE = FieldSizes.CUSTOM;
    public static final int DEFAULT_MIN_RNG = 0;
    public static final int DEFAULT_MAX_RNG = 50;
    public static final int DEFAULT_CUSTOM_N = 10;
    public static final int DEFAULT_CUSTOM_M = 5;
    public static final int DEFAULT_MODIFIER_VALUE = -1;
    public static final boolean HIGHLIGHTING = true;
    public static final Color GAME_BG_COLOR = new Color(89, 104, 126, 255);
    public static final Color MENU_BG_COLOR = GAME_BG_COLOR.brighter();
    public static final int DEFAULT_STARTING_PLAYER = -1; // 1 or -1
    public static final String DEFAULT_DIFFICULTY = "4";
}