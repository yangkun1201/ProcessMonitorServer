package com.tzc.yk.MonitorService.pojo;

import java.util.List;

public class AppTimeRequest {
    String account;
    List<AppTimeItem> appStatus;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public List<AppTimeItem> getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(List<AppTimeItem> appStatus) {
        this.appStatus = appStatus;
    }
}
