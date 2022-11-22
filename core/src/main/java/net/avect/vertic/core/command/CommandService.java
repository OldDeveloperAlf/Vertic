package net.avect.vertic.core.command;

import com.google.inject.Injector;
import com.google.inject.Key;
import net.avect.vertic.core.command.annotation.Command;
import net.avect.vertic.core.command.node.CommandNode;
import net.avect.vertic.core.command.parametric.argument.ArgumentParser;
import net.avect.vertic.core.command.parametric.provider.CommandSenderProvider;

public interface CommandService {

    /**
     * Register all nodes in a class.
     *
     * <p>The class will be instantiated by the injector and then
     * all of the methods annotated with the {@link Command}
     * annotation will be registered as command nodes. </p>
     * See {@link CommandNode}
     *
     * @param aClass   the class.
     * @param <T>      the type.
     * @param injector the injector.
     */
    <T> void registerNodes(final Class<? extends T> aClass, Injector injector);

    /**
     * Register a type parser for command arguments.
     *
     * <p>The parser will be registered and cached. </p>
     *
     * @param key    the key.
     * @param parser the parser.
     * @param <T>    the type.
     */
    <T> void registerParser(final Key<? extends T> key, final ArgumentParser<T> parser);

    /**
     * Get a registered parser for command arguments.
     *
     * @param key the key.
     * @param <T> the type.
     * @return Returns an defaults parser for the specified type by it's class.
     */
    <T> ArgumentParser<T> getParser(final Key<? extends T> key);

    /**
     * Register a provider for command sender.
     *
     * <p>The provider will be registered and cached. </p>
     *
     * @param key      the key.
     * @param provider the provider.
     * @param <T>      the type.
     */
    <T> void registerProvider(final Key<? extends T> key, final CommandSenderProvider<T> provider);

    /**
     * Get a registered provider for command sender.
     *
     * @param key the key.
     * @param <T> the type.
     * @return Returns a sender provider for the specified type by it's class.
     */
    <T> CommandSenderProvider<T> getProvider(final Key<? extends T> key);


}
