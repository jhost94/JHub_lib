package center.jhub.cache;

import java.time.Duration;
import java.util.Objects;

public class JCacheFactory<K, V> {
    private Duration refreshAfterWrite;
    private JCacheLoader<?, ?> loader;

    private JCacheFactory() {}

    public static <K, V> JCacheFactory<K, V> factory() {
        return new JCacheFactory<>();
    }

    public JCacheFactory<K, V> refreshAfterWrite(Duration refreshAfterWrite) {
        this.refreshAfterWrite = refreshAfterWrite;
        return this;
    }

    public <K1 extends K, V1 extends V> JCacheFactory<K1, V1> loader(JCacheLoader<K1, V1> loader) {
        this.loader = loader;
        return (JCacheFactory<K1, V1>) this;
    }

    public <K1 extends K, V1 extends V> JCache<K1, V1> build(JCacheLoader<K1, V1> loader) {
        JCacheManager<K1, V1> manager = new JCacheManager<>(this.refreshAfterWrite, loader);
        return new JCache<>(manager);
    }

    public <K1 extends K, V1 extends V> JCache<K1, V1> build() {
        JCacheManager<K1, V1> manager = (JCacheManager<K1, V1>) new JCacheManager<>(this.refreshAfterWrite, this.loader);
        return new JCache<>(manager);
    }

    private void requireRequirements() {
        if (Objects.isNull(this.refreshAfterWrite)) {
            throw new IllegalStateException("refreshAfterWrite is required");
        }
    }
}
