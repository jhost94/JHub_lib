package center.jhub.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.util.Objects;

public class ObjectMappers {
    private static ObjectMapper DEFAULT_OBJECT_MAPPER;

    public static ObjectMapper getInstance() {
        if (Objects.isNull(DEFAULT_OBJECT_MAPPER)) {
            DEFAULT_OBJECT_MAPPER = JsonMapper.builder()
                                        .enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS)
                                        .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                                        .build();
            DEFAULT_OBJECT_MAPPER.registerModule(new JavaTimeModule());
            DEFAULT_OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        }

        return DEFAULT_OBJECT_MAPPER;
    }
}
