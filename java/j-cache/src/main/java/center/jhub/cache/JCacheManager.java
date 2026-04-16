package center.jhub.cache;

import java.time.Duration;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class JCacheManager<K, V> {

    @Getter
    private Duration refreshAfterWrite;

    @Getter
    private JCacheLoader<K, V> loader;

    public long getExpiryInSeconds() {
        return refreshAfterWrite.getSeconds();
    }
}
