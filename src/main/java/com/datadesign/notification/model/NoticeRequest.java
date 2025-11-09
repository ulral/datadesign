package com.datadesign.notification.model;

import lombok.Data;

@Data
public class NoticeRequest {
    private String message;
    private int duration; // 초 단위
}
