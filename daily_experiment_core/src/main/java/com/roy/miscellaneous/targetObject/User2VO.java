package com.roy.miscellaneous.targetObject;

/**
 * Created by apple on 2019/4/8.
 */
public class User2VO  extends UserVO implements java.io.Serializable {

    private static final long serialVersionUID = -6729433024891051984L;
    private int userId;
    private String userName;
    private String userSex;//male, female;

    public User2VO() {}

    public User2VO(int userId, String userName, String userSex) {
        this.userId = userId;
        this.userName = userName;
        this.userSex = userSex;
    }

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

    @Override
    public String toString() {
        return "UserVO{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userSex='" + userSex + '\'' +
                '}';
    }
}
