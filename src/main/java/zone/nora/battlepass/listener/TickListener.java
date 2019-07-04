package zone.nora.battlepass.listener;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import zone.nora.battlepass.config.Config;
import zone.nora.battlepass.util.DelayedTask;
import zone.nora.battlepass.util.Words;

public class TickListener {
    private static boolean dontSend = false;

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent e) {
        if (dontSend || !Config.getInstance().isEnabled() || Minecraft.getMinecraft().currentScreen != null) return;

        int delayInTicks = Config.getInstance().getDelay() * 20;
        try {
            int word1 = (int) (Math.random() * Words.fullWordsList.length);
            int word2 = (int) (Math.random() * Words.fullWordsList.length);
            int word3 = (int) (Math.random() * Words.fullWordsList.length);
            int word4 = (int) (Math.random() * Words.fullWordsList.length);
            int word5 = (int) (Math.random() * Words.fullWordsList.length);

            Minecraft.getMinecraft().thePlayer.sendChatMessage(Words.fullWordsList[word1] + " " + Words.fullWordsList[word2] + " " + Words.fullWordsList[word3] + " " + Words.fullWordsList[word4] + " " + Words.fullWordsList[word5]);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        dontSend = true;
        new DelayedTask(TickListener::setFalse,delayInTicks);
    }

    private static void setFalse() {
        dontSend = false;
    }
}