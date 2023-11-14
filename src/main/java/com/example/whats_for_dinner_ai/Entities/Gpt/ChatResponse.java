package com.example.whats_for_dinner_ai.Entities.Gpt;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class ChatResponse  {

    private List<Choice> choices;

}
