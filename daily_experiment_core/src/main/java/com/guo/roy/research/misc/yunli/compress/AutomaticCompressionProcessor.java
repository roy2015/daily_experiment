package com.guo.roy.research.misc.yunli.compress;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : zhengyangyong
 */
public class AutomaticCompressionProcessor extends AbstractCompressionProcessor {
  private static final Map<CompressionAlgorithm, CompressionProcessor> PROCESSORS = new ConcurrentHashMap<>();

  private final CompressionAlgorithm algorithm;

  private final int compressThreshold;

  @Override
  public CompressionAlgorithm getAlgorithm() {
    return algorithm;
  }

  public int getCompressThreshold() {
    return compressThreshold;
  }

  public AutomaticCompressionProcessor() {
    this(CompressionAlgorithm.Zstd);
  }

  public AutomaticCompressionProcessor(CompressionAlgorithm algorithm) {
    this(algorithm, 64);
  }

  public AutomaticCompressionProcessor(CompressionAlgorithm algorithm, int compressThreshold) {
    this.algorithm = algorithm;
    this.compressThreshold = compressThreshold;
  }

  @Override
  public byte[] compress(byte[] input) throws IOException {
    if (input == null || input.length == 0) {
      return input;
    }
    CompressionAlgorithm finalAlgorithm = input.length <= compressThreshold ? CompressionAlgorithm.None : algorithm;
    byte[] compressed = getCompressionProcessor(finalAlgorithm).compress(input);
    if (compressed.length >= input.length) {
      finalAlgorithm = CompressionAlgorithm.None;
      compressed = getCompressionProcessor(finalAlgorithm).compress(input);
    }
    return CompressionAlgorithm.warp(finalAlgorithm, compressed);
  }

  @Override
  public byte[] decompress(byte[] input) throws IOException {
    if (input == null || input.length == 0) {
      return input;
    }
    Optional<CompressionAlgorithm> algorithmOptional = CompressionAlgorithm.valueOf(input[0]);
    if (!algorithmOptional.isPresent()) {
      throw new IOException("invalid compressed bytes");
    }
    CompressionAlgorithm finalAlgorithm = algorithmOptional.get();
    return getCompressionProcessor(finalAlgorithm).decompress(input, 1);
  }

  @Override
  public byte[] compress(byte[] input, int position) throws IOException {
    throw new IOException("unsupported");
  }

  @Override
  public byte[] decompress(byte[] input, int position) throws IOException {
    throw new IOException("unsupported");
  }

  private static CompressionProcessor getCompressionProcessor(CompressionAlgorithm algorithm) {
    return PROCESSORS.computeIfAbsent(algorithm, key -> {
      if (key == CompressionAlgorithm.Zstd) {
        return new ZstdCompressionProcessor();
      } else if (key == CompressionAlgorithm.Gzip) {
        return new GzipCompressionProcessor();
      } else {
        return new NoneCompressionProcessor();
      }
    });
  }
}
