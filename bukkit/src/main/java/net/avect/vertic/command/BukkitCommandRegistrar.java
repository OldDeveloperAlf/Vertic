package net.avect.vertic.command;

import com.google.inject.Inject;
import com.google.inject.Injector;
import net.avect.vertic.core.command.AbstractCommandRegistrar;
import net.avect.vertic.core.command.node.CommandContext;
import net.avect.vertic.core.command.node.CommandNode;
import org.bukkit.command.CommandMap;

public class BukkitCommandRegistrar extends AbstractCommandRegistrar {

    private final CommandMap map;

    @Inject
    public BukkitCommandRegistrar(final CommandMap map) {
        this.map = map;
    }

    @Override
    public <T> void registerCommand(CommandNode<T> node, Injector injector) {
        CommandContext<T> context = node.getContext();

        map.register(context.getFallbackPrefix(), new BukkitBaseCommand<>(context.getName(), node, injector));
    }
}
