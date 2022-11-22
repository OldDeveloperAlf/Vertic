package net.avect.vertic.command.provider;

import net.avect.vertic.core.command.WrappedSender;
import net.avect.vertic.core.command.parametric.provider.CommandSenderProvider;
import org.bukkit.command.ConsoleCommandSender;

public class ConsoleProvider implements CommandSenderProvider<ConsoleCommandSender> {

    @Override
    public ConsoleCommandSender get(WrappedSender sender) {
        if (!(sender.get() instanceof ConsoleCommandSender)) {
            return null;
        }

        return sender.get();
    }

    @Override
    public String getInvalidSenderMessage(WrappedSender sender) {
        return "&7Sorry but this command is only executable by console.";
    }
}
