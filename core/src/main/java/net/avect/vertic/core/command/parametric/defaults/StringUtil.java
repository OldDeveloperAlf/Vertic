package net.avect.vertic.core.command.parametric.defaults;

import org.apache.commons.lang.Validate;

import java.util.Collection;
import java.util.Iterator;

public class StringUtil {
    public StringUtil() {
    }

    public static <T extends Collection<? super String>> T copyPartialMatches(String token, Iterable<String> originals, T collection) throws UnsupportedOperationException, IllegalArgumentException {
        Validate.notNull(token, "Search token cannot be null");
        Validate.notNull(collection, "Collection cannot be null");
        Validate.notNull(originals, "Originals cannot be null");
        Iterator var4 = originals.iterator();

        while (var4.hasNext()) {
            String string = (String) var4.next();
            if (startsWithIgnoreCase(string, token)) {
                collection.add(string);
            }
        }

        return collection;
    }

    public static boolean startsWithIgnoreCase(String string, String prefix) throws IllegalArgumentException, NullPointerException {
        Validate.notNull(string, "Cannot check a null string for a match");
        return string.length() < prefix.length() ? false : string.regionMatches(true, 0, prefix, 0, prefix.length());
    }
}