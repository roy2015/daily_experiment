package com.roy.research.yunli.compress;

/**
 * @Author: david
 * @Date: 2022/4/7 6:55 下午
 * @Description:
 **/
public class CompressionProcessorFactory {

  public static AutoCompressionProcessor get() {
    return new AutoCompressionProcessor(CompressionAlgorithm.Zstd);
  }

  public static AutoCompressionProcessor get(CompressionAlgorithm type) {
    return new AutoCompressionProcessor(type);
  }
}
