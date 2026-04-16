package center.jhub.cache;

import java.time.Instant;
import lombok.Getter;

@Getter
public class JCacheNode<V> {

    private Instant createdAt;
    private V value;

    public JCacheNode(V value) {
        this.value = value;
        this.createdAt = Instant.now();
    }
}
