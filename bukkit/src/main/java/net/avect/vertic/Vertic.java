package net.avect.vertic;

import net.avect.vertic.command.BukkitCommandModule;
import net.avect.vertic.framework.BukkitProject;
import net.avect.vertic.menu.MenuModule;
import net.avect.vertic.nametag.NameTagModule;
import net.avect.vertic.sidebar.SidebarModule;
import net.avect.vertic.example.ExampleModule;
import org.bukkit.command.CommandMap;

import java.util.Optional;

public class Vertic extends BukkitProject {

    @Override
    public Optional<String> getParentPluginName() {
        return Optional.empty();
    }

    @Override
    public void configure() {
        install(new BukkitCommandModule(getInjector().getInstance(CommandMap.class)));
        install(new MenuModule());
        install(new SidebarModule());
        install(new NameTagModule());
        install(new ExampleModule());
    }
}
