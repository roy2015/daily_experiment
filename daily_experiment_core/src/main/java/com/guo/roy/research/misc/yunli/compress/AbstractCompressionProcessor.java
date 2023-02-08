package com.guo.roy.research.misc.yunli.compress;

import com.guo.roy.research.misc.yunli.util.CollectionUtil;
import com.guo.roy.research.misc.yunli.util.JsonUtil;
import com.guo.roy.research.misc.yunli.util.StringUtil;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;


/**
 * @author : zhengyangyong
 */
abstract class AbstractCompressionProcessor implements CompressionProcessor {
  @Override
  public byte[] compress(byte[] input) throws IOException {
    return compress(input, 0);
  }

  @Override
  public byte[] decompress(byte[] input) throws IOException {
    return decompress(input, 0);
  }

  @Override
  public String compressPojoToBase64String(Object obj) throws IOException {
    if (obj == null) {
      return null;
    }
    return new String(Base64.getEncoder().encode(compressPojoToBytes(obj)), StandardCharsets.UTF_8);
  }

  @Override
  public byte[] compressPojoToBytes(Object obj) throws IOException {
    if (obj == null) {
      return null;
    }
    return compress(JsonUtil.writeValueAsString(obj).getBytes(StandardCharsets.UTF_8));
  }

  @Override
  public <T> T decompressPojoFromBase64String(String data, Class<T> type) throws IOException {
    if (StringUtil.isEmpty(data)) {
      return null;
    }
    return JsonUtil.readValue(new String(decompress(Base64.getDecoder().decode(data.getBytes(StandardCharsets.UTF_8))),
        StandardCharsets.UTF_8), type);
  }

  @Override
  public <T> T decompressPojoFromBytes(byte[] data, Class<T> type) throws IOException {
    if (CollectionUtil.isNullOrEmpty(data)) {
      return null;
    }
    return JsonUtil.readValue(new String(decompress(data), StandardCharsets.UTF_8), type);
  }

  @Override
  public <T> List<T> decompressPojoListFromBytes(byte[] data, Class<T> type) throws IOException {
    if (CollectionUtil.isNullOrEmpty(data)) {
      return null;
    }
    return JsonUtil.readListValue(new String(decompress(data), StandardCharsets.UTF_8), type);
  }
}
