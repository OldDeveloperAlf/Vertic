package net.avect.vertic;

import net.avect.vertic.core.storage.Storable;
import net.avect.vertic.core.storage.named.Nameable;

import java.util.UUID;

public class TestObject implements Storable, Nameable {

    public static final TestObject TEST_OBJECT = new TestObject();

    private final UUID uniqueId;
    private final String name;

    public TestObject() {
        this.uniqueId = UUID.randomUUID();
        this.name = UUID.randomUUID().toString().substring(0, 5);
    }

    @Override
    public UUID getUniqueId() {
        return this.uniqueId;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
