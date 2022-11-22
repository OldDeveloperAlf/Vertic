package net.avect.vertic.example;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import net.avect.vertic.menu.Menu;
import net.avect.vertic.menu.MenuAction;
import net.avect.vertic.menu.Menus;
import net.avect.vertic.menu.RowType;
import net.avect.vertic.menu.annotation.MenuMeta;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@MenuMeta(aliases = "example", title = "&lTesting")
public class ExampleMenu implements Menu {

    @Override
    public Table<Integer, ItemStack, MenuAction> render(Player player) {
        Table<Integer, ItemStack, MenuAction> table = HashBasedTable.create();

        /* Fill bedrock around the inventory. */
        Menus.fill(table, new ItemStack(Material.BEDROCK), 3, RowType.AROUND);

        /* Set a nether star in the middle. */
        table.put(13, new ItemStack(Material.NETHER_STAR), clickType -> {
            player.closeInventory();
            player.sendMessage(ChatColor.GOLD + "You just clicked a star!");
            return true;
        });

        return table;
    }

}
