package net.avect.vertic.core.command.internal;

import com.google.inject.TypeLiteral;
import net.avect.vertic.core.command.parametric.CommandParameter;
import net.avect.vertic.core.command.parametric.argument.ArgumentParser;
import net.avect.vertic.core.command.parametric.provider.CommandSenderProvider;

class InternalCommandParameter<T> implements CommandParameter<T> {

    private final TypeLiteral<T> typeLiteral;
    private final ArgumentParser<T> parser;
    private final CommandSenderProvider<T> provider;
    private final String name;
    private final boolean argument, optional, injected, sender, text;

    InternalCommandParameter(final TypeLiteral<T> typeLiteral, final ArgumentParser<T> parser, CommandSenderProvider<T> provider, final String name, boolean argument, final boolean optional, final boolean injected, final boolean sender, final boolean text) {
        this.typeLiteral = typeLiteral;
        this.parser = parser;
        this.provider = provider;
        this.name = name;
        this.argument = argument;
        this.optional = optional;
        this.injected = injected;
        this.sender = sender;
        this.text = text;
    }

    @Override
    public TypeLiteral<T> getTypeLiteral() {
        return this.typeLiteral;
    }

    @Override
    public ArgumentParser<T> getParser() {
        return this.parser;
    }

    @Override
    public CommandSenderProvider<T> getSenderProvider() {
        return this.provider;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean isArgument() {
        return this.argument;
    }

    @Override
    public boolean isOptional() {
        return this.optional;
    }

    @Override
    public boolean isInjected() {
        return this.injected;
    }

    @Override
    public boolean isSender() {
        return this.sender;
    }

    @Override
    public boolean hasText() {
        return this.text;
    }
}
