package net.avect.vertic.menu;

import com.google.common.collect.Table;
import net.avect.vertic.menu.annotation.MenuMeta;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@MenuMeta(aliases = "menu", title = "menu")
public interface Menu {

    Table<Integer, ItemStack, MenuAction> render(final Player player);

}
