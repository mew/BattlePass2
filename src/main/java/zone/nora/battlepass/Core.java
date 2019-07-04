package zone.nora.battlepass;

import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import zone.nora.battlepass.command.Command;
import zone.nora.battlepass.config.Config;
import zone.nora.battlepass.listener.ChatListener;
import zone.nora.battlepass.listener.TickListener;
import zone.nora.battlepass.util.Multithreading;
import zone.nora.battlepass.util.Words;

@Mod(modid = Core.MODID,name = Core.MODID,version = Core.VERSION,guiFactory = Core.GUIFACTORY)
public class Core {
    public static final String MODID = "BattlePass2";
    public static final String VERSION = "2.0.1";
    public static final String GUIFACTORY = "zone.nora.battlepass.config.gui.ConfigGuiFactory";

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        Config.initialize(e.getSuggestedConfigurationFile());
    }

    @EventHandler
    public void init(FMLInitializationEvent e) {
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new TickListener());
        MinecraftForge.EVENT_BUS.register(new ChatListener());
        ClientCommandHandler.instance.registerCommand(new Command());

        try {
            Multithreading.runAsync(Words::grabWordsList);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Failed to grab words list :(");
        }
    }
}
