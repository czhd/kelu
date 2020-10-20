package pro.kelu.missyou.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pro.kelu.missyou.exception.http.ServerErrorException;

import java.util.List;

@Component
public class GenericAndJson {

    private static ObjectMapper mapper;

    @Autowired
    private void setMapper(ObjectMapper mapper) {
        GenericAndJson.mapper = mapper;
    }

    public static <T> String objectToJson(T o) {
        try {
            return GenericAndJson.mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }

    public static <T> T jsonToObject(String s, TypeReference<T> t) {
        try {
            if (s == null) {
                return null;
            }
            T tt = GenericAndJson.mapper.readValue(s, t);
            return tt;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }

    // List<T> T为泛型
//    public static <T> List<T> jsonToList(String s) {
//        try {
//            if (s == null) {
//                return null;
//            }
//            return GenericAndJson.mapper.readValue(s, new TypeReference<List<T>>() {
//            });
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//            throw new ServerErrorException(9999);
//        }
//    }

    //整体 List<T> 当做一个泛型
//    public static <T> T jsonToList(String s, TypeReference<T> t) {
//        try {
//            if (s == null) {
//                return null;
//            }
//            return GenericAndJson.mapper.readValue(s, t);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//            throw new ServerErrorException(9999);
//        }
//    }
}
