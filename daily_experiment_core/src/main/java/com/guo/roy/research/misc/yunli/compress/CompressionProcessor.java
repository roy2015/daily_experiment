package com.guo.roy.research.misc.yunli.compress;

import java.io.IOException;
import java.util.List;

/**
 * @author : zhengyangyong
 */
public interface CompressionProcessor {
  CompressionAlgorithm getAlgorithm();

  byte[] compress(byte[] input) throws IOException;

  byte[] compress(byte[] input, int position) throws IOException;

  String compressPojoToBase64String(Object obj) throws IOException;

  byte[] compressPojoToBytes(Object obj) throws IOException;

  byte[] decompress(byte[] input) throws IOException;

  byte[] decompress(byte[] input, int position) throws IOException;

  <T> T decompressPojoFromBase64String(String data, Class<T> type) throws IOException;

  <T> T decompressPojoFromBytes(byte[] data, Class<T> type) throws IOException;

  <T> List<T> decompressPojoListFromBytes(byte[] data, Class<T> type) throws IOException;
}
