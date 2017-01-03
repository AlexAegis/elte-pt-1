package exam.config;

import java.awt.*;

public final class Config {
    public static final boolean DEBUG_MODE = true;
    public static final String WINDOW_TITLE = "NumberGame";
    public static final int WINDOW_HEIGHT = 900;
    public static final int WINDOW_WIDTH = 680;
    public static final boolean WINDOW_RESIZABLE = false; //TODO
    public static final boolean ANTI_ALIASING = true;
    public static final boolean START_WITH_DEFAULT = false;
    public static final GameModes DEFAULT_GAMEMODE = GameModes.NUMBER_GAME;
    public static final FieldSizes DEFAULT_FIELDSIZE = FieldSizes.SEVEN;
    public static final int DEFAULT_MIN_RNG = 0;
    public static final int DEFAULT_MAX_RNG = 50;
    public static final int DEFAULT_MODIFIER_VALUE = -1;
    public static final boolean HIGHLIGHTING = true;
    public static final Color GAME_BG_COLOR = new Color(189, 251, 34, 255);
    public static final Color MENU_BG_COLOR = GAME_BG_COLOR.brighter();
}