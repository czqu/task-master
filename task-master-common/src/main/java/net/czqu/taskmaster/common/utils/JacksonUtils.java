package net.czqu.taskmaster.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.time.ZoneId;
import java.util.TimeZone;

/**
 * @program: task-master
 * @description:
 * @author: Paul Chen
 * @create: 2023-03-15 21:41
 **/


public class JacksonUtils {

    private static final ObjectMapper mapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            .setTimeZone(TimeZone.getTimeZone(ZoneId.systemDefault()));

    public static <T> String serialize(T object) throws JsonProcessingException {
        return mapper.writeValueAsString(object);
    }

    public static <T> T deserialize(String json, Class<T> clazz) throws IOException {
        return mapper.readValue(json, clazz);
    }
}
