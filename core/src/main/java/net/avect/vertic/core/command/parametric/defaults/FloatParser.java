package net.avect.vertic.core.command.parametric.defaults;

import net.avect.vertic.core.command.WrappedSender;
import net.avect.vertic.core.command.node.CommandContext;
import net.avect.vertic.core.command.parametric.argument.ArgumentParser;

import java.util.Collections;
import java.util.List;

public class FloatParser implements ArgumentParser<Float> {

    @Override
    public <C> Float parse(WrappedSender sender, CommandContext<C> context, String argument) {
        Float f;

        try {
            f = Float.parseFloat(argument);
        } catch (NumberFormatException e) {
            return null;
        }

        return f;
    }

    @Override
    public String getParseMessage(WrappedSender sender, String invalid) {
        return String.format("&c%s is not a valid float.", invalid);
    }

    @Override
    public <C> List<String> getSuggestions(WrappedSender sender, CommandContext<C> context, String lastWord) {
        if (lastWord.length() == 0) {
            return Collections.singletonList("0");
        }

        float lastFloat;

        try {
            lastFloat = Float.parseFloat(lastWord);
        } catch (NumberFormatException e) {
            return Collections.singletonList("0");
        }

        return Collections.singletonList(lastFloat + 1 + "");
    }
}
