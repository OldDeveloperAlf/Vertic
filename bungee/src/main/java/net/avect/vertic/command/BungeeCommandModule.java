package net.avect.vertic.command;

import com.google.inject.Key;
import net.avect.vertic.command.parser.BungeeStringParser;
import net.avect.vertic.command.parser.ProxiedPlayerParser;
import net.avect.vertic.command.provider.PlayerProvider;
import net.avect.vertic.command.provider.SenderProvider;
import net.avect.vertic.core.command.AbstractCommandModule;
import net.avect.vertic.core.command.AbstractCommandRegistrar;
import net.avect.vertic.core.command.CommandService;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.PluginManager;

public class BungeeCommandModule extends AbstractCommandModule {

    private final PluginManager pluginManager;

    public BungeeCommandModule(PluginManager pluginManager) {
        this.pluginManager = pluginManager;
    }

    @Override
    public AbstractCommandRegistrar getRegistrar() {
        return new BungeeCommandRegistrar(this.pluginManager);
    }

    @Override
    public void registerDefaults(CommandService service) {
        service.registerParser(Key.get(String.class), new BungeeStringParser());
        service.registerParser(Key.get(ProxiedPlayer.class), new ProxiedPlayerParser());

        service.registerProvider(Key.get(CommandSender.class), new SenderProvider());
        service.registerProvider(Key.get(ProxiedPlayer.class), new PlayerProvider());

    }
}
