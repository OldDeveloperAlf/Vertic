package net.avect.vertic;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.TypeLiteral;
import net.avect.vertic.core.storage.named.NamedHashStore;
import net.avect.vertic.core.storage.named.NamedStore;

public class TestModule extends AbstractModule {

    private final NamedStore<TestObject> store;

    public TestModule() {
        this.store = new NamedHashStore<>();
    }

    @Override
    protected void configure() {
        bind(new TypeLiteral<NamedStore<TestObject>>() {
        }).toInstance(store);

        store.add(TestObject.TEST_OBJECT);
    }

    @Provides
    public TestObject testObject() {
        return store.getByName(TestObject.TEST_OBJECT.getName());
    }
}

