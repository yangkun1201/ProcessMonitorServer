package com.tzc.yk.MonitorService.enums;

public enum QrCodeScanStatus {
    SUCCESS(0),
    FAILURE(1);

    private int value;

    QrCodeScanStatus(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
