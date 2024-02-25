package com.personal.assisent.Hub.entity.postgres;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(schema = "leetcode", name = "tags")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID tagId;



    @Column(name = "question_id")
    private UUID questionId;

    private String tagName;
    @Column(insertable = false, updatable = false)
    private LocalDateTime lastUpdateDt;

    @Column(insertable = false, updatable = false)
    private String lastModifiedBy;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "question_id", referencedColumnName = "question_id", insertable=false, updatable=false)
//    @JsonBackReference
//    public Question question;

    public Tag(String tagName) {
        this.tagName = tagName;
    }
}
