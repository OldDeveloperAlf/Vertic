package net.avect.vertic.core.command.parametric.defaults;

import net.avect.vertic.core.command.WrappedSender;
import net.avect.vertic.core.command.node.CommandContext;
import net.avect.vertic.core.command.parametric.argument.ArgumentParser;

import java.util.Collections;
import java.util.List;

public class LongParser implements ArgumentParser<Long> {

    @Override
    public <C> Long parse(WrappedSender sender, CommandContext<C> context, String argument) {
        Long l;

        try {
            l = Long.parseLong(argument);
        } catch (NumberFormatException e) {
            return null;
        }

        return l;
    }

    @Override
    public String getParseMessage(WrappedSender sender, String invalid) {
        return String.format("&c%s is not a valid long.", invalid);
    }

    @Override
    public <C> List<String> getSuggestions(WrappedSender sender, CommandContext<C> context, String lastWord) {
        if (lastWord.length() == 0) {
            return Collections.singletonList("0");
        }

        long lastLong;

        try {
            lastLong = Long.parseLong(lastWord);
        } catch (NumberFormatException e) {
            return Collections.singletonList("0");
        }

        return Collections.singletonList(lastLong + 1 + "");
    }
}
