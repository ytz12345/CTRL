package com.bupt.ctrl.model;

public class User {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sdrb..user.User_id
     *
     * @mbggenerated Thu Jul 11 11:15:57 CST 2019
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sdrb..user.User_Name
     *
     * @mbggenerated Thu Jul 11 11:15:57 CST 2019
     */
    private String userName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sdrb..user.User_Password
     *
     * @mbggenerated Thu Jul 11 11:15:57 CST 2019
     */
    private String userPassword;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sdrb..user.User_Identity
     *
     * @mbggenerated Thu Jul 11 11:15:57 CST 2019
     */
    private Integer userIdentity;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sdrb..user.User_Intro
     *
     * @mbggenerated Thu Jul 11 11:15:57 CST 2019
     */
    private String userIntro;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sdrb..user.User_Avatar
     *
     * @mbggenerated Thu Jul 11 11:15:57 CST 2019
     */
    private String userAvatar;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sdrb..user.User_id
     *
     * @return the value of sdrb..user.User_id
     *
     * @mbggenerated Thu Jul 11 11:15:57 CST 2019
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sdrb..user.User_id
     *
     * @param userId the value for sdrb..user.User_id
     *
     * @mbggenerated Thu Jul 11 11:15:57 CST 2019
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sdrb..user.User_Name
     *
     * @return the value of sdrb..user.User_Name
     *
     * @mbggenerated Thu Jul 11 11:15:57 CST 2019
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sdrb..user.User_Name
     *
     * @param userName the value for sdrb..user.User_Name
     *
     * @mbggenerated Thu Jul 11 11:15:57 CST 2019
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sdrb..user.User_Password
     *
     * @return the value of sdrb..user.User_Password
     *
     * @mbggenerated Thu Jul 11 11:15:57 CST 2019
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sdrb..user.User_Password
     *
     * @param userPassword the value for sdrb..user.User_Password
     *
     * @mbggenerated Thu Jul 11 11:15:57 CST 2019
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sdrb..user.User_Identity
     *
     * @return the value of sdrb..user.User_Identity
     *
     * @mbggenerated Thu Jul 11 11:15:57 CST 2019
     */
    public Integer getUserIdentity() {
        return userIdentity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sdrb..user.User_Identity
     *
     * @param userIdentity the value for sdrb..user.User_Identity
     *
     * @mbggenerated Thu Jul 11 11:15:57 CST 2019
     */
    public void setUserIdentity(Integer userIdentity) {
        this.userIdentity = userIdentity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sdrb..user.User_Intro
     *
     * @return the value of sdrb..user.User_Intro
     *
     * @mbggenerated Thu Jul 11 11:15:57 CST 2019
     */
    public String getUserIntro() {
        return userIntro;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sdrb..user.User_Intro
     *
     * @param userIntro the value for sdrb..user.User_Intro
     *
     * @mbggenerated Thu Jul 11 11:15:57 CST 2019
     */
    public void setUserIntro(String userIntro) {
        this.userIntro = userIntro == null ? null : userIntro.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sdrb..user.User_Avatar
     *
     * @return the value of sdrb..user.User_Avatar
     *
     * @mbggenerated Thu Jul 11 11:15:57 CST 2019
     */
    public String getUserAvatar() {
        return userAvatar == null ? "images/defaultAvatar.jpg" : userAvatar;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sdrb..user.User_Avatar
     *
     * @param userAvatar the value for sdrb..user.User_Avatar
     *
     * @mbggenerated Thu Jul 11 11:15:57 CST 2019
     */
    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar == null ? null : userAvatar.trim();
    }
}