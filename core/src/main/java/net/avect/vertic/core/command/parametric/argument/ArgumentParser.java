package net.avect.vertic.core.command.parametric.argument;

import net.avect.vertic.core.command.WrappedSender;
import net.avect.vertic.core.command.node.CommandContext;

import java.util.List;

public interface ArgumentParser<T> {

    /**
     * Parse a type by command defaults.
     *
     * @param sender   the sender.
     * @param context  the context.
     * @param argument the defaults.
     * @param <C>      the type.
     * @return Returns an instance of the parsed defaults type.
     */
    <C> T parse(final WrappedSender sender, final CommandContext<C> context, final String argument);

    /**
     * Get the message when an invalid parsing of an defaults
     * has occured.
     *
     * @param sender  the sender.
     * @param invalid the invalid defaults.
     * @return Returns the error message for invalid parsing.
     */
    String getParseMessage(final WrappedSender sender, final String invalid);

    //TODO
    <C> List<String> getSuggestions(final WrappedSender sender, final CommandContext<C> context, final String lastWord);

}
