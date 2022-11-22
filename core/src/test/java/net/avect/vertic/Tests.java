package net.avect.vertic;

import com.google.inject.Guice;
import com.google.inject.Injector;
import net.avect.vertic.core.storage.HashStore;
import net.avect.vertic.core.storage.Store;
import net.avect.vertic.core.storage.named.NamedHashStore;
import net.avect.vertic.core.storage.named.NamedStore;
import org.bukkit.entity.Player;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.UUID;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

@RunWith(PowerMockRunner.class)
public class Tests {

    private static final UUID PLAYER_UUID = UUID.randomUUID();
    private static final String PLAYER_NAME = "Crune";

    private Player player;
    private Injector injector;

    @Before
    public void setup() {
        player = mock(Player.class);
        Mockito.when(player.hasPermission(Mockito.anyString())).thenReturn(true);
        Mockito.when(player.getName()).thenReturn(PLAYER_NAME);
        Mockito.when(player.getUniqueId()).thenReturn(PLAYER_UUID);

        injector = Guice.createInjector(new TestModule());
    }

    @Test
    public void testObject() {
        TestObject testObject = TestObject.TEST_OBJECT;

        assertEquals(testObject.getName(), TestObject.TEST_OBJECT.getName());
        assertEquals(testObject.getUniqueId(), TestObject.TEST_OBJECT.getUniqueId());
    }

    @Test
    public void storageTest() {
        Store<TestObject> store = new HashStore<>();
        assertNotNull(store);
        assertFalse(store.isPresent(UUID.randomUUID()));
        assertNull(store.getById(UUID.randomUUID()));

        TestObject testObject = TestObject.TEST_OBJECT;
        assertFalse(store.isPresent(testObject));
        assertNull(store.getById(testObject.getUniqueId()));

        store.add(testObject);
        assertTrue(store.isPresent(testObject));
        assertTrue(store.isPresent(testObject.getUniqueId()));

        testObject = store.getById(testObject.getUniqueId());
        assertNotNull(testObject);
    }

    @Test
    public void namedStorageTest() {
        NamedStore<TestObject> store = new NamedHashStore<>();
        assertNotNull(store);
        assertFalse(store.isPresent(UUID.randomUUID()));
        assertNull(store.getById(UUID.randomUUID()));
        assertNull(store.getByName(UUID.randomUUID().toString()));
        assertNull(store.getByNameIgnoreCase(UUID.randomUUID().toString()));

        TestObject testObject = TestObject.TEST_OBJECT;
        assertFalse(store.isPresent(testObject));
        assertNull(store.getById(testObject.getUniqueId()));
        assertNull(store.getByName(testObject.getName()));
        assertNull(store.getByNameIgnoreCase(testObject.getName()));

        store.add(testObject);
        assertTrue(store.isPresent(testObject));
        assertTrue(store.isPresent(testObject.getUniqueId()));
        assertFalse(store.isPresent(UUID.randomUUID()));

        assertFalse(store.isPresent(testObject.getName().toUpperCase()));
        assertTrue(store.isPresent(testObject.getName()));

        assertFalse(store.isPresentIgnoreCase(testObject.getName() + UUID.randomUUID().toString()));
        assertTrue(store.isPresentIgnoreCase(testObject.getName()));

        testObject = store.getById(testObject.getUniqueId());
        assertNotNull(testObject);

        testObject = store.getByName(testObject.getName());
        assertNotNull(testObject);

        testObject = store.getByNameIgnoreCase(testObject.getName());
        assertNotNull(testObject);

        testObject = store.getByNameIgnoreCase(testObject.getName() + UUID.randomUUID().toString());
        assertNull(testObject);
    }

    @Test
    //TODO full command framework example
    public void testCommands() {
        TestCommands commands = injector.getInstance(TestCommands.class);
        assertNotNull(commands);

        TestObject testObject = injector.getInstance(TestObject.class);
        assertNotNull(testObject);

        commands.testObject(player, testObject);

        boolean thrown = false;

        try {
            commands.testObject(null, testObject);
        } catch (AssertionError expected) {
            thrown = true;
        }

        assertTrue(thrown);
    }
}
