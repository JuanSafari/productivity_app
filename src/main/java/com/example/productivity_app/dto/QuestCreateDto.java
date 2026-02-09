package com.example.productivity_app.dto;

import com.example.productivity_app.entity.QuestType;
import lombok.Data;

@Data
public class QuestCreateDto {
    private String title;

    private String description;

    private QuestType type;

    private Integer xpReward;

}
