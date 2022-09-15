package com.roy.miscellaneous.yunli.compress;

import java.util.Arrays;

import com.github.luben.zstd.Zstd;

/**
 * @author : zhengyangyong
 */
class ZstdCompressionProcessor extends AbstractCompressionProcessor {
  @Override
  public CompressionAlgorithm getAlgorithm() {
    return CompressionAlgorithm.Zstd;
  }

  @Override
  public byte[] compress(byte[] input, int position) {
    if (input == null || input.length == 0) {
      return input;
    }
    byte[] finalInput = position == 0 ? input : Arrays.copyOfRange(input, position, input.length);
    return Zstd.compress(finalInput);
  }

  @Override
  public byte[] decompress(byte[] input, int position) {
    if (input == null || input.length == 0) {
      return input;
    }
    byte[] finalInput = position == 0 ? input : Arrays.copyOfRange(input, position, input.length);
    long length = Zstd.decompressedSize(finalInput);
    return Zstd.decompress(finalInput, (int) length);
  }
}
