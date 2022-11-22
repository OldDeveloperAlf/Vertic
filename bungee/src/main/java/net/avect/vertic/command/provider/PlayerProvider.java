package net.avect.vertic.command.provider;

import net.avect.vertic.core.command.WrappedSender;
import net.avect.vertic.core.command.parametric.provider.CommandSenderProvider;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class PlayerProvider implements CommandSenderProvider<ProxiedPlayer> {

    @Override
    public ProxiedPlayer get(WrappedSender sender) {
        if (!(sender.get() instanceof ProxiedPlayer)) {
            return null;
        }

        return (ProxiedPlayer) sender.get();
    }

    @Override
    public String getInvalidSenderMessage(WrappedSender sender) {
        return "&7Sorry but this command is only executable by players.";
    }
}
