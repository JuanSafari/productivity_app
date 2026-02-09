package com.example.productivity_app.dto;

import com.example.productivity_app.entity.Quest;
import com.example.productivity_app.entity.QuestType;
import lombok.Data;

@Data
public class QuestCreateResponseDto {
    private String title;

    private String description;

    private QuestType type;

    private Integer xpReward;

    public QuestCreateResponseDto(Quest quest) {
        this.title = quest.getTitle();
        this.description = quest.getDescription();
        this.type = quest.getType();
        this.xpReward = quest.getXpReward();
    }

}
