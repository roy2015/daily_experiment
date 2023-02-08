package com.guo.roy.research.misc.yunli.compress;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * @author : zhengyangyong
 */
class GzipCompressionProcessor extends AbstractCompressionProcessor {
  @Override
  public CompressionAlgorithm getAlgorithm() {
    return CompressionAlgorithm.Gzip;
  }

  @Override
  public byte[] compress(byte[] input, int position) throws IOException {
    if (input == null || input.length == 0) {
      return input;
    }
    try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        GZIPOutputStream gzipOutputStream = new GZIPOutputStream(outputStream)) {
      gzipOutputStream.write(input, position, input.length - position);
      gzipOutputStream.flush();
      gzipOutputStream.finish();
      return outputStream.toByteArray();
    }
  }

  @Override
  public byte[] decompress(byte[] input, int position) throws IOException {
    if (input == null || input.length == 0) {
      return input;
    }
    GZIPInputStream gzipInputStream = null;
    try (ByteArrayInputStream inputStream = new ByteArrayInputStream(input)) {
      byte[] buffer = new byte[4096];
      if (position > 0) {
        inputStream.skip(position);
      }
      gzipInputStream = new GZIPInputStream(inputStream);
      ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
      int count = gzipInputStream.read(buffer);
      while (count > 0) {
        outputStream.write(buffer, 0, count);
        count = gzipInputStream.read(buffer);
      }
      outputStream.flush();
      return outputStream.toByteArray();
    } finally {
      if (gzipInputStream != null) {
        gzipInputStream.close();
      }
    }
  }
}
