package fr.sharpheberg.sharpuhchost.config.settings;

import fr.sharpheberg.sharpuhchost.config.ConfigManager;

public class Settings {

    public enum Integer {
        SLOTS(50),
        TIMER_START(10),
        TIMER_PVP(20 * 60),
        TIMER_MEETUP(20 * 60),
        BORDER_START(1000),
        BORDER_END(100),
        BORDER_TIME(10 * 60),
        ;

        private final int value;
        Integer(int value) {
            this.value = ConfigManager.CONFIG.getInteger(name().toLowerCase().replace('_', '.'), value);
        }

        public int getValue() {
            return value;
        }
    }

    public static void setup(){
        for (Integer integer : Integer.values()){

        }
    }

}
