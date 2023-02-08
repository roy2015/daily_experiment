package com.guo.roy.research.misc.yunli.compress;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: david
 * @Date: 2022/4/7 6:57 下午
 * @Description:
 **/
public class AutoCompressionProcessor extends AutomaticCompressionProcessor implements Serializable {

  private static final long serialVersionUID = 8795076246935170384L;

  private final transient Logger LOGGER = LoggerFactory.getLogger(AutoCompressionProcessor.class);

  public AutoCompressionProcessor(CompressionAlgorithm algorithm) {
    super(algorithm);
  }

  public AutoCompressionProcessor(CompressionAlgorithm algorithm, int compressThreshold) {
    super(algorithm, compressThreshold);
  }

  @Override
  public byte[] compress(byte[] input) {
    try {
      return super.compress(input);
    } catch (IOException e) {
      LOGGER.warn(e.getMessage(), e);
    }
    return null;
  }

  @Override
  public byte[] decompress(byte[] input) {
    try {
      return super.decompress(input);
    } catch (IOException e) {
      LOGGER.warn(e.getMessage(), e);
    }
    return null;
  }

  @Override
  public byte[] compress(byte[] input, int position) {
    try {
      return super.compress(input, position);
    } catch (IOException e) {
      LOGGER.warn(e.getMessage(), e);
    }
    return null;
  }

  @Override
  public byte[] decompress(byte[] input, int position) {
    try {
      return super.decompress(input, position);
    } catch (IOException e) {
      LOGGER.warn(e.getMessage(), e);
    }
    return null;
  }

  @Override
  public String compressPojoToBase64String(Object obj) {
    try {
      return super.compressPojoToBase64String(obj);
    } catch (IOException e) {
      LOGGER.warn(e.getMessage(), e);
    }
    return null;
  }

  @Override
  public byte[] compressPojoToBytes(Object obj) {
    try {
      return super.compressPojoToBytes(obj);
    } catch (IOException e) {
      LOGGER.warn(e.getMessage(), e);
    }
    return null;
  }

  @Override
  public <T> T decompressPojoFromBase64String(String data, Class<T> type) {
    try {
      return super.decompressPojoFromBase64String(data, type);
    } catch (IOException e) {
      LOGGER.warn(e.getMessage(), e);
    }
    return null;
  }

  @Override
  public <T> T decompressPojoFromBytes(byte[] data, Class<T> type) {
    try {
      return super.decompressPojoFromBytes(data, type);
    } catch (IOException e) {
      LOGGER.warn(e.getMessage(), e);
    }
    return null;
  }

  @Override
  public <T> List<T> decompressPojoListFromBytes(byte[] data, Class<T> type) {
    try {
      return super.decompressPojoListFromBytes(data, type);
    } catch (IOException e) {
      LOGGER.warn(e.getMessage(), e);
    }
    return null;
  }

  /**
   * 包装字节数组中含有算法标识
   * @param data
   * @return
   * @throws IOException
   */
  public byte[] warpAlgorithmBytes(byte[] data) throws IOException {
    return CompressionAlgorithm.warp(this.getAlgorithm(), data);
  }

}
