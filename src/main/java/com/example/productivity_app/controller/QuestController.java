package com.example.productivity_app.controller;

import com.example.productivity_app.dto.QuestCreateDto;
import com.example.productivity_app.dto.QuestCreateResponseDto;
import com.example.productivity_app.entity.Quest;
import com.example.productivity_app.service.QuestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quests")
class QuestController {
    private final QuestService questService;

    QuestController(QuestService questService) {
        this.questService = questService;
    }

    @PostMapping()
    public ResponseEntity<QuestCreateResponseDto> createQuest(
            @RequestParam Long userId,
            @RequestBody QuestCreateDto questCreateDto) {

        Quest quest = questService.createQuest(userId, questCreateDto);

        QuestCreateResponseDto responseDto = new QuestCreateResponseDto(quest);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }
}
