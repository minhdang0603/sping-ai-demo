package com.minhdang.spingaidemo.controller;

import com.minhdang.spingaidemo.dto.ChatRequest;
import com.minhdang.spingaidemo.dto.ChatResponse;
import com.minhdang.spingaidemo.service.ChatService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/chat")
    public ChatResponse chat(@RequestBody ChatRequest chatRequest) {
        return chatService.chat(chatRequest);
    }
}

