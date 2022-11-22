package net.avect.vertic.nametag.internal;

import net.avect.vertic.nametag.NameTag;
import net.avect.vertic.nametag.NameTagFactory;
import org.bukkit.entity.Player;

public class InternalNameTagFactory implements NameTagFactory {

    @Override
    public NameTag createNameTag(final Player player) {
        return new InternalNameTag(player);
    }
}
