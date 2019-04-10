package com.tzc.yk.MonitorService.pojo;

public class AppTimeResponse {

    String account;
    String soft;
    int curTime;
    int totalTime;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getSoft() {
        return soft;
    }

    public void setSoft(String soft) {
        this.soft = soft;
    }

    public int getCurTime() {
        return curTime;
    }

    public void setCurTime(int curTime) {
        this.curTime = curTime;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }
}
