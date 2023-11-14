package com.example.whats_for_dinner_ai.Entities.Gpt;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    private String role;

    private String content;


}
