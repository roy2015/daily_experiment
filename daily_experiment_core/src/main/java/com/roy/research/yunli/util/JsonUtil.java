package com.roy.research.yunli.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * @author : zhengyangyong
 */
public class JsonUtil {
  private static final ObjectMapper MAPPER = new ObjectMapper();

  static {
    MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
  }

  public static String writeValueAsString(Object obj) {
    return writeValueAsString(obj, false);
  }

  public static String writeValueAsString(Object obj, boolean indentOutput) {
    return writeValueAsString(obj, indentOutput, null);
  }

  public static String writeValueAsString(Object obj, String dateFormat) {
    return writeValueAsString(obj, false, dateFormat);
  }

  public static String writeValueAsString(Object obj, boolean indentOutput, String dateFormat) {
    if (obj == null) {
      return null;
    }
    try {
      String result;
      boolean formatDate = StringUtil.hasText(dateFormat);
      if (indentOutput || formatDate) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        if (indentOutput) {
          mapper.enable(SerializationFeature.INDENT_OUTPUT);
        }
        if (formatDate) {
          mapper.setDateFormat(new SimpleDateFormat(dateFormat));
        }
        result = mapper.writeValueAsString(obj);
      } else {
        result = MAPPER.writeValueAsString(obj);
      }
      return result;
    } catch (JsonProcessingException ex) {
      throw new RuntimeException(ex);
    }
  }

  public static <T> T readValue(String json, Class<T> type) {
    if (StringUtil.isEmpty(json)) {
      return null;
    }
    try {
      return MAPPER.readValue(json, type);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static <T> List<T> readListValue(String json, Class<T> type) {
    if (StringUtil.isEmpty(json)) {
      return null;
    }
    try {
      JavaType javaType = MAPPER.getTypeFactory().constructParametricType(ArrayList.class, type);
      return MAPPER.readValue(json, javaType);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static <T> List<T> readListValue(String json, String type) {
    if (StringUtil.isEmpty(json)) {
      return null;
    }
    try {
      JavaType javaType = MAPPER.getTypeFactory().constructParametricType(ArrayList.class, Class.forName(type));
      return MAPPER.readValue(json, javaType);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static <T> Set<T> readSetValue(String json, Class<T> type) {
    if (StringUtil.isEmpty(json)) {
      return null;
    }
    try {
      JavaType javaType = MAPPER.getTypeFactory().constructParametricType(HashSet.class, type);
      return MAPPER.readValue(json, javaType);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static <K, V> Map<K, V> readMapValue(String json, Class<K> keyType, Class<V> valueType) {
    if (StringUtil.isEmpty(json)) {
      return null;
    }
    try {
      JavaType javaType = MAPPER.getTypeFactory().constructMapType(HashMap.class, keyType, valueType);
      return MAPPER.readValue(json, javaType);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static <K, V> List<Map<K, V>> readListMapValue(String json, Class<K> keyType, Class<V> valueType) {
    if (StringUtil.isEmpty(json)) {
      return null;
    }
    try {
      JavaType javaType = MAPPER.getTypeFactory().constructMapType(HashMap.class, keyType, valueType);
      javaType = MAPPER.getTypeFactory().constructParametricType(ArrayList.class, javaType);
      return MAPPER.readValue(json, javaType);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static <T> T clone(Object input, Class<T> type) {
    if (input == null) {
      return null;
    }
    return readValue(JsonUtil.writeValueAsString(input), type);
  }

  public static <K, V> Map<K, V> clone(Object input, Class<K> keyType, Class<V> valueType) {
    if (input == null) {
      return null;
    }
    return readMapValue(JsonUtil.writeValueAsString(input), keyType, valueType);
  }

  public static Object convert(Object input, Class<?> type) {
    if (input == null) {
      return null;
    }
    return readValue(JsonUtil.writeValueAsString(input), type);
  }
}
