package net.avect.vertic.core.config;

import net.avect.vertic.core.concurrent.Callback;

import java.io.File;
import java.util.List;

public interface Config {

    /**
     * Returns the config's file.
     */
    File getFile();

    /**
     * Get an object from the config by it's path.
     *
     * @param path the path.
     * @param <T>  the type.
     * @return Returns an object from the config specified by it's path.
     */
    <T> T get(final String path);

    /**
     * Returns a list of string from the config specified by it's path.
     */
    List<String> getList(final String path);

    /**
     * Set an object in the config with a path.
     *
     * @param path the path.
     * @param t    the object.
     * @param <T>  the type.
     */
    <T> void set(final String path, final T t);

    /**
     * Reloads the config from the file.
     */
    void reload();

    /**
     * Reloads the config from the file asynchronously.
     */
    void reloadAsync(final Callback callback);

    /**
     * Saves the config to it's file.
     */
    void save();

    /**
     * Saves the config to it's file asynchronously.
     */
    void saveAsync(final Callback callback);

    /**
     * Deletes the config from it's file.
     */
    void delete();

}
