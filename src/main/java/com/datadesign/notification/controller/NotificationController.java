package com.datadesign.notification.controller;

import com.datadesign.notification.model.NoticeRequest;
import com.datadesign.notification.service.SseEmitterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@RequiredArgsConstructor
public class NotificationController {

    private final SseEmitterService sseEmitterService;

    @GetMapping("/subscribe")
    public SseEmitter subscribe() {
        return sseEmitterService.createEmitter();
    }

    @PostMapping("/notify")
    public ResponseEntity<String> notifyAll(@RequestBody NoticeRequest request) {
        sseEmitterService.sendToAll(request.getMessage(), request.getDuration());
        return ResponseEntity.ok("공지 전송 완료");
    }


}
