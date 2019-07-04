package zone.nora.battlepass.listener;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import zone.nora.battlepass.config.Config;

public class ChatListener {
    @SubscribeEvent
    public void onChat(ClientChatReceivedEvent e) {
        String msg = e.message.getUnformattedText();
        if (msg.contains("joined the lobby") && Config.getInstance().isEnabled()) {
            Minecraft.getMinecraft().thePlayer.sendChatMessage("/home");
        }
    }
}
