package com.guo.roy.research.misc.yunli.compress;

import java.util.Arrays;

/**
 * @author : zhengyangyong
 */
class NoneCompressionProcessor extends AbstractCompressionProcessor {
  @Override
  public CompressionAlgorithm getAlgorithm() {
    return CompressionAlgorithm.None;
  }

  @Override
  public byte[] compress(byte[] input, int position) {
    if (input == null || input.length == 0 || position == 0) {
      return input;
    }
    return Arrays.copyOfRange(input, position, input.length);
  }

  @Override
  public byte[] decompress(byte[] input, int position) {
    if (input == null || input.length == 0 || position == 0) {
      return input;
    }
    return Arrays.copyOfRange(input, position, input.length);
  }
}
