package com.guo.roy.research.misc.yunli.util;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : zhengyangyong
 */
public class StringUtil {

  public static final String EMPTY = "";

  public static final String LINUX_SEPARATOR = "/";

  public static boolean isEmpty(String string) {
    return string == null || "".equals(string.trim());
  }

  public static boolean hasText(String string) {
    return !isEmpty(string);
  }

  public static String formatLikeValue(String condition) {
    if (!hasText(condition)) {
      return null;
    }
    String formattedCondition = condition;
    if (formattedCondition.contains("/")) {
      formattedCondition = formattedCondition.replace("/", "//");
    }
    if (formattedCondition.contains("_")) {
      formattedCondition = formattedCondition.replace("_", "/_");
    }
    if (formattedCondition.contains("%")) {
      formattedCondition = formattedCondition.replace("%", "/%");
    }
    return "%" + formattedCondition + "%";
  }

  public static <T> String join(Character delimiter, Collection<T> objects) {
    return join(delimiter.toString(), objects);
  }

  public static <T> String join(String delimiter, Collection<T> objects) {
    StringBuilder builder = new StringBuilder();
    objects.forEach(object -> {
      if (object != null) {
        builder.append(object);
        builder.append(delimiter);
      }
    });
    if (builder.length() != 0) {
      builder.delete(builder.length() - delimiter.length(), builder.length());
    }
    return builder.toString();
  }

  public static String substring(String string, int maxLength) {
    if (string != null && string.length() > maxLength) {
      return string.substring(0, maxLength);
    }
    return string;
  }

  public static String enhancedFormat(String template, Map<String, Object> parameters) {
    if (template != null && template.contains("{") && template.contains("}")) {
      String regex = "\\{([^\\}]*)\\}";
      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(template);
      Map<String, String> parameterRealValues = new HashMap<>();
      while (matcher.find()) {
        String parameter = matcher.group();
        String parameterBody = parameter.substring(1, parameter.length() - 1);
        if (parameterBody.contains(":")) {
          String[] nameAndFormat = parameterBody.split(":");
          if (nameAndFormat.length == 2) {
            String name = nameAndFormat[0].trim();
            String format = nameAndFormat[1].trim();
            if (parameters.containsKey(name)) {
              if (!isEmpty(format)) {
                parameterRealValues.put(parameter, String.format(format, parameters.get(name)));
              } else {
                parameterRealValues.put(parameter, parameters.get(name).toString());
              }
            } else {
              parameterRealValues.put(parameter, "???");
            }
          } else {
            parameterRealValues.put(parameter, "???");
          }
        } else {
          if (parameters.containsKey(parameterBody)) {
            parameterRealValues.put(parameter, parameters.get(parameterBody).toString());
          } else {
            parameterRealValues.put(parameter, "???");
          }
        }
      }

      if (parameterRealValues.size() != 0) {
        String result = template;
        for (Entry<String, String> parameterRealValue : parameterRealValues.entrySet()) {
          result = result.replace(parameterRealValue.getKey(), parameterRealValue.getValue());
        }
        return result;
      }
    }
    return template;
  }

  private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

  public static String bytesToHex(byte[] bytes) {
    char[] hexChars = new char[bytes.length * 2];
    for (int j = 0; j < bytes.length; j++) {
      int v = bytes[j] & 0xFF;
      hexChars[j * 2] = HEX_ARRAY[v >>> 4];
      hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
    }
    return new String(hexChars);
  }

  public static String replaceParameters(String source, Map<String, String> parameterValues) {
    if (CollectionUtil.isNotEmpty(parameterValues) && StringUtil.hasText(source) &&
        source.contains("${") && source.contains("}")) {
      String result = source;
      for (Entry<String, String> parameterValue : parameterValues.entrySet()) {
        if (parameterValue.getValue() != null) {
          result = result.replace("${" + parameterValue.getKey() + "}", parameterValue.getValue());
        }
      }
      return result;
    }
    return source;
  }

  public static String toBase64String(String string) {
    if (StringUtil.hasText(string)) {
      return new String(Base64.getEncoder().encode(string.getBytes(StandardCharsets.UTF_8)),
          StandardCharsets.UTF_8);
    }
    return string;
  }

  /**
   * 判断字符串中是否包含中文
   *
   * @param str 待校验字符串
   * @return 是否为中文
   * @warn 不能校验是否为中文标点符号
   */
  public static boolean isContainsChinese(String str) {
    if (str == null) {
      return false;
    }
    String regex = "[\u4e00-\u9fa5]";
    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher(str);
    return m.find();
  }

  /**
   * 将k1=v1,k2=v2转为Map 范例："----------ss---\n\rselect * from ---2020\n table \n-------haha--- \nwhere
   * 1=1"
   *
   * @param keyValueString
   * @return
   */
  public static Map<String, String> convertKeyValueStringToMap(String keyValueString) {
    return convertKeyValueStringToMap(keyValueString, ",");
  }

  public static Map<String, String> convertKeyValueStringToMap(String keyValueString,
      String splitString) {
    Map<String, String> keyValues = new HashMap<>(0);
    if (StringUtil.hasText(keyValueString)) {
      for (String keyValue : keyValueString.split(splitString)) {
        if (StringUtil.hasText(keyValue) && keyValue.contains("=")) {
          keyValues.put(keyValue.substring(0, keyValue.indexOf("=")),
              keyValue.substring(keyValue.indexOf("=") + 1));
        }
      }
    }
    return keyValues;
  }

  public static List<String> splitToMultiLines(String string) {
    List<String> results = new ArrayList<>(0);
    StringBuilder buffer = new StringBuilder();
    char[] chars = string.trim().toCharArray();
    for (int i = 0; i < chars.length; i++) {
      if ('\n' == chars[i]) {
        results.add(buffer.toString());
        if (buffer.length() != 0) {
          buffer.delete(0, buffer.length());
        }
      } else {
        buffer.append(chars[i]);
      }
    }
    if (buffer.length() != 0) {
      results.add(buffer.toString());
    }
    return results;
  }

  /**
   * 获取父目录
   *
   * @param path linux 格式路径
   * @return 父目录
   */
  public static String getParentPath(String path) {
    if (path == null) {
      return null;
    }
    if (path.split(LINUX_SEPARATOR).length < 3) {
      return path;
    }
    return path.substring(0, path.lastIndexOf(LINUX_SEPARATOR));
  }
}
