package net.avect.vertic.core.command.parametric.provider;

import net.avect.vertic.core.command.WrappedSender;

public interface CommandSenderProvider<T> {

    T get(WrappedSender sender);

    String getInvalidSenderMessage(WrappedSender sender);

}
