package net.avect.vertic;

import net.avect.vertic.core.command.annotation.Command;
import net.avect.vertic.core.command.annotation.Injected;
import net.avect.vertic.core.command.annotation.Sender;
import org.bukkit.entity.Player;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class TestCommands {

    @Command(aliases = "example object")
    public void testObject(@Sender Player player, @Injected TestObject testObject) {
        assertNotNull(testObject);
        assertEquals(testObject, TestObject.TEST_OBJECT);

        assertNotNull(player);
    }

}
