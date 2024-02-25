package com.personal.assisent.Hub.entity.postgres;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity(name = "questions")
@Table(name = "questions", schema = "leetcode")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "question_id")
    private UUID questionId;
    private String title;
    private String topic;
    private Boolean isImportant;
    private String noteLink;
    @Column(insertable = false, updatable = false)
    private LocalDateTime lastUpdateDt = null;

    @Column(insertable = false, updatable = false)
    private String lastModifiedBy = null;

    @OneToMany(cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", referencedColumnName = "question_id")
    private List<Tag> tag;

    @OneToMany(cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", referencedColumnName = "question_id")
    private List<Record> record ;

    public Question(UUID questionId, String title, String topic, Boolean isImportant, String noteLink) {
        this.questionId = questionId;
        this.title = title;
        this.topic = topic;
        this.isImportant = isImportant;
        this.noteLink = noteLink;
    }
}