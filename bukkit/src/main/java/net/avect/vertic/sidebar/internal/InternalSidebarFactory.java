package net.avect.vertic.sidebar.internal;

import net.avect.vertic.sidebar.Sidebar;
import net.avect.vertic.sidebar.SidebarFactory;
import org.bukkit.entity.Player;

public class InternalSidebarFactory implements SidebarFactory {

    @Override
    public Sidebar createSidebar(Player player) {
        return new InternalSidebar(player);
    }
}
