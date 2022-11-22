package net.avect.vertic.menu;

import org.bukkit.entity.Player;

import java.util.Collection;

public interface MenuHolderService {

    /**
     * Opens the holder's menu for the player.
     */
    void openHolder(final Player player, final MenuHolder holder);

    /**
     * Forcefully closes the player's inventory and also invalidates the player from the cache.
     */
    void forceCloseHolder(final Player player, final boolean invalidateOnly);

    /**
     * Returns the player's currently open menu holder. May return null if no holder is present.
     */
    MenuHolder getOpenHolder(final Player player);

    /**
     * Returns a collection of player's who currently has an holder with a menu open.
     */
    Collection<? extends Player> getPlayersWithOpenHolders();

}
