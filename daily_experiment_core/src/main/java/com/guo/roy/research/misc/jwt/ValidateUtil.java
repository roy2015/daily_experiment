package com.guo.roy.research.misc.jwt;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wei
 */
public class ValidateUtil {
  public static List<String> KEYWORDS = Arrays
      .asList("all", "alter", "and", "array", "as", "authorization", "between", "bigint", "binary", "boolean", "both",
          "by", "case", "cast", "char", "column", "conf", "create", "cross", "cube", "current", "current_date",
          "current_timestamp", "cursor", "database", "date", "decimal", "delete", "describe", "distinct", "double",
          "drop", "else", "end", "exchange", "exists", "extended", "external", "false", "fetch", "float", "following",
          "for", "from", "full", "function", "grant", "group", "grouping", "having", "if", "import", "in", "inner",
          "insert", "int", "intersect", "interval", "into", "is", "join", "lateral", "left", "less", "like", "local",
          "macro", "map", "more", "none", "not", "null", "of", "on", "or", "order", "out", "outer", "over",
          "partialscan", "partition", "percent", "preceding", "preserve", "procedure", "range", "reads", "reduce",
          "revoke", "right", "rollup", "row", "rows", "select", "set", "smallint", "table", "tablesample", "then",
          "timestamp", "to", "transform", "trigger", "true", "truncate", "unbounded", "union", "uniquejoin", "update",
          "user", "using", "utc_tmestamp", "values", "varchar", "when", "where", "window", "with", "commit", "only",
          "regexp", "rlike", "rollback", "start", "cache", "constraint", "foreign", "primary", "references",
          "dayofweek", "extract", "floor", "integer", "precision", "views", "time", "numeric", "sync", "add", "admin",
          "after", "analyze", "archive", "asc", "before", "bucket", "buckets", "cascade", "change", "cluster",
          "clustered", "clusterstatus", "collection", "columns", "comment", "compact", "compactions", "compute",
          "concatenate", "continue", "data", "databases", "datetime", "day", "dbproperties", "deferred", "defined",
          "delimited", "dependency", "desc", "directories", "directory", "disable", "distribute", "elem_type", "enable",
          "escaped", "exclusive", "explain", "export", "fields", "file", "fileformat", "first", "format", "formatted",
          "functions", "hold_ddltime", "hour", "idxproperties", "ignore", "index", "indexes", "inpath", "inputdriver",
          "inputformat", "items", "jar", "keys", "key_type", "limit", "lines", "load", "location", "lock", "locks",
          "logical", "long", "mapjoin", "materialized", "metadata", "minus", "minute", "month", "msck", "noscan",
          "no_drop", "offline", "option", "outputdriver", "outputformat", "overwrite", "owner", "partitioned",
          "partitions", "plus", "pretty", "principals", "protection", "purge", "read", "readonly", "rebuild",
          "recordreader", "recordwriter", "regexp", "reload", "rename", "repair", "replace", "replication", "restrict",
          "rewrite", "rlike", "role", "roles", "schema", "schemas", "second", "semi", "serde", "serdeproperties",
          "server", "sets", "shared", "show", "show_database", "skewed", "sort", "sorted", "ssl", "statistics",
          "stored", "streamtable", "string", "struct", "tables", "tblproperties", "temporary", "terminated", "tinyint",
          "touch", "transactions", "unarchive", "undo", "uniontype", "unlock", "unset", "unsigned", "uri", "use", "utc",
          "utctimestamp", "value_type", "view", "while", "year", "autocommit", "isolation", "level", "offset",
          "snapshot", "transaction", "work", "write", "abort", "key", "last", "norely", "novalidate", "nulls", "rely",
          "validate", "detail", "dow", "expression", "operator", "quarter", "summary", "vectorization", "week", "years",
          "months", "weeks", "days", "hours", "minutes", "seconds", "timestamptz", "zone");

  public static boolean validateTableName(String name) {
    String pattern = "(^[a-z][a-z0-9_]*$)";
    Pattern r = Pattern.compile(pattern);
    Matcher m = r.matcher(name);
    // 表名不能为null
    return m.matches();
  }

  public static boolean validateTopicCode(String name) {
    String pattern = "([a-zA-Z0-9_-]*$)";
    Pattern r = Pattern.compile(pattern);
    Matcher m = r.matcher(name);
    return m.matches();
  }

  public static boolean validateNamespaceName(String name) {
    String pattern = "(^[a-z][a-z0-9_]*$)";
    Pattern r = Pattern.compile(pattern);
    Matcher m = r.matcher(name);
    return m.matches();
  }

  /**
   * 校验用户名（英文、数字、下划线、英文句号、艾特符随意组合）
   * @param name 用户名
   * @return 是否合法
   */
  public static boolean validateUserName(String name) {
    String pattern = "(^[a-zA-Z0-9_@.-]*$)";
    Pattern r = Pattern.compile(pattern);
    Matcher m = r.matcher(name);
    return m.matches();
  }

  public static boolean validatePassword(String password) {
    String pattern = "(^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[\\W])[\\da-zA-Z\\W]{8,}$)";
    Pattern r = Pattern.compile(pattern);
    Matcher m = r.matcher(password);
    return m.matches();
  }

  public static boolean validateComment(String name) {
    if (StringUtil.isEmpty(name)) {
      return true;
    }
    String pattern = "(')";
    Pattern r = Pattern.compile(pattern);
    Matcher m = r.matcher(name);
    return !m.matches();
  }

  public static boolean validatePartitionValue(String value) {
    if (StringUtil.isEmpty(value)) {
      return false;
    }
    String pattern = "(^[A-Za-z0-9_-]*$)";
    Pattern r = Pattern.compile(pattern);
    Matcher m = r.matcher(value);
    return m.matches();
  }

  /**
   * 文件夹名合法性校验
   * <p>
   * <pre>
   *   只能输入中文、英文、数字和_（下划线），而且不能超过64个字符
   * </pre>
   * </p>
   *
   * @param folderName 文件名
   *
   * @return true：通过；false：不通过
   */
  public static boolean validateFolderName(String folderName) {
    if (folderName == null || folderName.length() > 64) {
      return false;
    } else {
      return folderName.matches("^[A-z0-9\\u4e00-\\u9fa5]*$");
    }
  }

  /**
   * 文件名校验
   * <p>
   * <pre>
   * 1.首尾不能有空字符(空格、制表符、换页符等空白字符的其中任意一个),文件名尾不能为.号
   * 2.文件名和扩展名不能同时为空
   * 3.文件名中不能包含\/:*?”<>|中的任意字符
   * 4.文件名(包括扩展名)的长度不得大于255个字符
   *
   * 注：控制字符其实也算不合法，但这里并没有进行判断处理
   * </pre>
   * </p>
   *
   * @param fileName 文件名
   *
   * @return true：通过；false：不通过
   */
  public static boolean validateFileName(String fileName) {
    if (fileName == null || fileName.length() > 255) {
      return false;
    } else {
      return fileName
          .matches("[^\\s\\\\/:\\*\\?\\\"<>\\|](\\x20|[^\\s\\\\/:\\*\\?\\\"<>\\|])*[^\\s\\\\/:\\*\\?\\\"<>\\|\\.]$");
    }
  }


  public static boolean validateParameterName(String name) {
    String pattern = "(^[a-zA-Z][a-zA-Z0-9_]*$)";
    Pattern r = Pattern.compile(pattern);
    Matcher m = r.matcher(name);
    return m.matches();
  }


  /**
   * 判断两个List是否相同 使用时，务必保证每个对象中实现了equals()方法。 如果是自己写的类，比如，Dog，Cat这些的，请重写Object中的equals方法！
   *
   * @param aList 左右顺序无所谓
   * @param bList 左右顺序无所谓
   *
   * @return 尽可能避免相同的情况
   */
  public static boolean equals(List aList, List bList) {

    if (aList == bList) {
      return true;
    }
    if (aList == null || bList == null) {
      return false;
    }

    if (aList.size() != bList.size()) {
      return false;
    }

    int n = aList.size();
    for (int i = 0; i < n; i++) {
      Object a = aList.get(i);
      Object b = bList.get(i);
      if (a instanceof List) {
        return equals((List) a, (List) b);
      }
      if (!a.equals(b)) {
        return false;
      }
    }

    return true;
  }
}
