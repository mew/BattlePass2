package zone.nora.battlepass.config.gui;

import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import zone.nora.battlepass.Core;
import zone.nora.battlepass.config.Config;

public class ConfigGui extends GuiConfig {
    public ConfigGui(GuiScreen parentScreen) {
        super(
                parentScreen,
                new ConfigElement(
                        Config.getInstance()
                                .getConfig()
                                .getCategory(Configuration.CATEGORY_GENERAL))
                        .getChildElements(),
                Core.MODID,
                false,
                false,
                "BattlePass 2");
    }

    @Override
    public void onGuiClosed() {
        Config.getInstance().reset();
    }
}
