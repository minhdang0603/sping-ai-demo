package com.minhdang.spingaidemo.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.ResponseFormat;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Configuration
@RequiredArgsConstructor
public class AiConfiguration {

    @Value("classpath:prompts/system-prompt.st")
    private Resource systemPrompt;

    @Value("classpath:prompts/response-schema.json")
    private Resource responseSchema;

    @Bean
    ChatClient chatClient(ChatModel chatModel) throws IOException {
        String promptContent = StreamUtils.copyToString(systemPrompt.getInputStream(), StandardCharsets.UTF_8);
        String responseSchemaContent = StreamUtils.copyToString(responseSchema.getInputStream(), StandardCharsets.UTF_8);

        OpenAiChatOptions options = OpenAiChatOptions.builder()
                .responseFormat(new ResponseFormat(ResponseFormat.Type.JSON_SCHEMA, responseSchemaContent))
                .build();

        return ChatClient.builder(chatModel)
                .defaultSystem(promptContent)
                .defaultAdvisors(
                        new SimpleLoggerAdvisor()
                )
                .defaultOptions(options)
                .build();
    }
}
