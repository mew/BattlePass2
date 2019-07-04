package zone.nora.battlepass.command;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import zone.nora.battlepass.config.gui.ConfigGui;
import zone.nora.battlepass.util.DelayedTask;

import java.util.Collections;
import java.util.List;

public class Command extends CommandBase {
    @Override
    public String getCommandName() {
        return "bp2";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/bp2";
    }

    @Override
    public List<String> getCommandAliases() {
        return Collections.singletonList("battlepass2");
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        new DelayedTask(Command::openGui,1);
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }

    private static void openGui() {
        Minecraft.getMinecraft().displayGuiScreen(new ConfigGui(null));
    }
}
