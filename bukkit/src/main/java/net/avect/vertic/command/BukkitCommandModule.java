package net.avect.vertic.command;

import com.google.inject.Key;
import net.avect.vertic.command.parser.BukkitStringParser;
import net.avect.vertic.command.parser.PlayerParser;
import net.avect.vertic.command.provider.ConsoleProvider;
import net.avect.vertic.command.provider.PlayerProvider;
import net.avect.vertic.command.provider.SenderProvider;
import net.avect.vertic.core.command.AbstractCommandModule;
import net.avect.vertic.core.command.AbstractCommandRegistrar;
import net.avect.vertic.core.command.CommandService;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class BukkitCommandModule extends AbstractCommandModule {

    private final CommandMap commandMap;

    public BukkitCommandModule(final CommandMap commandMap) {
        this.commandMap = commandMap;
    }

    @Override
    public AbstractCommandRegistrar getRegistrar() {
        return new BukkitCommandRegistrar(this.commandMap);
    }

    @Override
    public void registerDefaults(CommandService service) {
        service.registerParser(Key.get(String.class), new BukkitStringParser());
        service.registerParser(Key.get(Player.class), new PlayerParser());

        service.registerProvider(Key.get(CommandSender.class), new SenderProvider());
        service.registerProvider(Key.get(Player.class), new PlayerProvider());
        service.registerProvider(Key.get(ConsoleCommandSender.class), new ConsoleProvider());

    }
}
