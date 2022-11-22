package net.avect.vertic;

import net.avect.vertic.command.BungeeCommandModule;
import net.avect.vertic.framework.BungeeProject;
import net.avect.vertic.example.ExampleModule;
import net.md_5.bungee.api.plugin.PluginManager;

import java.util.Optional;

public class Vertic extends BungeeProject {

    @Override
    public Optional<String> getParentPluginName() {
        return Optional.empty();
    }

    @Override
    public void configure() {
        install(new BungeeCommandModule(getInjector().getInstance(PluginManager.class)));
        install(new ExampleModule());
    }
}
