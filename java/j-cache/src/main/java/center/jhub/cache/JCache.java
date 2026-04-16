package center.jhub.cache;


import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import lombok.Getter;

public class JCache<K, V> {

    private final Map<K, JCacheNode<V>> cacheNodeMap;

    @Getter
    private final JCacheManager<K, V> manager;

    protected JCache(JCacheManager<K, V> manager) {
        this.manager = manager;
        this.cacheNodeMap = new HashMap<>();
    }

    public V get(K key, JCacheLoader<K, V> loader) {
        Instant now = Instant.now();
        JCacheNode<V> node = cacheNodeMap.get(key);
        if (Objects.isNull(node)) {
            return put(key, loader);
        }

        if (node.getCreatedAt().until(now, ChronoUnit.SECONDS) >= manager.getExpiryInSeconds()) {
            cacheNodeMap.remove(key);
            return put(key, loader);
        }

        return node.getValue();
    }

    public V get(K key) {
        requireLoader();
        return get(key, manager.getLoader());
    }

    public void invalidate(K key) {
        cacheNodeMap.remove(key);
    }

    public void invalidateAll() {
        cacheNodeMap.clear();
    }

    private V put(K key, JCacheLoader<K, V> loader) {
        V value = loader.load(key);
        JCacheNode<V> node = new JCacheNode<>(value);
        cacheNodeMap.put(key, node);
        return node.getValue();
    }

    private void requireLoader() {
        if (Objects.isNull(this.manager.getLoader())) {
            throw new IllegalStateException("loader is required");
        }
    }
}
