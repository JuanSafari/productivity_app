package com.example.productivity_app.service;

import com.example.productivity_app.dto.QuestCreateDto;
import com.example.productivity_app.entity.Quest;
import com.example.productivity_app.entity.User;
import com.example.productivity_app.repository.QuestRepository;
import com.example.productivity_app.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class QuestService {
    private final QuestRepository questRepository;
    private final UserRepository userRepository;

    public QuestService(QuestRepository questRepository, UserRepository userRepository) {
        this.questRepository = questRepository;
        this.userRepository = userRepository;
    }

    public Quest createQuest(Long userId, QuestCreateDto dto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Quest quest = new Quest();

        quest.setTitle(dto.getTitle());
        quest.setDescription(dto.getDescription());
        quest.setType(dto.getType());
        quest.setXpReward(dto.getXpReward());
        quest.setOwner(user);
        quest.setCompleted(false);

        return questRepository.save(quest);
    }
}
