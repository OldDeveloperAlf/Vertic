package net.avect.vertic.command.provider;

import net.avect.vertic.core.command.WrappedSender;
import net.avect.vertic.core.command.parametric.provider.CommandSenderProvider;
import org.bukkit.entity.Player;

public class PlayerProvider implements CommandSenderProvider<Player> {

    @Override
    public Player get(WrappedSender sender) {
        if (!(sender.get() instanceof Player)) {
            return null;
        }

        return (Player) sender.get();
    }

    @Override
    public String getInvalidSenderMessage(WrappedSender sender) {
        return "&7Sorry but this command is only executable by players.";
    }
}
