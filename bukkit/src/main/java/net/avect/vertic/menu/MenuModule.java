package net.avect.vertic.menu;

import com.google.inject.AbstractModule;
import com.google.inject.Injector;
import com.google.inject.TypeLiteral;
import net.avect.vertic.core.framework.annotation.PostInject;
import net.avect.vertic.core.storage.named.NamedHashStore;
import net.avect.vertic.core.storage.named.NamedStore;
import net.avect.vertic.menu.internal.InternalMenuHolderFactory;
import net.avect.vertic.menu.internal.InternalMenuHolderService;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.scheduler.BukkitScheduler;

public class MenuModule extends AbstractModule {

    @Override
    protected void configure() {
        final NamedStore<MenuHolder> store = new NamedHashStore<>();
        bind(new TypeLiteral<NamedStore<MenuHolder>>() {
        }).toInstance(store);
        bind(MenuHolderFactory.class).toInstance(new InternalMenuHolderFactory(getProvider(Injector.class), store));
        bind(MenuHolderService.class).toInstance(new InternalMenuHolderService(store));
    }

    @PostInject
    public void registerListeners(final Plugin plugin, final PluginManager manager, final MenuListener listener) {
        manager.registerEvents(listener, plugin);
    }

    @PostInject
    public void startTask(final Plugin plugin, final BukkitScheduler scheduler, final MenuRunnable runnable) {
        scheduler.runTaskTimerAsynchronously(plugin, runnable, 2L, 2L);
    }
}
