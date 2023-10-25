package com.example.whats_for_dinner_ai.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Choice {

    private int index;

    private Message message;
}
