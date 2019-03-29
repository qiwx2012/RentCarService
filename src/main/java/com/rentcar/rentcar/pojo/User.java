package com.rentcar.rentcar.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class User {
    public int authStatus;
    public BigDecimal balance;
    public int customerId;
    public String endTime;
    public boolean firstRecharge;
    public String inviteCode;
    public int memberLevel;
    public int pushStatus;
    public boolean setPayPassword;
    public String userName;
    public int memberStatus;//会员状态 0：非会员 1：会员 2：会员到期
    public int cityId;
    public String cityName;
    private int customerType;// 0 个人用户  1 企业用户
    private String phoneNum;

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    /**
     * 登录独有字段
     * createTime : 2017-08-01 22:51:20
     * token : 89fc15ed26b2dd251c70f95ef7c09075
     */
    public String createTime;
    public String token;

    public int getAuthStatus() {
        return authStatus;
    }

    public void setAuthStatus(int authStatus) {
        this.authStatus = authStatus;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public boolean isFirstRecharge() {
        return firstRecharge;
    }

    public void setFirstRecharge(boolean firstRecharge) {
        this.firstRecharge = firstRecharge;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public int getMemberLevel() {
        return memberLevel;
    }

    public void setMemberLevel(int memberLevel) {
        this.memberLevel = memberLevel;
    }

    public int getPushStatus() {
        return pushStatus;
    }

    public void setPushStatus(int pushStatus) {
        this.pushStatus = pushStatus;
    }

    public boolean isSetPayPassword() {
        return setPayPassword;
    }

    public void setSetPayPassword(boolean setPayPassword) {
        this.setPayPassword = setPayPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getMemberStatus() {
        return memberStatus;
    }

    public void setMemberStatus(int memberStatus) {
        this.memberStatus = memberStatus;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getCustomerType() {
        return customerType;
    }

    public void setCustomerType(int customerType) {
        this.customerType = customerType;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}