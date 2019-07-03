package com.bupt.ctrl.model;

public class User {
    private Integer userId;

    private String userName;

    private String userPassword;

    private Integer userIdentity;

    private String userIntro;

    public User(Integer userId, String userName, String userPassword, Integer userIdentity, String userIntro) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userIdentity = userIdentity;
        this.userIntro = userIntro;
    }

    public User() {
        super();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public Integer getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(Integer userIdentity) {
        this.userIdentity = userIdentity;
    }

    public String getUserIntro() {
        return userIntro;
    }

    public void setUserIntro(String userIntro) {
        this.userIntro = userIntro == null ? null : userIntro.trim();
    }
}