package com.guo.roy.research.misc.jwt;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.time.DateUtils;

/**
 * @author : zhengyangyong
 */
public class DateUtil {
  private final static String TIME_PART_MI = "MI";

  private final static String TIME_PART_H = "H";

  private final static String TIME_PART_D = "D";

  private final static String TIME_PART_W = "W";

  private final static String TIME_PART_M = "M";

  private final static String TIME_PART_Y = "Y";

  public static final String COMPACT_SHORT = "yyyyMMdd";

  public static final String SHORT = "yyyy-MM-dd";

  public static final String COMPACT_STANDARD = "yyyyMMddHHmmss";

  public static final String STANDARD = "yyyy-MM-dd HH:mm:ss";

  public static final String M_S = "HH:mm";

  public static final String STANDARD_HOUR_PRECISION = "yyyy-MM-dd HH:00:00";

  public static final String COMPACT_FULL = "yyyyMMddHHmmssSSS";

  public static final String FULL = "yyyy-MM-dd HH:mm:ss.SSS";

  public enum TimeType {
    /** 分 */
    MIN,
    /** 小时 */
    HOUR,
    /** 日 */
    DAY,
    /** 周 */
    WEEK,
    /** 月 */
    MONTH,
    /** 年 */
    YEAR
  }

  /**
   * 获取零点时间
   *
   * @param date
   * @return
   */
  public static Date getStartOfDate(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);
    Date start = calendar.getTime();
    return start;
  }


  /**
   * 获取上某周的周几的开始时间
   * @param date  当前周的日期
   * @param lastWeek  上几周  1 -》 上一周， 2-》 上两周
   * @param weekNum  当前周的周几  1 - 》周日，2 -》 周一 ，3 -》周二
   * @return
   */
  public static Date getLastWeekOneDayStartDate(Date date, int lastWeek, int weekNum) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.add(Calendar.DAY_OF_MONTH, -7 * lastWeek);
    calendar.setFirstDayOfWeek(Calendar.MONDAY);
    calendar.set(Calendar.DAY_OF_WEEK, weekNum);
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);
    return calendar.getTime();
  }


  /**
   * 获取某一天的开始时间
   * @param date  当前的计算日期
   * @param i   -1 ，表示昨天 ，1表示明天  以此类推
   * @return 返回一天的开始 时间 xxxx,xx,xx 00:00:00
   */
  public static Date getOneDayStartDate(Date date, int i) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.add(Calendar.DAY_OF_MONTH, i);
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);
    return calendar.getTime();
  }

  /**
   * 获取传入时间的整点时间
   * @param date  当前的计算日期
   * @param i   -1 ，表示前一小时 ，1表示后一小时  以此类推
   * @return 返回整点时间 示例： 1991-09-09 11:00:00
   */
  public static Date getOneDayOnTime(Date date, int i) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.add(Calendar.HOUR_OF_DAY, i);
    calendar.set(Calendar.MINUTE, 0);
    return calendar.getTime();
  }

  /**
   * 对传入时间 的小时 做加减计算
   * @param date  当前的计算日期
   * @param i   -1 ，表示前一小时 ，1表示后一小时  以此类推
   * @return 返回整点时间 示例： 1991-09-09 11:00:00
   */
  public static Date geTimeByHour(Date date, int i) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.add(Calendar.HOUR_OF_DAY, i);
    return calendar.getTime();
  }


  /**
   * 获取某一天的结束时间
   * @param date  当前的计算日期
   * @param i   -1 ，表示昨天 ，1表示明天  以此类推
   * @return 返回一天的开始 时间 xxxx,xx,xx 23:59:59
   */
  public static Date getOneDayEndDate(Date date, int i) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.add(Calendar.DAY_OF_MONTH, i);
    calendar.set(Calendar.HOUR_OF_DAY, 23);
    calendar.set(Calendar.MINUTE, 59);
    calendar.set(Calendar.SECOND, 59);
    calendar.set(Calendar.MILLISECOND, 0);
    return calendar.getTime();
  }

  public static Date fromStandardString(String dateTime) throws ParseException {
    return StringUtil.hasText(dateTime) ? new SimpleDateFormat(STANDARD).parse(dateTime) : null;
  }

  public static Date fromAnyStandardString(String dateTime) throws ParseException {
    String[] possibleDateFormats =
        {
            "yyyyMMddHHmmssSSS",
            "yyyyMMddHHmmss",
            "yyyyMMddHHmm",
            "yyyyMMddHH",
            "yyyyMMdd",
            "yyyy-MM-dd HH:mm:ss.SSS",
            "yyyy-MM-dd HH:mm:ss",
            "yyyy-MM-dd HH:mm",
            "yyyy-MM-dd HH",
            "yyyy-MM-dd",
            "yyyy/MM/dd HH:mm:ss.SSS",
            "yyyy/MM/dd HH:mm:ss",
            "yyyy/MM/dd HH:mm",
            "yyyy/MM/dd HH",
            "yyyy/MM/dd",
            "yyyy年MM月dd日HH时mm分ss秒",
            "yyyy年MM月dd日HH时mm分",
            "yyyy年MM月dd日HH时",
            "yyyy年MM月dd日",
        };
    return StringUtil.hasText(dateTime) ? DateUtils.parseDate(dateTime, possibleDateFormats) : null;
  }

  public static Date parseDate(String dateTime, String[] possibleDateFormats) throws ParseException {
    return StringUtil.hasText(dateTime) ? DateUtils.parseDate(dateTime, possibleDateFormats) : null;
  }

  public static Date fromString(String dateTime, String formatted) throws ParseException {
    return new SimpleDateFormat(formatted).parse(dateTime);
  }

  public static Date fromStandardHourPrecisionString(String dateTime) throws ParseException {
    return StringUtil.hasText(dateTime) ? new SimpleDateFormat(STANDARD_HOUR_PRECISION).parse(dateTime) : null;
  }

  public static Date fromUrlSimpleString(String dateTime) throws ParseException, UnsupportedEncodingException {
    return StringUtil.hasText(dateTime) ? new SimpleDateFormat(STANDARD)
        .parse(URLDecoder.decode(dateTime, "UTF-8")) : null;
  }

  public static String toStandardString(Date date) {
    return new SimpleDateFormat(STANDARD).format(date);
  }

  public static String toStandardHourPrecisionString(Date date) {
    return new SimpleDateFormat(STANDARD_HOUR_PRECISION).format(date);
  }

  public static String toLongSimpleString(Date date) {
    return new SimpleDateFormat(COMPACT_FULL).format(date);
  }

  public static Date fromLongSimpleString(String dateTime) throws ParseException {
    return StringUtil.hasText(dateTime) ? new SimpleDateFormat(COMPACT_FULL).parse(dateTime) : null;
  }

  public static String toString(Date date, String format) {
    if (date == null || StringUtil.isEmpty(format)) {
      throw new IllegalArgumentException("format is empty");
    }
    return new SimpleDateFormat(format).format(date);
  }

  public static String instantiateParameterizedDateString(String parameterDateString, Date date) {
    if (StringUtil.isEmpty(parameterDateString)) {
      return parameterDateString;
    }
    if (StringUtil.isContainsChinese(parameterDateString)) {
      throw new RuntimeException("参数不支持中文");
    }
    return getValue(parameterDateString, date);
  }

  private static String getValue(String parameterDateString, Date date) {
    if (StringUtil.isEmpty(parameterDateString)) {
      return parameterDateString;
    }
    boolean isSystemTime = false;
    int pos = parameterDateString.indexOf("}");
    if (pos <= 0) {
      pos = parameterDateString.indexOf("]");
      isSystemTime = true;
    }
    if (pos > 0) {
      String format = parameterDateString.substring(0, pos).replaceAll("\\{|\\[", StringUtil.EMPTY);
      Date realDate = isSystemTime ? date : DateUtils.addDays(date, -1);
      int length = parameterDateString.length();
      if (length > pos + 1) {
        // 判断是否进行了加减运算
        String expression = parameterDateString.substring(pos + 1);
        if (expression.endsWith(TIME_PART_MI)) {
          int value = Integer.parseInt(expression.replace(TIME_PART_MI, StringUtil.EMPTY));
          realDate = DateUtils.addMinutes(realDate, value);
        } else if (expression.endsWith(TIME_PART_H)) {
          int value = Integer.parseInt(expression.replace(TIME_PART_H, StringUtil.EMPTY));
          realDate = DateUtils.addHours(realDate, value);
        } else if (expression.endsWith(TIME_PART_D)) {
          int value = Integer.parseInt(expression.replace(TIME_PART_D, StringUtil.EMPTY));
          realDate = DateUtils.addDays(realDate, value);
        } else if (expression.endsWith(TIME_PART_W)) {
          int value = Integer.parseInt(expression.replace(TIME_PART_W, StringUtil.EMPTY));
          realDate = DateUtils.addWeeks(realDate, value);
        } else if (expression.endsWith(TIME_PART_M)) {
          int value = Integer.parseInt(expression.replace(TIME_PART_M, StringUtil.EMPTY));
          realDate = DateUtils.addMonths(realDate, value);
        } else if (expression.endsWith(TIME_PART_Y)) {
          int value = Integer.parseInt(expression.replace(TIME_PART_Y, StringUtil.EMPTY));
          realDate = DateUtils.addYears(realDate, value);
        } else {
          throw new IllegalArgumentException("unsupported time type:" + expression);
        }
      }
      return new SimpleDateFormat(format).format(realDate);
    } else {
      return parameterDateString;
    }
  }

  public static Map<String, String> instantiateParameterizedDateStrings(Map<String, String> parameterDateStrings,
      Date date) {
    if (CollectionUtil.isNullOrEmpty(parameterDateStrings)) {
      return parameterDateStrings;
    }
    Map<String, String> parameterizedDateStrings = new HashMap<>(parameterDateStrings.size());
    parameterDateStrings.forEach((key, value) -> {
      parameterizedDateStrings.put(key, instantiateParameterizedDateString(value, date));
    });
    return parameterizedDateStrings;
  }


  public static Map<String, String> instantiateParameter(Map<String, String> parameterDateStrings,
      Date date) {
    if (CollectionUtil.isNullOrEmpty(parameterDateStrings)) {
      return parameterDateStrings;
    }
    Map<String, String> parameterizedDateStrings = new HashMap<>(parameterDateStrings.size());
    parameterDateStrings.forEach((key, value) -> {

      parameterizedDateStrings.put(key, getValue(value, date));
    });
    return parameterizedDateStrings;
  }

  /**
   * 用于质检，将分区表达式实例化
   * @param parameterDateStrings
   * @param date
   * @return
   */
  public static Map<String, String> instantiatePartitionsParameterizedDateStrings(
      Map<String, String> parameterDateStrings,
      Date date) {
    if (CollectionUtil.isNullOrEmpty(parameterDateStrings)) {
      return parameterDateStrings;
    }
    Map<String, String> parameterizedDateStrings = new HashMap<>(parameterDateStrings.size());
    parameterDateStrings.forEach((key, value) -> {
      if (StringUtil.isContainsChinese(value)) {
        parameterizedDateStrings.put(key, value);
      } else {
        if ("partitions".equalsIgnoreCase(key)) {
          parameterizedDateStrings.put(key, instantiateParameterizedDateString(value, date));
        } else {
          parameterizedDateStrings.put(key, value);
        }
      }
    });
    return parameterizedDateStrings;
  }

  public static Map<String, String> instantiateParameterizedDateStringsIgnoreChinese(
      Map<String, String> parameterDateStrings,
      Date date) {
    if (CollectionUtil.isNullOrEmpty(parameterDateStrings)) {
      return parameterDateStrings;
    }
    Map<String, String> parameterizedDateStrings = new HashMap<>(parameterDateStrings.size());
    parameterDateStrings.forEach((key, value) -> {
      if (StringUtil.isContainsChinese(value)) {
        parameterizedDateStrings.put(key, value);
      } else {
        if (!"condition".equalsIgnoreCase(key) && !"format".equalsIgnoreCase(key) && !"keyword".equalsIgnoreCase(key)) {
          // 质检中的condition不接受此参数限制
          parameterizedDateStrings.put(key, instantiateParameterizedDateString(value, date));
        } else {
          parameterizedDateStrings.put(key, value);
        }
      }
    });
    return parameterizedDateStrings;
  }


  public static String instantiatePartitionDateString(String parameterDateString, Date planTime) {
    if (StringUtil.isEmpty(parameterDateString)) {
      return parameterDateString;
    }
    if (StringUtil.isContainsChinese(parameterDateString)) {
      throw new RuntimeException("参数不支持中文");
    }
    String value = parameterDateString;
    boolean isSystem = false;
    int pos = value.indexOf("}");
    if (pos <= 0) {
      pos = value.indexOf("]");
      isSystem = true;
    }
    if (pos > 0) {
      // 对日期进行处理
      String format = value.substring(0, pos).replaceAll("\\{|\\[", StringUtil.EMPTY);
      int length = value.length();
      int v = 0;
      TimeType timeType = TimeType.DAY;
      if (length > pos + 1) {
        // 判断是否进行了加减运算
        String expression = value.substring(pos + 1);
        if (expression.endsWith(TIME_PART_MI)) {
          v = Integer.parseInt(expression.replace(TIME_PART_MI, StringUtil.EMPTY));
          timeType = TimeType.MIN;
        } else if (expression.endsWith(TIME_PART_H)) {
          v = Integer.parseInt(expression.replace(TIME_PART_H, StringUtil.EMPTY));
          timeType = TimeType.HOUR;
        } else if (expression.endsWith(TIME_PART_D)) {
          v = Integer.parseInt(expression.replace(TIME_PART_D, StringUtil.EMPTY));
          timeType = TimeType.DAY;
        } else if (expression.endsWith(TIME_PART_W)) {
          v = Integer.parseInt(expression.replace(TIME_PART_W, StringUtil.EMPTY));
          timeType = TimeType.WEEK;
        } else if (expression.endsWith(TIME_PART_M)) {
          v = Integer.parseInt(expression.replace(TIME_PART_M, StringUtil.EMPTY));
          timeType = TimeType.MONTH;
        } else if (expression.endsWith(TIME_PART_Y)) {
          v = Integer.parseInt(expression.replace(TIME_PART_Y, StringUtil.EMPTY));
          timeType = TimeType.YEAR;
        } else {
          throw new RuntimeException(
              String.format("%s[%s]不支持", "参数运算", expression));
        }
      }
      Date date = isSystem ? planTime : DateUtil.plus(planTime, TimeType.DAY, -1);
      try {
        String lastValue = DateUtil.toString(DateUtil.plus(date, timeType, v), format);
        if (ValidateUtil.validatePartitionValue(lastValue)) {
          return lastValue;
        } else {
          throw new RuntimeException("分区表达式的内容只支持英文、数字、下横、中横线");
        }
      } catch (Exception e) {
        e.printStackTrace();
        throw e;
      }
    } else {
      if (ValidateUtil.validatePartitionValue(parameterDateString)) {
        return parameterDateString;
      } else {
        throw new RuntimeException("分区表达式的内容只支持英文、数字、下横、中横线");
      }
    }

    // 2021-04-27 更改为豪华威力加强版，支持-1D之类的复杂场景
    // 正则匹配
    /*
    String regexPartitionSys = "(\\{[^}]+\\})";
    Pattern patternSys = Pattern.compile(regexPartitionSys);
    Matcher matcherSys = patternSys.matcher(parameterDateString);
    while (matcherSys.find()) {
      String dateSysExpression = matcherSys.group(1);
      String valueConverted = DateUtil.toString(date, dateSysExpression.substring(1, dateSysExpression.length() - 1));
      parameterDateString = parameterDateString.replace(dateSysExpression, valueConverted);
    }
    String regexPartitionBusi = "(\\[[^\\]]+\\])";
    Pattern patternBusi = Pattern.compile(regexPartitionBusi);
    Matcher matcherBusi = patternBusi.matcher(parameterDateString);
    while (matcherBusi.find()) {
      Date realDate = DateUtils.addDays(date, -1);
      String dateSysExpression = matcherBusi.group(1);
      String valueConverted = DateUtil
          .toString(realDate, dateSysExpression.substring(1, dateSysExpression.length() - 1));
      parameterDateString = parameterDateString.replace(dateSysExpression, valueConverted);
    }
     */
  }

  /**
   * 日期增加指定常量
   * <p>
   * 例如，在周上加1；在天上加-1
   *
   * @param date 原日期
   * @param timeType 加值的位置
   * @param value 被加值
   */
  public static Date plus(Date date, TimeType timeType, int value) {
    if (ObjectUtil.isAnyEmpty(date, timeType)) {
      throw new IllegalArgumentException("parameter must not be empty.");
    }
    switch (timeType) {
      case MIN:
        return toDate(toLocalDateTime(date).plusMinutes(value));
      case HOUR:
        return toDate(toLocalDateTime(date).plusHours(value));
      case DAY:
        return toDate(toLocalDateTime(date).plusDays(value));
      case WEEK:
        return toDate(toLocalDateTime(date).plusWeeks(value));
      case MONTH:
        return toDate(toLocalDateTime(date).plusMonths(value));
      case YEAR:
        return toDate(toLocalDateTime(date).plusYears(value));
      default:
        throw new IllegalArgumentException("TimeType not support.");
    }
  }

  private static Date toDate(LocalDateTime date) {
    return Date.from(date.atZone(ZoneId.systemDefault()).toInstant());
  }

  private static LocalDateTime toLocalDateTime(Date date) {
    return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
  }

  /**
   * 针对分区表达式的处理
   * @param parameterDateStrings
   * @param date
   * @return
   */
  public static Map<String, String> instantiatePartitionDateStrings(Map<String, String> parameterDateStrings,
      Date date) {
    if (CollectionUtil.isNullOrEmpty(parameterDateStrings)) {
      return parameterDateStrings;
    }
    Map<String, String> parameterizedDateStrings = new HashMap<>(parameterDateStrings.size());
    parameterDateStrings.forEach((key, value) -> {
      parameterizedDateStrings.put(key, instantiatePartitionDateString(value, date));
    });
    return parameterizedDateStrings;
  }

  /**
   * 计算两个日期之间相差的天数
   * @param smdate 较小的时间
   * @param bdate  较大的时间
   * @return 相差天数
   * @throws ParseException
   */
  public static int daysBetween(Date smdate, Date bdate) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat(SHORT);
    smdate = sdf.parse(sdf.format(smdate));
    bdate = sdf.parse(sdf.format(bdate));
    Calendar cal = Calendar.getInstance();
    cal.setTime(smdate);
    long time1 = cal.getTimeInMillis();
    cal.setTime(bdate);
    long time2 = cal.getTimeInMillis();
    long betweenDays = (time2 - time1) / (1000 * 3600 * 24);
    return Integer.parseInt(String.valueOf(betweenDays));
  }

  /**
   * 计算两个日期之间相差的天数
   * @param smdate 较小的时间
   * @param bdate 较大的时间
   * @return 相差天数
   * @throws ParseException
   */
  public static int daysBetween(String smdate, String bdate) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    return daysBetween(sdf.parse(smdate), sdf.parse(bdate));
  }
}
