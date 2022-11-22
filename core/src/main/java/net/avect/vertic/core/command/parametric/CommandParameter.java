package net.avect.vertic.core.command.parametric;

import com.google.inject.TypeLiteral;
import net.avect.vertic.core.command.parametric.argument.ArgumentParser;
import net.avect.vertic.core.command.parametric.provider.CommandSenderProvider;

public interface CommandParameter<T> {

    /**
     * Returns this parameters generic type class. See {@link TypeLiteral#getType()}
     */
    TypeLiteral<T> getTypeLiteral();

    /**
     * Returns the parser for this parameters generic type.
     */
    ArgumentParser<T> getParser();

    /**
     * Returns the sender provider for this parameters generic type.
     */
    CommandSenderProvider<T> getSenderProvider();

    /**
     * Returns the name for this parameter.
     */
    String getName();

    /**
     * Returns a boolean whether this parameter is an defaults or not.
     */
    boolean isArgument();

    /**
     * Returns a boolean whether this parameter is optional or not.
     */
    boolean isOptional();

    /**
     * Returns a boolean whether this parameter is injected or not.
     */
    boolean isInjected();

    /**
     * Returns a boolean whether this parameter is a sender or not.
     */
    boolean isSender();

    /**
     * Returns a boolean whether this parameter has text or not.
     */
    boolean hasText();

}
