package com.roy.miscellaneous.yunli.util;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author : zhengyangyong
 */
public class CollectionUtil {
  public static boolean isNullOrEmpty(Collection<?> collection) {
    return collection == null || collection.isEmpty();
  }

  public static boolean isNullOrEmpty(Map<?, ?> map) {
    return map == null || map.isEmpty();
  }

  public static boolean isNullOrEmpty(byte[] collection) {
    return collection == null || collection.length == 0;
  }

  public static <T> boolean isNullOrEmpty(T[] collection) {
    return collection == null || collection.length == 0;
  }

  public static boolean isNotEmpty(Collection<?> collection) {
    return !isNullOrEmpty(collection);
  }

  public static boolean isNotEmpty(Map<?, ?> collection) {
    return !isNullOrEmpty(collection);
  }

  public static <T> boolean isNotEmpty(T[] collection) {
    return !isNullOrEmpty(collection);
  }

  public static boolean isNotEmpty(byte[] collection) {
    return !isNullOrEmpty(collection);
  }

  public static <K, V> Set<K> missing(Map<K, V> exists, Collection<K> necessaries) {
    return missing(exists.keySet(), necessaries);
  }

  public static <K> Set<K> missing(Collection<K> exists, Collection<K> necessaries) {
    Set<K> missing = new HashSet<>(necessaries);
    missing.removeAll(exists);
    return missing;
  }

  public static <T> Set<T> findDuplicate(Collection<T> collection) {
    Set<T> duplicate = new HashSet<>();
    Set<T> current = new HashSet<>();
    for (T item : collection) {
      if (current.contains(item)) {
        duplicate.add(item);
      } else {
        current.add(item);
      }
    }
    return duplicate;
  }
}
