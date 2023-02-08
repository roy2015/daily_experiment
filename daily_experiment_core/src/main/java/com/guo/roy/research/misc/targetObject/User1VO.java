package com.guo.roy.research.misc.targetObject;

import lombok.Data;

import java.util.Date;

/**
 * Created by apple on 2019/4/8.
 */

@Data
public class User1VO extends UserVO implements java.io.Serializable {

    private static final long serialVersionUID = -6729433024891051984L;
    private int userId;
    private String userName;
    private String userSex;//male, female;
    private Date brithday;

    public User1VO() {}

    public User1VO(int userId, String userName, String userSex) {
        this.userId = userId;
        this.userName = userName;
        this.userSex = userSex;
    }


}
