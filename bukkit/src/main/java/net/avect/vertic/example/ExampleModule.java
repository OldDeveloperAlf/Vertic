package net.avect.vertic.example;

import com.google.inject.AbstractModule;
import com.google.inject.Injector;
import net.avect.vertic.core.command.CommandService;
import net.avect.vertic.core.framework.annotation.PostInject;
import net.avect.vertic.menu.MenuHolderFactory;

public class ExampleModule extends AbstractModule {

    @PostInject
    public void registerCommands(final CommandService service, final Injector injector) {
        service.registerNodes(ExampleCommands.class, injector);
    }

    @PostInject
    public void registerMenus(final MenuHolderFactory factory) {
        factory.createMenu(ExampleMenu.class);
    }

}
