package net.avect.vertic.command.provider;

import net.avect.vertic.core.command.WrappedSender;
import net.avect.vertic.core.command.parametric.provider.CommandSenderProvider;
import org.bukkit.command.CommandSender;

public class SenderProvider implements CommandSenderProvider<CommandSender> {

    @Override
    public CommandSender get(WrappedSender sender) {
        return sender.get();
    }

    @Override
    public String getInvalidSenderMessage(WrappedSender sender) {
        return null;
    }
}
