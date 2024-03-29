package com.guo.roy.research.misc.javassist;

/**
 * Created by apple on 2019/4/8.
 */
public abstract class UserVO {
    private int userId;
    private String userName;
    private String userSex;//male, female;

    public UserVO() {}

    public UserVO(int userId, String userName, String userSex) {
        this.userId = userId;
        this.userName = userName;
        this.userSex = userSex;
    }

    abstract public int invokeMethod (int x, int y);

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }
}
