package com.roy.research.targetObject;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author guojun
 * @date 2022/4/29 下午4:52
 */
@Data
@Accessors(chain = true)
public class TplBeanVO  implements java.io.Serializable {

  private static final long serialVersionUID = -6729433024891051984L;
  private int userId;
  private String userName;
  private String userSex;//male, female;
}
