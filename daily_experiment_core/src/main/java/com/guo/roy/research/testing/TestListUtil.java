package com.guo.roy.research.testing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

/**
 * @author guojun
 * @date 2022/5/26 上午10:30
 */
public class TestListUtil {
  private static final org.slf4j.Logger logger = LoggerFactory.getLogger(
      TestMd5Sh1Sh256.class);

  public static class ListUtil {
    /**
     * List转Set
     * @param list
     * @param <T>
     * @return
     */
    public static <T> Set<T> convertToSet(List<T> list) {
      if (CollectionUtils.isEmpty(list)) {
        return Collections.EMPTY_SET;
      }
      return list.stream().collect(Collectors.toSet());
    }

    public static <T> List<T> convertToList(Set<T> set) {
      if (CollectionUtils.isEmpty(set)) {
        return Collections.EMPTY_LIST;
      }
      return set.stream().collect(Collectors.toList());
    }

    /*
     * @param targetList 需要分割的数组
     * @param splitSize 分割之后每个数组的最大值
     * @return List<List<E>>
     */
    public static <E> List<List<E>> splitList (List<E> targetList, Integer splitSize){
      if(targetList == null || targetList.isEmpty()){
        return null;
      }
      Integer size = targetList.size();
      List<List<E>> resultList = new ArrayList<>();
      if(size <= splitSize) {
        resultList.add(targetList);
      } else {
        for (int i = 0; i < size; i += splitSize) {
          //用于限制最后一部分size小于splitSize的list
          Integer limit = i+splitSize;
          if(limit > size){
            limit = size;
          }
          resultList.add(targetList.subList(i, limit));
        }
      }
      return resultList;
    }

    /**
     * 提供list转map方法，免得每次重复代码
     * @param list
     * @param keyFunc key的函数
     * @param <K>  key
     * @param <V>  value
     * @return
     */
    public static <K,V> Map<K,V> toMap(List<V> list, Function<V,K> keyFunc) {
      Map<K, V> resMap = list.stream().collect(
          HashMap::new,
          (map, item) -> map.put(keyFunc.apply(item), item),
          HashMap::putAll);
      return resMap;
    }

    /**
     * 提供list转map方法
     * @param list
     * @param keyFunc
     * @param valFunc
     * @param <K> key
     * @param <V>  value
     * @param <T>  item
     * @return
     */
    public static <K,V,T> Map<K,V> toMap(List<T> list, Function<T,K> keyFunc, Function<T,V> valFunc) {
      Map<K, V> resMap = list.stream().collect(
          HashMap::new,
          (map, item) -> map.put(keyFunc.apply(item), valFunc.apply(item)),
          HashMap::putAll);
      return resMap;
    }

  }

  static class Solution {
    public  void test1() {
      List<String> list = Arrays.asList("ab", "2");
      Map<String, String> map = ListUtil.toMap(list, String::toUpperCase);
      int k = 0;
    }

  }

  public static void main(String[] args) {
    new Solution().test1();
  }
}
