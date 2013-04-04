/**
 * 
 */
package jabara.coral.model;

import jabara.coral.service.IItemSetService;
import jabara.coral.web.rest.ItemSetResource;
import jabara.general.ArgUtil;
import jabara.jpa_guice.SinglePersistenceUnitJpaModule;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Provider;

/**
 * @author jabaraster
 */
public final class DI {

    private static Injector _injector = createInjector();

    private DI() {
    }

    /**
     * @param <T>
     * @param pType
     * @return T型のオブジェクト.
     */
    public static <T> T get(final Class<T> pType) {
        ArgUtil.checkNull(pType, "pType"); //$NON-NLS-1$
        return _injector.getInstance(pType);
    }

    /**
     * @return Guiceの{@link Injector}.
     */
    public static Injector getInjector() {
        return _injector;
    }

    private static Injector createInjector() {
        final SinglePersistenceUnitJpaModule jpaModule = new SinglePersistenceUnitJpaModule("Coral"); //$NON-NLS-1$
        final Module module = new AbstractModule() {
            @Override
            protected void configure() {
                bind(ItemSetResource.class).toProvider(new Provider<ItemSetResource>() {
                    @Override
                    public ItemSetResource get() {
                        return new ItemSetResource(DI.get(IItemSetService.class));
                    }
                });
            }
        };
        return Guice.createInjector( //
                jpaModule //
                , module //
                );
    }
}
