package com.example.productivity_app.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Data
public class Quest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private QuestType type;

    private Integer xpReward;

    private Boolean completed;

    private LocalDateTime completedAt;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @ToString.Exclude // Prevent circular reference in toString
    @EqualsAndHashCode.Exclude // Prevent circular reference in equals/hashCode
    private User owner;
}
