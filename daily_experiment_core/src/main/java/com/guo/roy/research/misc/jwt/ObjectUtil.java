package com.guo.roy.research.misc.jwt;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;

/**
 * 对象工具
 *
 * @author zhangws
 */
public final class ObjectUtil {

  private static final String EMPTY = "";

  private static final String NULL = "null";

  /**
   * 检查是否为空
   * @param obj 被检查对象
   * @return 空 ：true
   */
  public static boolean isEmpty(Object obj) {
    if (obj == null) {
      return true;
    }
    if (obj instanceof String) {
      String s = (String) obj;
      if (EMPTY.equals(s.trim()) || NULL.equals(s)) {
        return true;
      }
    } else if (obj instanceof Map) {
      Map m = (Map) obj;
      if (m.size() == 0) {
        return true;
      }
    } else if (obj instanceof List) {
      List l = (List) obj;
      if (l.size() == 0) {
        return true;
      }
    } else if (obj instanceof String[]) {
      String[] arr = (String[]) obj;
      if (arr.length == 0) {
        return true;
      }
    } else {
      return false;
    }
    return false;
  }

  /**
   * 检查是否为空
   * @param obj 被检查对象
   * @return 空 ：true
   */
  public static boolean isNotEmpty(Object obj) {
    return !isEmpty(obj);
  }

  /**
   * 检查是存在不为空对象
   * @param obj 检查对象
   * @param objs 检查对象数组
   * @return 非空 ：true
   */
  public static boolean isAnyNotEmpty(Object obj, Object... objs) {
    if (isNotEmpty(obj)) {
      return true;
    }
    if (objs != null) {
      for (Object o : objs) {
        if (isNotEmpty(o)) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * 是否存在任意为空对象
   * @param obj 检查对象
   * @param objs 检查对象数据
   * @return 空 true
   */
  public static boolean isAnyEmpty(Object obj, Object... objs) {
    if (isEmpty(obj)) {
      return true;
    }
    if (objs != null) {
      for (Object o : objs) {
        if (isEmpty(o)) {
          return true;
        }
      }
    }

    return false;
  }

  public static boolean isAllEmpty(Object date, Object... dates) {
    return !isAnyNotEmpty(date, dates);
  }


  public static boolean isAllNotEmpty(Object date, Object... dates) {
    return !isAnyEmpty(date, dates);
  }

  /**
   * 异常的堆栈信息转为字符串
   *
   * @param e 异常
   *
   * @return 字符串
   */
  public static String exceptionStack(Exception e) {
    try (StringWriter sw = new StringWriter(); PrintWriter pw = new PrintWriter(sw)) {
      e.printStackTrace(pw);
      return sw.toString();
    } catch (Exception ex) {
      return e.getMessage();
    }
  }
}
