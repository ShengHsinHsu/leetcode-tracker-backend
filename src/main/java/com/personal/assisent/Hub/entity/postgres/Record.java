package com.personal.assisent.Hub.entity.postgres;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(schema = "leetcode", name = "records")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID recordId;

    @Column(name = "question_id")
    private UUID questionId;

    private LocalDateTime finishedDate;
    private Boolean isPass;

    @Column(insertable = false, updatable = false)
    private LocalDateTime lastUpdateDt;

    @Column(insertable = false, updatable = false)
    private String lastModifiedBy;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "question_id", referencedColumnName = "question_id", insertable=false, updatable=false)
//    @JsonBackReference
//    private Question question;

//    public Record(UUID questionId) {
//        this.questionId = questionId;
//    }

    public Record(LocalDateTime finishedDate, Boolean isPass) {
        this.finishedDate = finishedDate;
        this.isPass = isPass;
    }
}
