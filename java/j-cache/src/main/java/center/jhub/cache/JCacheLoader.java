package center.jhub.cache;

public interface JCacheLoader<K, V> {

    V load(K key);
}
