package net.avect.vertic.core.command;

import com.google.inject.Injector;
import net.avect.vertic.core.command.node.CommandNode;

public abstract class AbstractCommandRegistrar {

    public abstract <T> void registerCommand(final CommandNode<T> node, final Injector injector);

}
