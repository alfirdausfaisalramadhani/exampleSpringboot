package com.mycompany.app.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Work {
    @Id
    @GeneratedValue(generator = "UUID")
    private String workId;
    @Column(length=150, nullable=false, unique=true)
    private String workTitle;
    @Column(length=255, nullable=false)
    private String workDesc;
    @Column( nullable=false)
    private String categoryId;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

}
