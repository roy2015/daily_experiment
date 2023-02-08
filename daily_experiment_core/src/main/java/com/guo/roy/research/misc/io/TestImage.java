package com.guo.roy.research.misc.io;

import java.io.File;
import java.io.IOException;

import org.slf4j.LoggerFactory;

import net.coobird.thumbnailator.Thumbnails;

/**
 * 测试图片处理
 *
 * @author guojun
 * @date 2021/11/26 下午4:43
 */
public class TestImage {
  private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestImage.class);

  public static void test1() {
    try {
      Thumbnails.of(new File("/Users/apple/Downloads/1234/456.jpeg"))
          .forceSize(192,108).toFile("/Users/apple/Downloads/1234/411_slt.jpeg");
    } catch (IOException e) {
      logger.info(e.getMessage(), e);
    }
  }


  public static void main(String[] args) {
    test1();
  }
}
