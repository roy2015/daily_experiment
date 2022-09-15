package com.roy.miscellaneous.yunli.compress;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

/**
 * @author : zhengyangyong
 */
public enum CompressionAlgorithm {
  /**未压缩*/
  None(0),
  /**Zstd*/
  Zstd(1),
  /**Gzip*/
  Gzip(2);

  private final int value;

  CompressionAlgorithm(int value) {
    this.value = value;
  }

  public static Optional<CompressionAlgorithm> valueOf(int value) {
    return Arrays.stream(values())
        .filter(algorithm -> algorithm.value == value)
        .findFirst();
  }

  public static byte[] warp(CompressionAlgorithm algorithm, byte[] bytes) throws IOException {
    if (bytes == null || bytes.length == 0) {
      return bytes;
    }
    try (ByteArrayOutputStream stream = new ByteArrayOutputStream(1 + bytes.length)) {
      stream.write(new byte[] {(byte) algorithm.value});
      stream.write(bytes);
      stream.flush();
      return stream.toByteArray();
    }
  }
}
