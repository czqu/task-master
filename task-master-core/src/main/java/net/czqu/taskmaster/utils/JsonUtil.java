package net.czqu.taskmaster.utils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.LinkedHashMap;
/**
 * @program: task-master
 * @description:
 * @author: Paul Chen
 * @create: 2023-03-15 21:41
 **/
public class JsonUtil {
    public static LinkedHashMap<String, Object> fromJson(String jsonStr) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS, true);
        TypeReference<LinkedHashMap<String, Object>> typeRef = new TypeReference<LinkedHashMap<String, Object>>() {
        };
        return objectMapper.readValue(jsonStr, typeRef);
    }
}
