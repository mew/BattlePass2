package zone.nora.battlepass.config;

import java.io.File;
import net.minecraftforge.common.config.Configuration;

public class Config {
    private static Config instance;
    private static Configuration config;
    private boolean enabled;
    private int delay;

    public static void initialize(File path) {
        instance = new Config(path);
    }

    public static Config getInstance() {
        return instance;
    }

    private Config(File path) {
        config = new Configuration(path);
        config.load();
        addGeneralConfig();
        if (config.hasChanged()) {
            config.save();
        }
    }

    private void addGeneralConfig() {
        enabled = config.get(
                Configuration.CATEGORY_GENERAL,
                "Mod Enabled", false, "Toggle for the mod"
        ).getBoolean();
        delay = config.get(
                Configuration.CATEGORY_GENERAL,
                "Delay",3,"Delay in seconds between each message"
        ).getInt();
    }

    public void reset() {
        if (config != null) {
            config.save();
        }
        addGeneralConfig();
    }

    public Configuration getConfig() {
        return config;
    }
    public boolean isEnabled() {
        return enabled;
    }
    public int getDelay() {
        return delay;
    }
}
